package bean;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;

import bean.remote.ProductBeanRemote;
import dao.ProductJPA_DAO;
import entity.CategoryProduct;
import entity.Product;

@Stateless
public class ProductBean implements ProductBeanRemote {

	private ProductJPA_DAO productJPA_DAO = ProductJPA_DAO.getInstance();
	
	public void create(Product product) throws SQLException{
		// TODO Auto-generated method stub
		productJPA_DAO.persist(product);
	}

	public void delete(Product product) throws SQLException{
		// TODO Auto-generated method stub
		productJPA_DAO.remove(product);
	}

	public void deleteById(int id) throws SQLException{
		// TODO Auto-generated method stub
		productJPA_DAO.removeById(id);
	}

	public List<Product> read() throws SQLException{
		// TODO Auto-generated method stub
		return productJPA_DAO.findAll();
	}

	public List<Product> readByCategory(CategoryProduct categoryProduct) throws SQLException{
		// TODO Auto-generated method stub
		return productJPA_DAO.findAllByCategory(categoryProduct);
	}

	public Product readById(int id) throws SQLException{
		// TODO Auto-generated method stub
		return productJPA_DAO.getById(id);
	}

	public void update(Product product) throws SQLException{
		// TODO Auto-generated method stub
		productJPA_DAO.merge(product);
	}
}
