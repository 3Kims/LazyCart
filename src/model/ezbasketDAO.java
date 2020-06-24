package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ezbasketDAO {
	
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException ;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException ;
	
	void registerProduct(productVO pvo)throws SQLException;
	void registerCustomer(customerVO cvo)throws SQLException;
	
	ArrayList<productVO> searchALLProduct();
	productVO searchProduct(int id);
	void insertProduct(productVO pvo);
	void deleteProduct(int id);
	void updateProduct(productVO pvo);
	
	ArrayList<customerVO> searchALLcustomer();
	productVO searchCustomer(int id);
	void insertCustomer(customerVO cvo);
	void deleteCustomer(int id);
	void updateProduct(customerVO cvo);
	
	productVO addcart(String url)throws SQLException;
	
}
