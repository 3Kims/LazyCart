package servlet.function;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.customerVO;
import model.ezbasketDAOImpl;
import servlet.controller.ModelAndView;

public class IdCheckController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String path="idCheckResult.jsp";
		String id=request.getParameter("id");
		System.out.println("id 체크"+id);
		customerVO vo=ezbasketDAOImpl.getInstance().searchCustomer(id);
		if(id.equals(vo.getId())) {
			request.setAttribute("result",false);}
		else request.setAttribute("result",true);
		 return new ModelAndView (path);
		}
	}
