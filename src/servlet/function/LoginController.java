package servlet.function;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.cj.Session;
import model.CustomerVO;
import model.EzbasketDAOImpl;
import model.ProductVO;
import servlet.controller.ModelAndView;
public class LoginController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response){
		System.out.println("LoginController start...");
		
		CustomerVO customer = null;
		ArrayList<ProductVO> productList = null;
		String path="main.jsp";
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		try {
			customer=EzbasketDAOImpl.getInstance().login(id, password);
			productList = EzbasketDAOImpl.getInstance().getUsersProducts(id);
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("LoginController sql error...");
		}
		if(customer == null) 
			path="LoginError.jsp";
		else {
			request.getSession().setAttribute("customer", customer);
			request.setAttribute("productList", productList);
			System.out.println("LoginController success..");
		}
		return new ModelAndView(path);	
	}
}