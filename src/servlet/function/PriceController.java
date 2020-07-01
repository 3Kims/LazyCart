package servlet.function;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductVO;
import servlet.controller.ModelAndView;

public class PriceController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("CategoryController start...");
		String category = request.getParameter("category");
		String option = request.getParameter("option");
		ArrayList<ProductVO> productList = (ArrayList<ProductVO>) request.getSession().getAttribute("productList");
		ArrayList<ProductVO> productListByCategory = new ArrayList<>();
		
		String path = "result.jsp";
		System.out.println("데이터 받기 성공!");System.out.println(category + " : "+option);
		if(category.equals("price")) {
			String[] prices = option.split("-");
			for(ProductVO product: productList) {
				if(product.getName()==null)
					continue;
				if(Integer.parseInt(prices[0])<product.getPrice() && Integer.parseInt(prices[1])>product.getPrice()) {
					productListByCategory.add(product);
				}
			}
		} else if(category.equals("all")) {
			productListByCategory = productList;
		}
		request.setAttribute("productListByCategory", productListByCategory);
		System.out.println("CategoryController success...");
		return new ModelAndView(path);
	}

}
