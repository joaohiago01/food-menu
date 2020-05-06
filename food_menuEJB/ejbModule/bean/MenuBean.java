package bean;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;

import bean.remote.MenuBeanRemote;
import dao.MenuJPA_DAO;
import entity.Menu;
import entity.Product;

@Stateless
public class MenuBean implements MenuBeanRemote {

	private MenuJPA_DAO menuJPA_DAO = MenuJPA_DAO.getInstance();
	
	public void create(Menu menu) throws SQLException{
		// TODO Auto-generated method stub
		menuJPA_DAO.persist(menu);
	}

	public void delete(Menu menu) throws SQLException{
		// TODO Auto-generated method stub
		menuJPA_DAO.remove(menu);
	}

	public void deleteById(int id) throws SQLException{
		// TODO Auto-generated method stub
		menuJPA_DAO.removeById(id);
	}

	public List<Menu> read() throws SQLException{
		// TODO Auto-generated method stub
		return menuJPA_DAO.findAll();
	}

	public List<Product> readAllProducts(Menu menu) throws SQLException{
		// TODO Auto-generated method stub
		return menuJPA_DAO.findAllProducts(menu);
	}

	public Menu readById(int id) throws SQLException{
		// TODO Auto-generated method stub
		return menuJPA_DAO.getById(id);
	}

	public void update(Menu menu) throws SQLException{
		// TODO Auto-generated method stub
		menuJPA_DAO.merge(menu);
	}
}

