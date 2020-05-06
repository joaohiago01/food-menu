package bean.remote;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

import entity.Menu;
import entity.Product;

@Remote
public interface MenuBeanRemote {

	public void create (Menu menu) throws SQLException;

	public void delete (Menu menu) throws SQLException;

	public void deleteById (final int id) throws SQLException;

	public List<Menu> read () throws SQLException;
	
	public List<Product> readAllProducts (Menu menu) throws SQLException;

	public Menu readById (final int id) throws SQLException;

	public void update (Menu menu) throws SQLException;
}
