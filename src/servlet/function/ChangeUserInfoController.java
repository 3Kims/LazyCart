package servlet.function;

import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.customerVO;
import model.ezbasketDAOImpl;
import servlet.controller.ModelAndView;

public class ChangeUserInfoController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String path = "main.jsp";
		
		System.out.println("1. 폼값을 받아옵니다..");
		
		String id = request.getParameter("id");
		String password= request.getParameter("password1");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone1")+request.getParameter("phone2")+request.getParameter("phone3");
		String address = request.getParameter("roadAddress");
		System.out.println(id+password+name+phone+address);

		//2.VO 객체 생성
		System.out.println("2. customerVO 생성..");
		customerVO customer = new customerVO(id,password,name,address,phone);
		ezbasketDAOImpl.getInstance().changeUserInfo(customer);
		HttpSession session=request.getSession();
		session.setAttribute("customer",customer);		
		return new ModelAndView(path);
	}
}
