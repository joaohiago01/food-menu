package bean;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import dao.ProductJPA_DAO;
import entity.Menu;
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

	public Product readById(int id) throws SQLException{

		return productJPA_DAO.getById(id);
	}

	public List<Product> readAllProducts(Menu menu) throws SQLException {
		
		return productJPA_DAO.findAllProducts(menu);
	}
	
	public Product update(Product product) throws SQLException{

		return productJPA_DAO.merge(product);
	}

}
