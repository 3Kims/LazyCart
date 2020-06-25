package servlet.function;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ezbasketDAOImpl;
import model.productVO;
import servlet.controller.ModelAndView;
import servlet.parser.ParserMapping;

public class addcartController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		
		String path = "main.jps";
		String url = request.getParameter("url");
		
		String id = "";
		id = (String) request.getSession().getAttribute("id");
		productVO product = ParserMapping.getInstance().createParser(url);
		if (id=="") {
			System.out.println("addcartController >>> session id 확인불가");
			return new ModelAndView(path);	
		} else {
			try {
				ezbasketDAOImpl dao = ezbasketDAOImpl.getInstance();
				dao.addcart(product, id);
				System.out.println("item add success...");
				ArrayList<productVO> productList = dao.getUsersProducts(id);
				request.getSession().setAttribute("productList", productList);
				return new ModelAndView(path);
			} catch (SQLException e1) {
				System.out.println("error addcartController addcart.");
				e1.printStackTrace();
				return new ModelAndView(path);	
			}
		}
	}
}
