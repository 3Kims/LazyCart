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
	
	void registerProduct(productVO vo)throws SQLException;
	void registerCustomer(customerVO vo)throws SQLException;
	
	ArrayList<productVO> searchALLProduct() throws SQLException;
	productVO searchProduct(String url) throws SQLException;
	void deleteProduct(String url);
	void updateProduct(productVO vo);
	
	ArrayList<customerVO> searchALLcustomer() throws SQLException;
	customerVO searchCustomer(String id) throws SQLException;
	void deleteCustomer(int id);
	void updateProduct(customerVO vo);
	
	void addcart(productVO product String id)throws SQLException;
	
}
