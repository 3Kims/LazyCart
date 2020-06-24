package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ezbasketDAO {
	
	//util
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException ;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException ;
	
	//c
	int registerProduct(productVO product)throws SQLException;
	void registerCustomer(customerVO customer)throws SQLException;
	void addcart(productVO product, String customerId)throws SQLException;
	
	//r
	ArrayList<customerVO> searchAllCustomers() throws SQLException;  //모든 고객 불러오기
	customerVO searchCustomer(String customerId) throws SQLException; //고객아이디로 고객찾기
	
	ArrayList<productVO> searchAllProducts() throws SQLException; //모든 상품 조회(Product table에서)
	ArrayList<productVO> getUsersProducts(String customerId) throws SQLException; //사용자의 장바구니 상품조회 (Cart table에서)
	productVO getProductByUrl(String url) throws SQLException;	//상품의 url로 가져오기
	productVO getProductById(int productId) throws SQLException; //상품의 id로 가져오기
	
	int getQuantityById(String customerId, int productId) throws SQLException;
	int getProductIdByUrl(String url) throws SQLException;
	
	//u
	void changeQuantity(String customerId, int productId) throws SQLException;
	void changeUserInfo(customerVO customer) throws SQLException;
	void changeUsersImg(String customerId, String imgSrc) throws SQLException;
	
	//d
	void deleteUsersAllProduct(String customerId) throws SQLException;
	void deleteCustomer(String customerId) throws SQLException;
	void deleteCustomerImg(String customerId) throws SQLException;
}
