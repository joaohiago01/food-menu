package bean;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;

import bean.remote.RestaurantBeanRemote;
import dao.RestaurantJPA_DAO;
import entity.CategoryProduct;
import entity.Client;
import entity.Restaurant;

@Stateless
public class RestaurantBean implements RestaurantBeanRemote {

	private RestaurantJPA_DAO restaurantJPA_DAO = RestaurantJPA_DAO.getInstance();
	
	public void create(Restaurant restaurant) throws SQLException{
		// TODO Auto-generated method stub
		restaurantJPA_DAO.persist(restaurant);
	}

	public void delete(Restaurant restaurant) throws SQLException{
		// TODO Auto-generated method stub
		restaurantJPA_DAO.remove(restaurant);
	}

	public void deleteById(int id) throws SQLException{
		// TODO Auto-generated method stub
		restaurantJPA_DAO.removeById(id);
	}

	public List<Restaurant> read() throws SQLException{
		// TODO Auto-generated method stub
		return restaurantJPA_DAO.findAll();
	}

	public List<Restaurant> readByUser(Client client) throws SQLException{
		// TODO Auto-generated method stub
		return restaurantJPA_DAO.findAllByUser(client);
	}

	public List<Restaurant> readByCategory(CategoryProduct categoryProduct) throws SQLException{
		// TODO Auto-generated method stub
		return restaurantJPA_DAO.findAllByCategory(categoryProduct);
	}

	public Restaurant readById(int id) throws SQLException{
		// TODO Auto-generated method stub
		return restaurantJPA_DAO.getById(id);
	}

	public void update(Restaurant restaurant) throws SQLException{
		// TODO Auto-generated method stub
		restaurantJPA_DAO.merge(restaurant);
	}
}
