package servlet.function;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.RequestGroupInfo;

import model.ProductVO;
import servlet.controller.ModelAndView;

public class CardController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("CardController start...");
		ArrayList<ProductVO> ProductList = (ArrayList<ProductVO>) request.getSession().getAttribute("productList");
		int length = ProductList.size()-1;
		ArrayList<String> cardList = new ArrayList<>();
		int maxLength=0;
		if(length<2) {
			return new ModelAndView("error.jsp");
		}
		if(length<8) {
			maxLength=4;
		}
		if(length<18) {
			maxLength=16;
		}
		else {
			maxLength=36;
		}
		
		int count=0;
		for(ProductVO p : ProductList) {
			if(p.getName()==null)
				continue;
			if(count==maxLength)
				break;
			cardList.add(p.getImg());
			cardList.add(p.getImg());
			count+=2;
		}
		Collections.shuffle(cardList);
		request.setAttribute("cardList", cardList);
		return new ModelAndView("card.jsp");

	}
}// class