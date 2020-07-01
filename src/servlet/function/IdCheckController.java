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
		
		String path="IdCheckResult.jsp";
		CustomerVO customer = null;
		String id=request.getParameter("id");
		
		try {
			customer = EzbasketDAOImpl.getInstance().searchCustomer(id);
			if(customer==null) {
				System.out.println("customer : "+ customer);
				request.setAttribute("data",true);
			}
			System.out.println("customer : "+ customer);
			request.setAttribute("data",false);//false
		}
		catch(SQLException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
		return new ModelAndView (path);
	}
}
