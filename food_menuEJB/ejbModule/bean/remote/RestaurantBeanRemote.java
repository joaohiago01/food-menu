package bean.remote;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

import entity.CategoryProduct;
import entity.Client;
import entity.Restaurant;

@Remote
public interface RestaurantBeanRemote {

	public void create (Restaurant restaurant) throws SQLException;

	public void delete (Restaurant restaurant) throws SQLException;

	public void deleteById (final int id) throws SQLException;

	public List<Restaurant> read () throws SQLException;
	
	public List<Restaurant> readByUser (Client client) throws SQLException;
	
	public List<Restaurant> readByCategory (CategoryProduct categoryProduct) throws SQLException;

	public Restaurant readById (final int id) throws SQLException;

	public void update (Restaurant restaurant) throws SQLException;
}
