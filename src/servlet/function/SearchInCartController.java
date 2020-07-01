package servlet.function;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CustomerVO;
import model.EzbasketDAOImpl;
import model.ProductVO;
import servlet.controller.ModelAndView;
public class SearchInCartController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response){
		System.out.println("SearchInCartController start...");
		
		CustomerVO customer = null;
		ArrayList<ProductVO> productList = null;
		String path="main.jsp";
		String keyword = request.getParameter("SearchInCartKeyword");
		HttpSession session = request.getSession();
		productList = (ArrayList<ProductVO>) session.getAttribute("productList");
		for (ProductVO product: productList) {
			if (product.toString().toLowerCase().contains(keyword)) {
				continue;
			} else {
				productList.remove(product);
			}
		}
		request.getSession().setAttribute("productList", productList);
		return new ModelAndView(path);		
	}
}