package servlet.controller.workers;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EzbasketDAOImpl;
import model.VO.CustomerVO;
import model.VO.ProductVO;
import servlet.controller.Controller;
import servlet.parser.ParserMapping;
public class DeleteCustomerController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("DeleteCustomerController start...");
		String path = "main.jsp";
		CustomerVO customer = null;
		HttpSession session = request.getSession();
		customer = (CustomerVO) session.getAttribute("customer");
		if (customer!=null) {
			try {
				EzbasketDAOImpl.getInstance().deleteCustomer(customer.getId());
				session.removeAttribute("customer");//????
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DeleteCustomerController 오류.... 세션에 아이디가 등록되어있지 않습니다.");
		}
		return new ModelAndView(path);	
	}
}