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
	//private DataSource ds;
	
	public ezbasketDAOImpl(String serverip)throws ClassNotFoundException{
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩 성공...");
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("디비연결 성공....");
		return conn;
	}
	
/*	
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
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("디비연결 성공....");
		return ds.getConnection();
	}*/

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
	public void registerProduct(productVO vo) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn=  getConnection();
			String query = "INSERT INTO product(name, price, shop, url, category, img, option) VALUES(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성됨...registerMember");
			
			
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.setString(3, vo.getShop());
			ps.setString(4, vo.getUrl());
			ps.setString(5, vo.getCategory());
			ps.setString(6, "dskdjwk");
			ps.setString(7, vo.getOption());
			System.out.println(ps.executeUpdate()+" product INSERT OK!!");
		}finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	public void registerCustomer(customerVO cvo) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn=  getConnection();
			String query ="INSERT INTO customer(id, password, name, address, phone)";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성됨...registerMember");
			
			ps.setString(1, cvo.getId());
			ps.setString(2, cvo.getPassword());
			ps.setString(3, cvo.getName());
			ps.setString(4, cvo.getAddress());
			ps.setString(5, cvo.getPhone());
			System.out.println(ps.executeUpdate()+" customer INSERT OK!!");
			
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<productVO> searchALLProduct() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		ArrayList<productVO> product = new ArrayList<productVO>();
		try {
			conn = getConnection();
			String query = "SELECT * FROM product";
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			String[] getimg = rs.getString("img").split(" "); 
			while(rs.next()) {
				//id, name, price, shop, url, category, img, option
				product.add(new productVO(rs.getInt("id"),rs.getString("name"),rs.getInt("price"),
							rs.getString("shop"),rs.getString("url"),rs.getString("category"),
							getimg,rs.getString("option")));
			}
		}finally {
			closeAll(rs,ps,conn);
		}
		
		return product;
	}

	@Override
	public productVO searchProduct(String url) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		productVO product = new productVO();
		try {
			conn = getConnection();
			String query = "SELECT * FROM product where url=?";
			ps=conn.prepareStatement(query);
			ps.setString(1, url);
			rs=ps.executeQuery();
			String[] getimg = rs.getString("img").split(","); 
			if(rs.next()) {
				//id, name, price, shop, url, category, img, option
				product = new productVO(rs.getInt("id"),rs.getString("name"),rs.getInt("price"),
							rs.getString("shop"),rs.getString("url"),rs.getString("category"),
							getimg,rs.getString("option"));
			}
		}finally {
			closeAll(rs,ps,conn);
		}
		
		return product;
	}


	@Override
	public void deleteProduct(String url) {
		Connection conn = null;
		PreparedStatement ps = null;	
		productVO product = new productVO();
		
		
	}

	@Override
	public void updateProduct(productVO pvo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<customerVO> searchALLcustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public productVO searchCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(customerVO cvo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addcart(String url) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	public static void main(String[] args) throws ClassNotFoundException {
		ezbasketDAOImpl dao= new ezbasketDAOImpl("URL");
		String[] imglist = {"first","second", "third", "tutorial"};
		productVO vo = new productVO(1, "lee", 100, "homeplus", "www.dert.com", "category", imglist, "options");
		try {
			dao.registerProduct(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

