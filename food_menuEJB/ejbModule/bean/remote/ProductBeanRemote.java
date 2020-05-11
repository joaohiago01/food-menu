package bean.remote;

import java.sql.SQLException;
import java.util.List;

import entity.CategoryProduct;
import entity.Product;

public interface ProductBeanRemote {

	public void create (Product product) throws SQLException;

	public void delete (Product product) throws SQLException;

	public void deleteById (final int id) throws SQLException;

	public List<Product> read () throws SQLException;
	
	public List<Product> readByCategory (CategoryProduct categoryProduct) throws SQLException;

	public Product readById (final int id) throws SQLException;

	public void update (Product product) throws SQLException;
}
