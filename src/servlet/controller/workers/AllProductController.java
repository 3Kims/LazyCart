package servlet.controller.workers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EzbasketDAOImpl;
import model.VO.ProductVO;
import servlet.controller.Controller;

public class AllProductController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response){
		System.out.println("AllProductController start...");
		String path="";
		HttpSession session=request.getSession();
		
		try {
			ArrayList<ProductVO> productList=EzbasketDAOImpl.getInstance().searchAllProducts();
			session=request.getSession();
			session.setAttribute("productList", productList);
			System.out.println("AllProductController success.. productList in session...");
		}
		catch (SQLException e1) {
			System.out.println("AllProductController sql error...");
			e1.printStackTrace();	
		}
		return new ModelAndView(path);	
	}
}
