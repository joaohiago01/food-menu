package bean.remote;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

import entity.CategoryProduct;

@Remote
public interface CategoryProductBeanRemote {

	public void create (CategoryProduct categoryProduct) throws SQLException;

	public void delete (CategoryProduct categoryProduct) throws SQLException;

	public void deleteById (final int id) throws SQLException;

	public List<CategoryProduct> read () throws SQLException;

	public CategoryProduct readById (final int id) throws SQLException;

	public void update (CategoryProduct categoryProduct) throws SQLException;
}