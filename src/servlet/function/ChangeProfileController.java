package servlet.function;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerVO;
import model.EzbasketDAO;
import model.EzbasketDAOImpl;
import servlet.controller.ModelAndView;

public class ChangeProfileController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response){
		System.out.println("ChangeProfileController start...");
		EzbasketDAO dao = null;
		String path = "fileResult.jsp";
		
		String fileName = "img/"+(String)request.getParameter("fileName");
		
		CustomerVO customer = (CustomerVO) request.getSession().getAttribute("customer");
		System.out.println("Get file, customer success...controller");
		
		try {
			dao = EzbasketDAOImpl.getInstance();
			
			dao.changeUsersImg(customer.getId(), fileName);
			System.out.println("Change user's img success...controller");
			
			customer = dao.searchCustomer(customer.getId());
			System.out.println("Get customer success...controller");
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("ChangeProfileController sql error...");
		}
		request.getSession().setAttribute("customer",customer);	
		return new ModelAndView(path);
	}
}
