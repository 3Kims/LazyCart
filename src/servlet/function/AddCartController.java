package servlet.function;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
		CustomerVO customer=null;
		String id = "";
		try {
			customer = (CustomerVO)request.getSession().getAttribute("customer"); //get customer from session
			id = customer.getId();
		} catch (NullPointerException e) {
			path="error.jsp";
			System.out.println("에러 발생");
			System.out.println(e.getMessage());
			request.setAttribute("error", "로그인을 먼저 해주세요");
			return new ModelAndView(path);
		}
		
		String url = request.getParameter("url");					  //get shoppingmall url..
		ProductVO product = null;
		try {
			product = ParserMapping.getInstance().createParser(url); //run parser by url..
		} catch(Exception e) {
			path="error.jsp";
			e.printStackTrace();
			System.out.println("에러 발생");
			System.out.println(e.getMessage());
			request.setAttribute("error", "해당페이지에 제품을 찾지 못했습니다.");
			return new ModelAndView(path);	
		}
		ArrayList<ProductVO> productList=new ArrayList<ProductVO>();
		
		if (id.equals("")) {
			System.out.println("AddCartController >>> No session id...controller");
			path="error.jsp";
			System.out.println("에러 발생");
			request.setAttribute("error", "로그인을 먼저 해주세요");
			return new ModelAndView(path);
		}
			
		else{
			try{
				dao = EzbasketDAOImpl.getInstance();
				dao.addcart(product, id);
				System.out.println("Add item into Cart success...controller");
				
				System.out.println("Get current user's cartList...controller");
				productList = dao.getUsersProducts(id);
				request.getSession().setAttribute("productList", productList);
				System.out.println("Get cartList success...controller");
				
				int max=0; int min=productList.get(0).getPrice();
				HashMap<String,ArrayList<String>> categoryList = new HashMap<>();
				HashSet<String> shopList = new HashSet<>();
				
				for(ProductVO p: productList) {
					if(p.getName()==null) {
						continue;
					}
					//가격 비교
					if(p.getPrice()>max) {
						max = p.getPrice();
					}
					if(p.getPrice()<min) {
						min=p.getPrice();
					}					
					//카테고리 추가
					String[] categories = p.getCategory().split(">");
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
					shopList.add(p.getShop());

				}
				// 가격 배열 생성
				int[] priceList = new int[2];
				priceList[0]=min; priceList[1]=max;
				
				request.getSession().setAttribute("categoryList", categoryList);
				request.getSession().setAttribute("shopList", shopList);
				request.getSession().setAttribute("priceList", priceList);
				
				return new ModelAndView(path);	
			}
			catch (SQLException e) {
				System.out.println("AddCartController sql error...");
				e.printStackTrace();	
			}
		}
		
		return new ModelAndView(path);	
	}
}
