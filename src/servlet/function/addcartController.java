package servlet.function;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ezbasketDAO;
import model.ezbasketDAOImpl;
import model.productVO;
import servlet.controller.ModelAndView;
import servlet.parser.ParserMapping;

public class addcartController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		
		String path = "index.jsp";
		String url = request.getParameter("url");
		
		
		String id = (String) request.getSession().getAttribute("id");
		if (id==null) {
			path = "main.jsp";
			return new ModelAndView(path);
		} else {
			productVO product = ParserMapping.getInstance().createParser(url);
			try {
				ezbasketDAOImpl dao = ezbasketDAOImpl.getInstance();
				dao.addcart(product, id);
				System.out.println("Added");
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
	}
}
