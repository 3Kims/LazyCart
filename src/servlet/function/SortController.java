package servlet.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductVO;
import servlet.controller.ModelAndView;

public class SortController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("SortController start...");
		String path = "result.jsp";
		ArrayList<ProductVO> oldProductList = (ArrayList<ProductVO>) request.getSession().getAttribute("productList");
		ArrayList<ProductVO> newProductList = new ArrayList<>();
		
		String sortContent = request.getParameter("sortContent");	
		
		if(sortContent.equals("priceSort")) {
			newProductList = radixsort(oldProductList);

		}
		else if(sortContent.equals("nameSort")) {
			newProductList = bubblesort(oldProductList);
			
		}
		request.getSession().setAttribute("productListByCategory", newProductList);
		System.out.println("SortController success...");
		return new ModelAndView(path);
	}
	
	static ArrayList<ProductVO> bubblesort(ArrayList<ProductVO> oldProductList){
		oldProductList.get(0).setName("");
		int size = oldProductList.size();
		ProductVO tempProduct = new ProductVO();
		int i = 0;
		int j = 0;
		for(i=0; i<size; i++) {
			for(j=0; j<size-i-1; j++){
				System.out.println("first: "+oldProductList.get(j).getName());
				if(oldProductList.get(j).getName().compareTo(oldProductList.get(j+1).getName()) > 0) {
					tempProduct = oldProductList.get(j);
					oldProductList.set(j, oldProductList.get(j+1));
					oldProductList.set(j+1, tempProduct);
				}
				for(ProductVO product: oldProductList) {
					System.out.println(product);
				}
			}
			for(ProductVO product: oldProductList) {
				System.out.println(product);
			}
		}
		return oldProductList;
	}
	
	
	static ArrayList<ProductVO> radixsort(ArrayList<ProductVO> oldProductList) {
		int maxProductPrice = getMax(oldProductList);
		for(int exp=1; maxProductPrice/exp>0; exp*=10) {
			oldProductList = countSort(oldProductList, exp);
		}
		return oldProductList;
	}
	
	static int getMax(ArrayList<ProductVO> oldProductList) {
		int maxPrice = oldProductList.get(0).getPrice();
		for(int i = 1; i<oldProductList.size(); i++) {
			if(oldProductList.get(i).getPrice() > maxPrice) {
				maxPrice = oldProductList.get(i).getPrice();
			}
		}
		return maxPrice;
	}
	static ArrayList<ProductVO> countSort(ArrayList<ProductVO> oldProductList, int exp) {
		
		ArrayList<ProductVO> outputProductList = new ArrayList<ProductVO>();
		for(int i = 0; i< oldProductList.size(); i++) {
			outputProductList.add(new ProductVO());
		}
		int[] count = new int[10];
		Arrays.fill(count, 0);
		
		for(int i = 0; i< oldProductList.size(); i++) {
			count[(oldProductList.get(i).getPrice()/exp)%10]++;
		}
		for(int i=1; i<10; i++) {
			count[i] += count[i-1];
		}
		for(int i=oldProductList.size()-1; i>=0; i--) {
			outputProductList.set(count[(oldProductList.get(i).getPrice()/exp)%10]-1, oldProductList.get(i));
			count[(oldProductList.get(i).getPrice()/exp)%10]--;
		}
		for(int i=0; i<oldProductList.size(); i++) {
			oldProductList.set(i, outputProductList.get(i));
		}
		return oldProductList;
	}
}
