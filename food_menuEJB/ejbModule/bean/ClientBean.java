package bean;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;

import bean.remote.ClientBeanRemote;
import dao.ClientJPA_DAO;
import entity.Client;

@Stateless
public class ClientBean implements ClientBeanRemote {
	
	private ClientJPA_DAO clientJPA_DAO = ClientJPA_DAO.getInstance();

	public void create(Client client) throws SQLException{
		// TODO Auto-generated method stub
		clientJPA_DAO.persist(client);
	}

	public void delete(Client client) throws SQLException{
		// TODO Auto-generated method stub
		clientJPA_DAO.remove(client);
	}

	public void deleteById(int id) throws SQLException{
		// TODO Auto-generated method stub
		clientJPA_DAO.removeById(id);
	}

	public Client signIn(String email, String password) throws SQLException{
		// TODO Auto-generated method stub
		return clientJPA_DAO.signIn(email, password);
	}

	public List<Client> read() throws SQLException{
		// TODO Auto-generated method stub
		return clientJPA_DAO.findAll();
	}

	public Client readById(final int id) throws SQLException{
		// TODO Auto-generated method stub
		return clientJPA_DAO.getById(id);
	}

	public void update(Client client) throws SQLException{
		// TODO Auto-generated method stub
		clientJPA_DAO.merge(client);
	}
}
