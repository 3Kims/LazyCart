package servlet.function;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CustomerVO;
import model.EzbasketDAO;
import model.EzbasketDAOImpl;
import model.ProductVO;
import servlet.controller.ModelAndView;
import servlet.parser.ParserMapping;

public class AddCartController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AddCartController start...");
		EzbasketDAO dao = null;
		String path = "main.jsp";
		CustomerVO customer= (CustomerVO)request.getSession().getAttribute("customer"); //get customer from session
		String id = customer.getId();
		String url = request.getParameter("url");					  //get shoppingmall url..
		ProductVO product = ParserMapping.getInstance().createParser(url); //run parser by url..
		if (id == null || id.equals(""))
			System.out.println("AddCartController >>> No session id...controller");	
		else{
			try{
				dao = EzbasketDAOImpl.getInstance();
				dao.addcart(product, id);
				System.out.println("Add item into Cart success...controller");
				
				System.out.println("Get current user's cartList...controller");
				ArrayList<ProductVO> productList = dao.getUsersProducts(id);
				request.getSession().setAttribute("productList", productList);
				System.out.println("Get cartList success...controller");
			}
			catch (SQLException e) {
				System.out.println("AddCartController sql error...");
				e.printStackTrace();	
			}
		}
		return new ModelAndView(path);	
	}
}
