package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import entity.CategoryProduct;

public class CategoryProductJPA_DAO {

	private static CategoryProductJPA_DAO instance;
	@PersistenceContext(unitName = "FoodMenu")
	protected EntityManager entityManager;

	public static CategoryProductJPA_DAO getInstance(){
		if (instance == null){
			instance = new CategoryProductJPA_DAO();
		}

		return instance;
	}

	private CategoryProductJPA_DAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FoodMenu");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
	
	public CategoryProduct getById(final int id) throws SQLException{
		return entityManager.find(CategoryProduct.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<CategoryProduct> findAll() throws SQLException{
		return entityManager.createQuery("FROM " + 
				CategoryProduct.class.getName()).getResultList();
	}

	public void persist(CategoryProduct categoryProduct) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(categoryProduct);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(CategoryProduct categoryProduct) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(categoryProduct);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(CategoryProduct categoryProduct) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			categoryProduct = entityManager.find(CategoryProduct.class, categoryProduct.getId());
			entityManager.remove(categoryProduct);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) throws SQLException{
		try {
			CategoryProduct categoryProduct = getById(id);
			remove(categoryProduct);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
