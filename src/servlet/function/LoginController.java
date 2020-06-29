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

public class LoginController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("LoginController start...");

		CustomerVO customer = null;
		ArrayList<ProductVO> productList = null;
		String path = "main.jsp";
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		try {
			customer = EzbasketDAOImpl.getInstance().login(id, password);
			productList = EzbasketDAOImpl.getInstance().getUsersProducts(id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("LoginController sql error...");
		}
		if (customer == null)
			path = "LoginError.jsp";
		else {
			request.getSession().setAttribute("customer", customer);
			request.getSession().setAttribute("productList", productList);
			System.out.println("LoginController success..");
		}
		HashMap<String, ArrayList<String>> categoryList = new HashMap<>();
		HashSet<String> shopList = new HashSet<>();
		int[] priceList = new int[2];
		
		if(productList.size()>1) {
			int max = 0;
			int min = productList.get(0).getPrice();
			for (ProductVO p : productList) {
				System.out.println("반복문 시작");
				// 가격 비교
				if (p.getName() == null) {
					continue;
				}
				if (p.getPrice() > max) {
					max = p.getPrice();
				}
				if (p.getPrice() < min) {
					min = p.getPrice();
				}
				// 카테고리 추가
				String[] categories = p.getCategory().split(">");
				if (categories.length < 2) {
					categoryList.put(categories[0], new ArrayList<String>());
				} else {
					if (categoryList.containsKey(categories[0])) {
						categoryList.get(categories[0]).add(categories[1]);
					} else {
						categoryList.put(categories[0], new ArrayList<String>());
						categoryList.get(categories[0]).add(categories[1]);
					}

				}
				// 샵 추가
				shopList.add(p.getShop());

			}
			// 가격 배열 생성
			
			priceList[0] = min;
			priceList[1] = max;
		}
		
		

		request.getSession().setAttribute("categoryList", categoryList);
		request.getSession().setAttribute("shopList", shopList);
		request.getSession().setAttribute("priceList", priceList);

		return new ModelAndView(path,true);
	}
}