package servlet.function;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.customerVO;
import model.ezbasketDAO;
import model.ezbasketDAOImpl;
import servlet.controller.ModelAndView;

public class ChangeProfileController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("ChangeProfileController start...");
		ezbasketDAO dao = null;
		String path = "fileResult.jsp";
		
		String fileSource = (String) request.getAttribute("fileSource");
		customerVO customer = (customerVO) request.getSession().getAttribute("customer");
		System.out.println("get file, customer success...");
		dao = ezbasketDAOImpl.getInstance();
		dao.changeUsersImg(customer.getId(), fileSource);
		
		System.out.println("change user img success..");
		
		customer = dao.searchCustomer(customer.getId());
		
		System.out.println("search customer success....");
		HttpSession session=request.getSession();
		if(customer!=null) {
			session.setAttribute("customer",customer);	
			return new ModelAndView(path);
		}
		else return null;
	}
}
