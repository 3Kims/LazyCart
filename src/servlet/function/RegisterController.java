package servlet.function;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.customerVO;
import model.ezbasketDAOImpl;
import servlet.controller.ModelAndView;

public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String path = "registerSuccess.jsp";
		
		System.out.println("1. 폼값을 받아옵니다..");//추후 삭제
		String id = request.getParameter("id");
		String password= request.getParameter("password1");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone1")+request.getParameter("phone2")+request.getParameter("phone3");
		String address = request.getParameter("roadAddress");
		System.out.println(id+password+name+phone+address);

		//2.VO 객체 생성
		System.out.println("2. customerVO 생성..");
		customerVO customer= new customerVO(id,password,"img/default.png",name,address,phone);
		ezbasketDAOImpl.getInstance().registerCustomer(customer);
		if(customer!=null) request.setAttribute("customer",customer);		
		return new ModelAndView(path);
	}
}
