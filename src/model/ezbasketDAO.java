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
	void registerProduct(productVO vo)throws SQLException;
	void registerCustomer(customerVO vo)throws SQLException;
	void addcart(productVO product, String userId)throws SQLException;
	
	//r
	ArrayList<customerVO> searchAllCustomers() throws SQLException;  //모든 고객 불러오기
	customerVO searchCustomer(String userId) throws SQLException; //고객아이디로 고객찾기
	
	ArrayList<productVO> searchALLProduct() throws SQLException; //모든 상품 조회(Product table에서)
	ArrayList<productVO> getUsersProducts(String userId) throws SQLException; //사용자의 장바구니 상품조회 (Cart table에서)
	productVO searchProduct(String url) throws SQLException;	//상품의 url로 가져오기
	productVO getProductById(int productId) throws SQLException; //상품의 id로 가져오기
	
	int getQuantityById(int productId) throws SQLException;
	int getProductIdByUrl(String url) throws SQLException;
	
	//u
	void changeQuantity(String userId, int productId) throws SQLException;
	void changeUserInfo(customerVO customer) throws SQLException;
	void changeUserInfo(String userId) throws SQLException;
	
	//d
	void deleteProduct(int productId) throws SQLException;
	void deleteUsersAllProduct(String userId) throws SQLException;
	void deleteCustomer(String userId) throws SQLException;
	
	
	
	
	
	
	
	//u
	
	
	void deleteCustomer(int id);
	void updateProduct(customerVO vo);
	
	//d
	
	productVO getProductFromCart()throws SQLException;
	
}
