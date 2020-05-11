package bean.remote;

import java.sql.SQLException;
import java.util.List;

import entity.Client;

public interface ClientBeanRemote {

	public void create (Client client) throws SQLException;
	
	public void delete (Client client) throws SQLException;
	
	public void deleteById (final int id) throws SQLException;
	
	public Client signIn (String email, String password) throws SQLException;
	
	public List<Client> read () throws SQLException;
	
	public Client readById (final int id) throws SQLException;
	
	public void update (Client client) throws SQLException;
}
