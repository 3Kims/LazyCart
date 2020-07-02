package servlet.function.user;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CustomerVO;
import model.EzbasketDAOImpl;
import servlet.controller.ModelAndView;
import servlet.function.Controller;

public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("RegisterController start...");
		
		String path = "registerSuccess.jsp";

		String id = request.getParameter("id");
		String password= request.getParameter("password1");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone1")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3");
		String address = request.getParameter("postcode")+"="+request.getParameter("roadAddress")+"="+request.getParameter("jibunAddress");
		CustomerVO customer= new CustomerVO(id,password,"img/default.png",name,address,phone);
		
		try {
			EzbasketDAOImpl.getInstance().registerCustomer(customer);
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("RegisterController sql error...");
		}
		if(customer!=null) 
			request.setAttribute("customer",customer);	
		
		return new ModelAndView(path);
	}
}
