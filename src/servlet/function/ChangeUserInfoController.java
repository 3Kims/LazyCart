package servlet.function;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerVO;
import model.EzbasketDAOImpl;
import servlet.controller.ModelAndView;

public class ChangeUserInfoController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ChangeUserInfoController start...");
		String path = "main.jsp";
		
		String id = request.getParameter("id");
		String password= request.getParameter("password1");
		String name = request.getParameter("name");
		String address = request.getParameter("postcode")+"="+request.getParameter("roadAddress")+"="+request.getParameter("jibunAddress");
		String phone = request.getParameter("phone1")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3");
		
		
		//2.Create CustomerVO object
		CustomerVO customer= new CustomerVO(id,password,"img/default.png",name,address,phone);
		System.out.println("ChangeUserInfo:"+customer);
		try {
			EzbasketDAOImpl.getInstance().changeUserInfo(customer);
			System.out.println("ChangeUserInfoController success...");
		}
		catch(SQLException e) {
			System.out.println("ChangeUserInfoController sql errer...");
		}
		request.getSession().setAttribute("customer",customer);
		return new ModelAndView(path);
	}
}
