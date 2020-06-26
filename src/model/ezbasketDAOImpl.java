package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.config.ServerInfo;



public class ezbasketDAOImpl implements ezbasketDAO {

	private DataSource ds;
	private static ezbasketDAOImpl dao = new ezbasketDAOImpl();
	private ezbasketDAOImpl() {
		try {
			//Naming Service(JNDI API)...javax.naming.Context
			InitialContext ic = new InitialContext();			
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource  Lookup Success...");
		}catch(NamingException e) {
			System.out.println("DataSource  Lookup Fail...");
		}	
	}	
	public static ezbasketDAOImpl getInstance() {
		return dao;
	}

/*	@Override
	public Connection getConnection() throws SQLException {
		 TODO Auto-generated method stub
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("디비연결 성공....");
		return conn;
	}
	

  	private static ezbasketDAOImpl dao = new ezbasketDAOImpl();
 
  	private ezbasketDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource  Lookup 성공...");
		}catch(NamingException e) {
			System.out.println("DataSource  Lookup 실패...");
		}
	}
	
	public static ezbasketDAOImpl getInstance() {
		return dao;
	}*/

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("getConnection Success");
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null)	rs.close();
		closeAll(ps, conn);	
	}

	@Override
	public int registerProduct(productVO product) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int newProductId = 0;
		
		try {
			System.out.println("registerProduct start..");
			conn=  getConnection();
			String query = "INSERT INTO product (name, price, shop, url, category, img) VALUES(?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, product.getName());
			ps.setInt(2, product.getPrice());
			ps.setString(3, product.getShop());
			ps.setString(4, product.getUrl());
			ps.setString(5, product.getCategory());
			ps.setString(6, product.getImg());
			
			
			System.out.println(ps.executeUpdate()+" registerProduct success..");
			
			String getproductIdQuery="select id from product where url=?";
			ps = conn.prepareStatement(getproductIdQuery);
			ps.setString(1,product.getUrl());
			rs = ps.executeQuery();
			rs.next();
			newProductId = rs.getInt("id");
			System.out.println("registerProduct success..");
			return newProductId;
		}finally {
			closeAll(rs, ps, conn);
		}
		
	}

	@Override
	public void registerCustomer(customerVO customer) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			System.out.println("registerCustomer start..");
			conn=  getConnection();
			String query ="INSERT INTO customer(id, password, img, name, address, phone) values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);

			ps.setString(1, customer.getId());
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getImg());
			ps.setString(4, customer.getName());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getPhone());
			
			System.out.println(ps.executeUpdate()+" registerCustomer success..");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	@Override
	public void addcart(productVO product, String customerId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		System.out.println("addcart start..");
		
		int productId = getProductIdByUrl(product.getUrl());
		if(productId == 0){ //product에 없으면 
			productId = registerProduct(product);	//product테이블에 추가
		}
		else {							//product테이블에 있으면
			int productQuantity = getQuantityById(customerId, productId);
			if(productQuantity != 0) { //카트에 이미 사용자가 담은 상품이라면
				changeQuantity(customerId, productId); //카트의 수량만 업데이트   기본 +1이네..
				return;
			}
		}
		//카트에 담는 로직
		try {
			conn = getConnection();
			String addProductInCartQuery = "insert into cart(customer_id, product_id, quantity, date) values(?, ?, ?, ?)";
			ps = conn.prepareStatement(addProductInCartQuery);
			ps.setString(1, customerId);
			ps.setInt(2, productId);
			ps.setInt(3, 1);
			String date = java.time.LocalDate.now().toString();
			ps.setString(4, date);
			
			ps.executeUpdate();
			System.out.println("addcart success..");
		}finally {
			closeAll(ps,  conn);
		}
		
	}
	
	@Override
	public ArrayList<customerVO> searchAllCustomers() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<customerVO> customers = new ArrayList<>();
		try {
			System.out.println("searchAllCustomer start...");
			
			conn = getConnection();
			String query = "SELECT * FROM customer";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				customers.add(new customerVO(rs.getString("id"),
										rs.getString("password"),
										rs.getString("img"),
										rs.getString("name"),
										rs.getString("address"),
										rs.getString("phone")));
			}
			System.out.println("searchAllCustomer success...");
		}finally {
			closeAll(rs, ps, conn);
		}
		return customers;
	}
	
	@Override
	public customerVO searchCustomer(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		customerVO customer = null;
		
		try {
			System.out.println("searchCustomer start...");
			conn = getConnection();
			String query = "SELECT * FROM customer WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				customer = new customerVO(rs.getString("id"),
						rs.getString("password"),
						rs.getString("img"),
						rs.getString("name"),
						rs.getString("address"),
						rs.getString("phone"));
			//System.out.println("customerVO vo:"+vo);
			System.out.println("searchCustomer success...");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			closeAll(rs, ps, conn);
		}
		return customer;
	}
	
	@Override
	public ArrayList<productVO> searchAllProducts() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		
		ArrayList<productVO> products = new ArrayList<productVO>();
		try {
			System.out.println("searchAllProducts start...");
			conn = getConnection();
			String query = "SELECT * FROM product";
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();

			while(rs.next()) {
				products.add(new productVO(rs.getInt("id"),rs.getString("name"),rs.getInt("price"),
							rs.getString("shop"),rs.getString("url"),rs.getString("category"),
							rs.getString("img")));
			}
			System.out.println("searchAllProducts success...");
		}finally {
			closeAll(rs,ps,conn);
		}
		return products;
	}

	public ArrayList<productVO> getUsersProducts(String customerId) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		
		ArrayList<productVO> products = new ArrayList<productVO>();
		try {
			System.out.println("getUsersProducts start...");
			conn = getConnection();
			String query = "select p.id, p.name, p.price, p.shop, p.url, p.category, p.img from cart c, product p where customer_id=? and c.product_id=p.id";
			ps=conn.prepareStatement(query);
			ps.setString(1, customerId);
			rs=ps.executeQuery();
			while(rs.next()) {
				products.add(new productVO(rs.getInt("id"),rs.getString("name"),rs.getInt("price"),
							rs.getString("shop"),rs.getString("url"),rs.getString("category"),
							rs.getString("img")));
			}
			System.out.println("getUsersProducts success...");
		}finally {
			closeAll(rs,ps,conn);
		}
		return products;
	}
	
	@Override
	public productVO getProductByUrl(String url) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		productVO product = new productVO();
		try {
			System.out.println("getProductByUrl start...");
			conn = getConnection();
			String query = "SELECT * FROM product where url=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, url);
			rs=ps.executeQuery();
			if(rs.next()) {
				product = new productVO(rs.getInt("id"),
										rs.getString("name"),
										rs.getInt("price"), 
										rs.getString("shop"),
										rs.getString("url"),
										rs.getString("category"), 
										rs.getString("img") 
										);
			}
			System.out.println("getProductByUrl success...");
		}finally {
			closeAll(rs,ps,conn);
		}
		return product;
	}

	public productVO getProductById(int productId) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		productVO product = new productVO();
		try {
			System.out.println("getProductById start...");
			conn = getConnection();
			String query = "SELECT * FROM product where id=?";
			ps=conn.prepareStatement(query);
			ps.setInt(1, productId);
			rs=ps.executeQuery();
			if(rs.next()) {
				product = new productVO(rs.getInt("id"),rs.getString("name"),rs.getInt("price"), rs.getString("shop"),rs.getString("url"),rs.getString("category"), rs.getString("img"));
			}
			System.out.println("getProductById success...");
		}finally {
			closeAll(rs,ps,conn);
		}
		return product;
	}
	
	
	@Override
	public int getQuantityById(String customerId, int productId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		
		try {
			System.out.println("getQuantityById start...");
			conn = getConnection();
			String query = "select quantity from cart where customer_id=? and product_id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, customerId);
			ps.setInt(2, productId);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("getQuantityById success...");
				return rs.getInt("quantity");
			}else {
				System.out.println("no prouduct in cart...");
				return 0;
			}
			
		}finally {
			closeAll(rs, ps, conn);
		}
	}
	
	
	@Override
	public int getProductIdByUrl(String url) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		
		try {
			System.out.println("getProductIdByUrl start...");
			conn = getConnection();
			String query = "select id from product where url=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, url);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("getProductIdByUrl success...");
				return rs.getInt("id");
			}else {
				System.out.println("there is no product...");
				return 0;
			}
		}finally {
			closeAll(rs, ps, conn);
		}
	}
	
	@Override
	public void changeQuantity(String customerId, int productId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			System.out.println("changeQuantity start..");
			conn = getConnection();
			String query = "update cart set quantity = quantity+1 where customer_id=? and product_id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, customerId);
			ps.setInt(2, productId);
			ps.executeUpdate();
			System.out.println("changeQuantity success..");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	@Override
	public void changeUserInfo(customerVO customer) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			System.out.println("changeUserInfo start..");
			conn = getConnection();
			String query = "update customer set password=?, name=?, address=?, phone=? where id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, customer.getPassword());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getPhone());
			ps.setString(5, customer.getId());
			
			ps.executeUpdate();
			System.out.println("changeUserInfo success..");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	@Override
	public void changeUsersImg(String customerId, String imgSrc) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			System.out.println("changeUsersImg start..");
			conn = getConnection();
			String query = "update customer set img=? where id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, imgSrc);
			ps.setString(2, customerId);
			
			ps.executeUpdate();
			System.out.println("changeUsersImg success..");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	@Override
	public void deleteUsersAllProduct(String customerId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			System.out.println("deleteUsersAllProduct start..");
			conn = getConnection();
			String query = "delete from cart where customer_id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, customerId);
			
			ps.executeUpdate();
			System.out.println("deleteUsersAllProduct success..");
		}finally {
			closeAll(ps, conn);
		}
	}
	
	@Override
	public void deleteCustomer(String customerId) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			System.out.println("deleteCustomer start..");
			conn = getConnection();
			String query = "delete from customer where id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, customerId);
			
			ps.executeUpdate();
			System.out.println("deleteCustomer success..");
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void deleteCustomerImg(String customerId) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			System.out.println("deleteCustomerImg start..");
			conn = getConnection();
			String query = "update customer set img=? where id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, "");
			ps.setString(2, customerId);
			
			ps.executeUpdate();
			System.out.println("deleteCustomerImg success..");
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public customerVO login(String id,String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		customerVO customer=null;
		cartVO cart=new cartVO();
		try {
			conn=  getConnection();
			String query ="SELECT customer.id,customer.password,customer.img,customer.name,customer.address,customer.phone,cart.product_id,cart.quantity,cart.date FROM (select * from customer where id=? and password=?) AS customer JOIN cart AS cart ON customer.id=cart.customer_id";
			ps = conn.prepareStatement(query);
			ps.setString(1,id);
			ps.setString(2,password);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				customer=new customerVO(rs.getString("id"),
						rs.getString("password"),
						rs.getString("img"),
						rs.getString("name"),
						rs.getString("address"),
						rs.getString("phone"),
						new cartVO(rs.getInt("product_id"),rs.getInt("quantity"),rs.getDate("date")));
			}
			System.out.println("customer : imple에서 출력"+customer);
		}finally {
			closeAll(ps, conn);
		}
		return customer;
	
	}


	
	
	/*public static void main(String[] args) throws ClassNotFoundException {
		ezbasketDAOImpl dao= new ezbasketDAOImpl("URL");
		String[] imglist = {"first","second", "third", "tutorial"};
		productVO vo = new productVO(1, "lee", 100, "homeplus", "www.dert.com", "category", imglist);
		try {
			dao.registerProduct(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}

