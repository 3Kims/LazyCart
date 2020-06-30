package servlet.analysis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CustomerVO;
import model.EzbasketDAOImpl;
import model.ProductVO;
import servlet.controller.ModelAndView;
import servlet.function.Controller;

public class ProductsByShop implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ProductsByShop start...");
		String path = "main.jsp";
		int Coupang=0;
		int Auction=0;
		int Musinsa=0;
		int[] arr= new int[3];
		
		String id = request.getParameter("id");
		try {
			ArrayList<ProductVO> products=EzbasketDAOImpl.getInstance().getUsersProducts(id);
			int total=products.size();//전체 상품 수
			for(ProductVO p:products) {
				if(p.getShop()=="coupang")
					Coupang+=1;
				else if(p.getShop()=="Auction")
					Auction+=1;
				else if(p.getShop()=="Musinsa")
					Musinsa+=1;
			}
			arr[0]=Coupang/total;
			arr[1]=Auction/total; 
			arr[2]=Musinsa/total;
			request.setAttribute("data",arr);
		} catch (SQLException e) {
		}
		return new ModelAndView(path);
	}

}
