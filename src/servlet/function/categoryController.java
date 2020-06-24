package servlet.function;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.productVO;
import servlet.controller.ModelAndView;

public class categoryController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String category = request.getParameter("category");
		String option = request.getParameter("option");
		ArrayList<productVO> list = (ArrayList<productVO>) request.getAttribute("productList");
		ArrayList<productVO> rlist = new ArrayList<>();
		
		String path = "result.jsp";
		
		if(category.equals("price")) {
			String[] prices = option.split("~");
			for(productVO p: list) {
				if(Integer.parseInt(prices[0])<p.getPrice() && Integer.parseInt(prices[1])>p.getPrice()) {
					rlist.add(p);
				}
			}
			
		} else if(category.equals("category")) {
			for(productVO p: list) {
				if(p.getCategory().contains(option)) {
					rlist.add(p);
				}
			}
		} else if(category.equals("shop")) {
			for(productVO p: list) {
				if(p.getShop().equals(option)) {
					rlist.add(p);
				}
			}
		}
			
		request.setAttribute("rlist", rlist);
		
		return new ModelAndView(path);
	}

}
