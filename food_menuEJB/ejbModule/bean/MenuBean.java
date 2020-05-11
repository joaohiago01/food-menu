package bean;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import dao.MenuJPA_DAO;
import entity.Menu;
import entity.Product;

@Stateless
@Remote
public class MenuBean {

	private MenuJPA_DAO menuJPA_DAO = MenuJPA_DAO.getInstance();
	
	public void create(Menu menu) throws SQLException{
		
		menuJPA_DAO.persist(menu);
	}

	public void delete(Menu menu) throws SQLException{
		
		menuJPA_DAO.remove(menu);
	}

	public void deleteById(int id) throws SQLException{
		
		menuJPA_DAO.removeById(id);
	}

	public List<Menu> read() throws SQLException{
		
		return menuJPA_DAO.findAll();
	}

	public List<Product> readAllProducts(Menu menu) throws SQLException{
		
		return menuJPA_DAO.findAllProducts(menu);
	}

	public Menu readById(int id) throws SQLException{
		
		return menuJPA_DAO.getById(id);
	}

	public void update(Menu menu) throws SQLException{
		
		menuJPA_DAO.merge(menu);
	}
}

