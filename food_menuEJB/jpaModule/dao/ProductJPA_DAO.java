package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import entity.CategoryProduct;
import entity.Product;

public class ProductJPA_DAO {

	private static ProductJPA_DAO instance;
	@PersistenceContext(name = "FoodMenu")
	protected EntityManager entityManager;

	public static ProductJPA_DAO getInstance(){
		if (instance == null){
			instance = new ProductJPA_DAO();
		}

		return instance;
	}

	private ProductJPA_DAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FoodMenu");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
	
	public Product getById(final int id) throws SQLException{
		return entityManager.find(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAllByCategory(CategoryProduct category) throws SQLException{
		return entityManager.createQuery("FROM " + 
				Product.class.getName() + 
				" WHERE CATEGORY_ID = " + category.getId()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> findAll() throws SQLException{
		return entityManager.createQuery("FROM " + 
				Product.class.getName()).getResultList();
	}

	public void persist(Product product) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(product);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Product product) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(product);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Product product) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			product = entityManager.find(Product.class, product.getId());
			entityManager.remove(product);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) throws SQLException{
		try {
			Product product = getById(id);
			remove(product);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
