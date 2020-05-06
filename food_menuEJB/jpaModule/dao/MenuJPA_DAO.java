package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import entity.Menu;
import entity.Product;

public class MenuJPA_DAO {

	private static MenuJPA_DAO instance;
	@PersistenceContext(name = "FoodMenu")
	protected EntityManager entityManager;

	public static MenuJPA_DAO getInstance(){
		if (instance == null){
			instance = new MenuJPA_DAO();
		}

		return instance;
	}

	private MenuJPA_DAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FoodMenu");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
	
	public Menu getById(final int id) throws SQLException{
		return entityManager.find(Menu.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts(Menu menu) throws SQLException{
		return entityManager.createQuery("SELECT P.NAME, P.PRICE, P.DESCRIPTION"
				+ " FROM MENU M JOIN M.PRODUCTS P" + 
				" WHERE P.MENU_ID = :idMenu").setParameter("idMenu", menu.getId()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Menu> findAll() throws SQLException{
		return entityManager.createQuery("FROM " + 
				Menu.class.getName()).getResultList();
	}

	public void persist(Menu menu) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(menu);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Menu menu) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(menu);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Menu menu) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			menu = entityManager.find(Menu.class, menu.getId());
			entityManager.remove(menu);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) throws SQLException{
		try {
			Menu menu = getById(id);
			remove(menu);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
