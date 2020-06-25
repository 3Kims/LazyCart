package servlet.function;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.customerVO;
import model.ezbasketDAOImpl;
import servlet.controller.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path="main.jsp";
		// 2. dao 리턴 받고 biz로직 호출
		customerVO customer=ezbasketDAOImpl.getInstance().login(id, password);
		System.out.println("로그인 서블릿 vo:"+customer);
		if(customer == null) path="LoginError.jsp";
		else {
			HttpSession session=request.getSession();
			session.setAttribute("customer", customer);
			System.out.println("세션에 저장");
		}
		//3. 값 바인딩	
		return new ModelAndView(path);
	}
}
