package servlet.function;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CustomerVO;
import model.EzbasketDAOImpl;
import servlet.controller.ModelAndView;

public class IdCheckController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response){
		System.out.println("IdCheckController start...");
		
		String path="idCheckResult.jsp";
		CustomerVO customer = null;
		String id=request.getParameter("id");
		
		try {
			customer = EzbasketDAOImpl.getInstance().searchCustomer(id);
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("IdCheckController sql error...");
		}
		if(id.equals(customer.getId()))
			request.setAttribute("result",false);
		else 
			request.setAttribute("result",true);
		System.out.println("IdCheckController success...");
		return new ModelAndView (path);
	}
}
