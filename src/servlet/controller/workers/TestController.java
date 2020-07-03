package servlet.controller.workers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EzbasketDAOImpl;
import model.VO.CustomerVO;
import model.VO.ProductVO;
import servlet.controller.Controller;

public class TestController implements Controller {
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response){
		System.out.println("TestController start...");
		ArrayList<ProductVO> productList = null;
		String path="main.jsp";
		String id = request.getParameter("id");
		
		try {
			productList = EzbasketDAOImpl.getInstance().getUsersProducts(id);
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("TestController sql error...");
		}
		int max=0; 
		int min=productList.get(0).getPrice();
		HashMap<String,ArrayList<String>> categoryList = new HashMap<>();
		HashSet<String> shopList = new HashSet<>();
		
		for(ProductVO product: productList) {
			//가격 비교
			if(product.getPrice()>max) {
				max = product.getPrice();
			}
			if(product.getPrice()<min) {
				min=product.getPrice();
			}
			//카테고리 추가
			String[] categories = product.getCategory().split(">");
			if(categories.length<2) {
				categoryList.put(categories[0],new ArrayList<String>());
			}else {
				if(categoryList.containsKey(categories[0])) {
					categoryList.get(categories[0]).add(categories[1]);
				}
				else {
					categoryList.put(categories[0], new ArrayList<String>());
					categoryList.get(categories[0]).add(categories[1]);
				}
			}
			//샵 추가
			shopList.add(product.getShop());
		}
		// 가격 배열 생성
		int[] priceList = new int[2];
		priceList[0]=min; priceList[1]=max;
		
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("shopList", shopList);
		request.setAttribute("priceList", priceList);
			
		/*HttpSession session=request.getSession();
		System.out.println(session.toString());
		session.setAttribute("customer", customer);
		Cookie cookie = new Cookie("id", "ilovejoohyuk");
		response.addCookie(cookie);
		System.out.println(session.toString());
		System.out.println("세션에 저장");*/
		System.out.println("TestController success...");
		return new ModelAndView(path);
	}
}