package bean;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import dao.RestaurantJPA_DAO;
import entity.Client;
import entity.Restaurant;

@Stateless
@Remote
public class RestaurantBean {

	private RestaurantJPA_DAO restaurantJPA_DAO = RestaurantJPA_DAO.getInstance();
	
	public void create(Restaurant restaurant) throws SQLException{
		
		restaurantJPA_DAO.persist(restaurant);
	}

	public void delete(Restaurant restaurant) throws SQLException{
		
		restaurantJPA_DAO.remove(restaurant);
	}

	public void deleteById(int id) throws SQLException{
		
		restaurantJPA_DAO.removeById(id);
	}

	public List<Restaurant> read() throws SQLException{
		
		return restaurantJPA_DAO.findAll();
	}

	public Restaurant readByUser(Client client) throws SQLException{
		
		return restaurantJPA_DAO.findByUser(client);
	}

	public Restaurant readById(int id) throws SQLException{
		
		return restaurantJPA_DAO.getById(id);
	}

	public void update(Restaurant restaurant) throws SQLException{
		
		restaurantJPA_DAO.merge(restaurant);
	}

	public Restaurant findByCnpj(String cnpj) {
		
		return restaurantJPA_DAO.findByCnpj(cnpj);
	}
}
