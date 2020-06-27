package servlet.function;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerVO;
import model.EzbasketDAOImpl;
import model.ProductVO;
import servlet.controller.ModelAndView;

public class UserProductController implements Controller {
	
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response){
		System.out.println("UserProductController start...");
		ArrayList<ProductVO> productList = null;
		String path="main.jsp";
		HttpSession session=request.getSession();
		String cutomer =session.getAttribute("customer").toString();
		
		try {
			productList = EzbasketDAOImpl.getInstance().getUsersProducts(cutomer);
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("UserProductController sql error...");
		}
		request.getSession().setAttribute("productList", productList);
		System.out.println("UserProductController success...");
		return new ModelAndView(path);
	}
}
