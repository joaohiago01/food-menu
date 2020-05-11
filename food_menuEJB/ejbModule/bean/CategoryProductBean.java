package bean;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import dao.CategoryProductJPA_DAO;
import entity.CategoryProduct;

@Stateless
@Remote
public class CategoryProductBean {

	private CategoryProductJPA_DAO categoryProductJPA_DAO = CategoryProductJPA_DAO.getInstance();
	
	public void create(CategoryProduct categoryProduct) throws SQLException{
		
		categoryProductJPA_DAO.persist(categoryProduct);
	}

	public void delete(CategoryProduct categoryProduct) throws SQLException{
		
		categoryProductJPA_DAO.remove(categoryProduct);
	}

	public void deleteById(int id) throws SQLException{
		
		categoryProductJPA_DAO.removeById(id);
	}

	public List<CategoryProduct> read() throws SQLException{
		
		return categoryProductJPA_DAO.findAll();
	}

	public CategoryProduct readById(int id) throws SQLException{
		
		return categoryProductJPA_DAO.getById(id);
	}

	public void update(CategoryProduct categoryProduct) throws SQLException{
		
		categoryProductJPA_DAO.merge(categoryProduct);
	}
}
