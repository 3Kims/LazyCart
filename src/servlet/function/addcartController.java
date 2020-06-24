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
		
		String path = "index.jsp";
		String url = request.getParameter("url");
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
