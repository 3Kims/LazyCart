package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EzbasketDAO {
	
	//util
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException ;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException ;
	
	//c
	int registerProduct(ProductVO product)throws SQLException;
	void registerCustomer(CustomerVO customer)throws SQLException;
	void addcart(ProductVO product, String customerId)throws SQLException;
	
	//r
	ArrayList<CustomerVO> searchAllCustomers() throws SQLException;  //모든 고객 불러오기
	CustomerVO searchCustomer(String customerId) throws SQLException; //고객아이디로 고객찾기
	
	ArrayList<ProductVO> searchAllProducts() throws SQLException; //모든 상품 조회(Product table에서)
	ArrayList<ProductVO> getUsersProducts(String customerId) throws SQLException; //사용자의 장바구니 상품조회 (Cart table에서)
	ProductVO getProductByUrl(String url) throws SQLException;	//상품의 url로 가져오기
	ProductVO getProductById(int productId) throws SQLException; //상품의 id로 가져오기
	
	int getQuantityById(String customerId, int productId) throws SQLException;
	int getProductIdByUrl(String url) throws SQLException;
	
	//u
	void changeQuantity(String customerId, int productId) throws SQLException;
	void changeUserInfo(CustomerVO customer) throws SQLException;
	void changeUsersImg(String customerId, String imgSrc) throws SQLException;
	
	//d
	void deleteUsersAllProduct(String customerId) throws SQLException;
	void deleteProduct(String customerId) throws SQLException;
	void deleteCustomer(String customerId) throws SQLException;
	void deleteCustomerImg(String customerId) throws SQLException;
	
	//others
	CustomerVO login(String id, String password) throws SQLException;
}
