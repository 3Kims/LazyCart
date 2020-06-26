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

import model.customerVO;
import model.ezbasketDAOImpl;
import model.productVO;
import servlet.controller.ModelAndView;

public class UserProductController implements Controller {
	ArrayList<productVO> productList =new ArrayList<productVO>();
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String path="main.jsp";
		HttpSession session=request.getSession();
		String cutomer =session.getAttribute("customer").toString();
		System.out.println(cutomer);
		productList = ezbasketDAOImpl.getInstance().getUsersProducts(cutomer);
		System.out.println("세션에 저장");
		return new ModelAndView(path);
	}

}
