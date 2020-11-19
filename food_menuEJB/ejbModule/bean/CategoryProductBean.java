package bean;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import dao.CategoryProductJPA_DAO;
import entity.Category;

@Stateless
@Local
public class CategoryProductBean {

	private CategoryProductJPA_DAO categoryProductJPA_DAO = CategoryProductJPA_DAO.getInstance();

	public void create(Category categoryProduct) throws SQLException{

		categoryProductJPA_DAO.persist(categoryProduct);
	}

	public void delete(Category categoryProduct) throws SQLException{

		categoryProductJPA_DAO.remove(categoryProduct);
	}

	public void deleteById(int id) throws SQLException{

		categoryProductJPA_DAO.removeById(id);
	}

	public List<Category> read() throws SQLException{

		return categoryProductJPA_DAO.findAll();
	}

	public Category readById(int id) throws SQLException{

		return categoryProductJPA_DAO.getById(id);
	}

	public Category update(Category categoryProduct) throws SQLException{

		return categoryProductJPA_DAO.merge(categoryProduct);
	}
}
