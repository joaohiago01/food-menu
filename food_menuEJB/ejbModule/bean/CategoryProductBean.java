package bean;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;

import bean.remote.CategoryProductBeanRemote;
import dao.CategoryProductJPA_DAO;
import entity.CategoryProduct;

@Stateless
public class CategoryProductBean implements CategoryProductBeanRemote {

	private CategoryProductJPA_DAO categoryProductJPA_DAO = CategoryProductJPA_DAO.getInstance();
	
	public void create(CategoryProduct categoryProduct) throws SQLException{
		// TODO Auto-generated method stub
		categoryProductJPA_DAO.persist(categoryProduct);
	}

	public void delete(CategoryProduct categoryProduct) throws SQLException{
		// TODO Auto-generated method stub
		categoryProductJPA_DAO.remove(categoryProduct);
	}

	public void deleteById(int id) throws SQLException{
		// TODO Auto-generated method stub
		categoryProductJPA_DAO.removeById(id);
	}

	public List<CategoryProduct> read() throws SQLException{
		// TODO Auto-generated method stub
		return categoryProductJPA_DAO.findAll();
	}

	public CategoryProduct readById(int id) throws SQLException{
		// TODO Auto-generated method stub
		return categoryProductJPA_DAO.getById(id);
	}

	public void update(CategoryProduct categoryProduct) throws SQLException{
		// TODO Auto-generated method stub
		categoryProductJPA_DAO.merge(categoryProduct);
	}
}
