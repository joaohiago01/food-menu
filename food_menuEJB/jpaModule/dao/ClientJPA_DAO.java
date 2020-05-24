package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import entity.Client;

public class ClientJPA_DAO {

	private static ClientJPA_DAO instance;
	@PersistenceContext(unitName = "FoodMenu")
	protected EntityManager entityManager;

	public static ClientJPA_DAO getInstance(){
		if (instance == null){
			instance = new ClientJPA_DAO();
		}

		return instance;
	}

	private ClientJPA_DAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FoodMenu");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
	
	public Client signIn(String email, String password) throws SQLException{
		return (Client) entityManager.createQuery("FROM " + 
				Client.class.getName() + 
				" WHERE EMAIL = :email AND PASSWORD = :password").setParameter("email", email).setParameter("password", password)
				.getSingleResult();
	}
	
	public Client getById(final int id) throws SQLException{
		return entityManager.find(Client.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Client> findAll() throws SQLException{
		return entityManager.createQuery("FROM " + 
				Client.class.getName()).getResultList();
	}

	public void persist(Client user) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Client user) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(user);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Client user) throws SQLException{
		try {
			entityManager.getTransaction().begin();
			user = entityManager.find(Client.class, user.getId());
			entityManager.remove(user);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) throws SQLException{
		try {
			Client user = getById(id);
			remove(user);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

