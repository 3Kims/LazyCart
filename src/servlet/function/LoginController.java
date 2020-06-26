package servlet.function;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.cj.Session;
import model.customerVO;
import model.ezbasketDAOImpl;
import model.productVO;
import servlet.controller.ModelAndView;
public class LoginController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path="main.jsp";
		// 2. dao 리턴 받고 biz로직 호출
		customerVO customer=ezbasketDAOImpl.getInstance().login(id, password);
		System.out.println(customer);
		System.out.println("로그인 서블릿 vo:"+customer);
		ArrayList<productVO> productList = ezbasketDAOImpl.getInstance().getUsersProducts(id);
		
		if(customer == null) path="LoginError.jsp";
		else {
			request.getSession().setAttribute("customer", customer);
			System.out.println("customer 세션에 저장");
			request.setAttribute("productList", productList);
			System.out.println(productList);
			for (productVO pro : productList) {
				System.out.println(pro.toString());
			}
			System.out.println("product 세션에 저장");
			
//			HttpSession session=request.getSession();
//			System.out.println(session.toString());
//			session.setAttribute("customer", customer);
//			Cookie cookie = new Cookie("id", "ilovejoohyuk");
//			response.addCookie(cookie);
//			System.out.println(session.toString());
//			System.out.println("세션에 저장");
		}
		//3. 값 바인딩	
		return new ModelAndView(path);
	}
}