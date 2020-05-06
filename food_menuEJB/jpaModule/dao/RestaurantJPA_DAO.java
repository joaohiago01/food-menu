package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import entity.CategoryProduct;
import entity.Client;
import entity.Restaurant;

public class RestaurantJPA_DAO {
	
	private static RestaurantJPA_DAO instance;
	@PersistenceContext(name = "FoodMenu")
	protected EntityManager entityManager;

	public static RestaurantJPA_DAO getInstance(){
		if (instance == null){
			instance = new RestaurantJPA_DAO();
		}

		return instance;
	}

	private RestaurantJPA_DAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FoodMenu");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
	
	public Restaurant getById(final int id) throws SQLException{
		return entityManager.find(Restaurant.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Restaurant> findAll() throws SQLException{
		return entityManager.createQuery("FROM " + 
				Restaurant.class.getName()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Restaurant> findAllByUser(Client user) throws SQLException{
		return entityManager.createQuery("FROM " + 
				Restaurant.class.getName() + 
				" WHERE USER_ID = " + user.getId()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Restaurant> findAllByCategory(CategoryProduct categoryProduct) throws SQLException{
		return entityManager.createQuery("FROM " + 
				Restaurant.class.getName() + 
				" WHERE SPECIALTY_ID = " + categoryProduct.getId()).getResultList();
	}

	public void persist(Restaurant restaurant) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(restaurant);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Restaurant restaurant) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(restaurant);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Restaurant restaurant) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			restaurant = entityManager.find(Restaurant.class, restaurant.getId());
			entityManager.remove(restaurant);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) throws SQLException{
		try {
			Restaurant restaurant = getById(id);
			remove(restaurant);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
