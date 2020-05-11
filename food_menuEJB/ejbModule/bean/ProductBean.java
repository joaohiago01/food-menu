package bean;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import dao.ProductJPA_DAO;
import entity.CategoryProduct;
import entity.Product;

@Stateless
@Remote
public class ProductBean {

	private ProductJPA_DAO productJPA_DAO = ProductJPA_DAO.getInstance();
	
	public void create(Product product) throws SQLException{
		
		productJPA_DAO.persist(product);
	}

	public void delete(Product product) throws SQLException{
		
		productJPA_DAO.remove(product);
	}

	public void deleteById(int id) throws SQLException{
		
		productJPA_DAO.removeById(id);
	}

	public List<Product> read() throws SQLException{
		
		return productJPA_DAO.findAll();
	}

	public List<Product> readByCategory(CategoryProduct categoryProduct) throws SQLException{
		
		return productJPA_DAO.findAllByCategory(categoryProduct);
	}

	public Product readById(int id) throws SQLException{
		
		return productJPA_DAO.getById(id);
	}

	public void update(Product product) throws SQLException{
		
		productJPA_DAO.merge(product);
	}
}
