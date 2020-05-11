package dao;

public class ConnectionTest {

	public static void main(String[] args) {
		
		CategoryProductJPA_DAO.getInstance();
		ClientJPA_DAO.getInstance();
		MenuJPA_DAO.getInstance();
		ProductJPA_DAO.getInstance();
		RestaurantJPA_DAO.getInstance();
	}

}
