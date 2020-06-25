package servlet.function;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ezbasketDAOImpl;
import model.productVO;
import servlet.controller.ModelAndView;
import servlet.parser.ParserMapping;

public class addcartController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		
		String path = "";
		String url = request.getParameter("url");
		
		String id = (String) request.getSession().getAttribute("id");
		if (id==null) {
			System.out.println("addcart controller..no session...go to main.jsp");
			path = "main.jsp";
			return new ModelAndView(path);
		} else {
			System.out.println("addcart controller..session on..");
			productVO product = ParserMapping.getInstance().createParser(url);
			try {
				ezbasketDAOImpl dao = ezbasketDAOImpl.getInstance();
				dao.addcart(product, id);
				System.out.println("item add success...");
				ArrayList<productVO> productList = dao.getcart(id);
				request.getSession().setAttribute("productList", productList);
				return new ModelAndView("main.jsp");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("error addcartController addcart.");
				e1.printStackTrace();
				return new ModelAndView(path);	
			}
		}

		productVO product = ParserMapping.getInstance().createParser(url);
		try {
			ezbasketDAOImpl.getInstance().addcart(product);
			
			return new ModelAndView("addcart_success.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView(path);
		}
	}
}
