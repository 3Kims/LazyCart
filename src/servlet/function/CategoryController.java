package servlet.function;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductVO;
import servlet.controller.ModelAndView;

public class CategoryController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		try {

			ArrayList<ProductVO> oldProductList = (ArrayList<ProductVO>) request.getSession().getAttribute("productList");
			ArrayList<ProductVO> newProductList = new ArrayList<>();
			ArrayList<ProductVO> finalProductList = new ArrayList<>();
			String path = "result.jsp";
			System.out.println("CategoryController start...");
			String shoplist = request.getParameter("shop");
			String[] category = request.getParameter("category").split("~");
			String[] shop = shoplist.split("~");
			System.out.println("length`````````````");
			System.out.println(category.length);
			System.out.println(shop.length);
			System.out.println("toString");
			for (String z : category) {
				System.out.println(z);
			}
			for(String w : shop) {
				System.out.println(w);
			}
			System.out.println("``````````````````````````````");
			if (oldProductList.size() > 1) {
				if (shop.length==1 && category.length!=1) {
					for (int i = 1; i < category.length; i++) {
			            System.out.println("CATEGORY FILTERING START FOR ::: "+category[i]);
			            for (ProductVO pdCat:oldProductList) {
			                if (pdCat.getName()==null) {
			                    continue;
			                }else {
			                    if(pdCat.getCategory().contains(category[i]) && !newProductList.contains(pdCat)) {
			                        System.out.println("this"+pdCat.getName()+"----- "+category[i]);
			                        newProductList.add(pdCat);
			                    }else {
			                        continue;
			                    }
			                }
			                
			            }
					}	
				} else if (shop.length!=1 && category.length==1) {
					if (shop.length>1) {
					    for (int i = 1; i < shop.length; i++) {
					            System.out.println("SHOP FILTERING START FOR ::: "+shop);
					            for (ProductVO pdShop:oldProductList) {
					                if (pdShop.getName()==null) {
					                    continue;
					                }else {
					                    if(pdShop.getShop().contains(shop[i]) && !newProductList.contains(pdShop)) {
					                        System.out.println("this"+pdShop.getName()+"----- "+shop[i]);
					                        newProductList.add(pdShop);
					                    }else {
					                        continue;
					                    }
					                }
					                
					            }
					    }
					}
				}else if (shop.length!=1 && category.length!=1) {
					
					for (int i = 1; i < category.length; i++) {
			            System.out.println("CATEGORY FILTERING START FOR ::: "+category[i]);
			            for (ProductVO pdCat:oldProductList) {
			                if (pdCat.getName()==null) {
			                    continue;
			                }else {
			                    if(pdCat.getCategory().contains(category[i]) && !newProductList.contains(pdCat)) {
			                        System.out.println("this"+pdCat.getName()+"----- "+category[i]);
			                        newProductList.add(pdCat);
			                    }else {
			                        continue;
			                    }
			                }
			                
			            }
					}
					
					for(ProductVO newp : newProductList) {
						String newpShop = newp.getShop();
						if (shoplist.contains(newpShop)) {
							finalProductList.add(newp);
						}
					}
					request.getSession().setAttribute("productListByCategory", finalProductList);
					System.out.println("CategoryController success... ON MULTI CONTIONAL");
					return new ModelAndView(path);
				}
			}
			 else {
				System.out.println("productlist size eqaul to or less than 1");
			}
			System.out.println("list length ::: "+newProductList.size());
			request.getSession().setAttribute("productListByCategory", newProductList);
			System.out.println("CategoryController success...");
			return new ModelAndView(path);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("result.jsp");

			// TODO: handle exception
		}
		
	}

}