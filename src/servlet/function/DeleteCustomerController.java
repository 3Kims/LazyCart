package servlet.function;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ezbasketDAOImpl;
import model.productVO;
import servlet.controller.ModelAndView;
import servlet.parser.ParserMapping;

public class DeleteCustomerController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {

		String path = "main.jsp";
		String id = "";
		HttpSession session = request.getSession();

		if (id!="") {
			try {
				id = (String) session.getAttribute("id");
				ezbasketDAOImpl.getInstance().deleteCustomer(id);
				session.removeAttribute("id");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println(
		"DeleteCustomerController 오류.... 세션에 아이디가 등록되어있지 않습니다.");
		}
		return new ModelAndView(path);	
	}
}