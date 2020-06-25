package servlet.function;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ezbasketDAOImpl;
import model.productVO;
import servlet.controller.ModelAndView;

public class AllProductController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String path="";
		HttpSession session=request.getSession();
		ArrayList<productVO> product=ezbasketDAOImpl.getInstance().searchAllProducts();
		session=request.getSession();
		session.setAttribute("product", product);
		System.out.println("세션에 저장");

	return new ModelAndView(path);
	}
}
