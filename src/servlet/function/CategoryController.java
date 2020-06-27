package servlet.function;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductVO;
import servlet.controller.ModelAndView;

public class CategoryController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("CategoryController start...");
		String category = request.getParameter("category");
		String option = request.getParameter("option");
		ArrayList<ProductVO> productList = (ArrayList<ProductVO>) request.getAttribute("productList");
		ArrayList<ProductVO> productListBycategory = new ArrayList<>();
		
		String path = "result.jsp";
		
		if(category.equals("price")) {
			String[] prices = option.split("~");
			for(ProductVO product: productList) {
				if(Integer.parseInt(prices[0])<product.getPrice() && Integer.parseInt(prices[1])>product.getPrice()) {
					productListBycategory.add(product);
				}
			}
			
		} else if(category.equals("category")) {
			for(ProductVO product: productList) {
				if(product.getCategory().contains(option)) {
					productListBycategory.add(product);
				}
			}
		} else if(category.equals("shop")) {
			for(ProductVO product: productList) {
				if(product.getShop().equals(option)) {
					productListBycategory.add(product);
				}
			}
		}	
		request.setAttribute("productListBycategory", productListBycategory);
		System.out.println("CategoryController success...");
		return new ModelAndView(path);
	}

}
