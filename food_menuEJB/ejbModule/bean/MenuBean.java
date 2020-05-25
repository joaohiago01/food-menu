package bean;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import dao.MenuJPA_DAO;
import entity.Menu;

@Stateful
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

	public Menu readById(int id) throws SQLException{
		
		return menuJPA_DAO.getById(id);
	}

	public void update(Menu menu) throws SQLException{
		
		menuJPA_DAO.merge(menu);
	}

	public Menu findByRestaurant(int id) {
		return menuJPA_DAO.findByRestaurant(id);
	}
}

