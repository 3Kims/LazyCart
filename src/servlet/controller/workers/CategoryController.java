package servlet.controller.workers;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.RequestGroupInfo;

import model.VO.ProductVO;
import servlet.controller.Controller;

public class CategoryController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("CategoryController start...");
			ArrayList<ProductVO> oldProductList = (ArrayList<ProductVO>) request.getSession().getAttribute("productList");
			ArrayList<ProductVO> newProductList = new ArrayList<>();
			ArrayList<ProductVO> finalProductList = new ArrayList<>();
			String path = "result.jsp";
			
			String keyword = request.getParameter("keyword");			
			
			String shoplist = request.getParameter("shop");
			String[] shop = shoplist.split("~");
			
			String categoryList = request.getParameter("category");
			String[] category = categoryList.split("~");
			
			String amountList = request.getParameter("amount");
			String[] amounts = amountList.split(" - ");
			int minAmount = Integer.parseInt(amounts[0]);
			int maxAmount = Integer.parseInt(amounts[1]);	
			System.out.println("CategoryController Input ::: keyword="+keyword+"/min="+minAmount+"/max="+maxAmount+"/categoryList="+categoryList+"/shopList="+shoplist);
			
/*			System.out.println("length`````````````");
			System.out.println(category.length);
			System.out.println(shop.length);
			System.out.println("toString");
			for (String z : category) {
				System.out.println(z);
			}
			for(String w : shop) {
				System.out.println(w);
			}
*/			System.out.println("``````````````````````````````");
			if (oldProductList.size() > 1) {
				
				if (shop.length==1 && category.length==1) {
					newProductList = oldProductList;
				}else if (shop.length==1 && category.length!=1) {
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
					System.out.println("Category filtering successful on MULTI CONTIONAL");
					newProductList = finalProductList;
				}
			}else {
				System.out.println("productlist size eqaul to or less than 1");
			}// 
			//////////////////// category and shop done
			System.out.println("starting price filter");
			ArrayList<ProductVO> amountedList = new ArrayList<>();
			int price = 0;
			for (ProductVO amountProd : newProductList) {
				price = amountProd.getPrice();
				if (price >= minAmount && price<=maxAmount) {
					amountedList.add(amountProd);
				}else {
					continue;
				}
			}
			///////////////// keyword
			System.out.println("starting keyword filter");
			ArrayList<ProductVO> keywordList = new ArrayList<>();
			for (ProductVO keywordProd : amountedList) {
				price = keywordProd.getPrice();
				if (keywordProd.toString().contains(keyword)) {
					keywordList.add(keywordProd);
				}else {
					continue;
				}
			}
			///////////////// done.
			newProductList = keywordList;
			System.out.println("list length ::: "+newProductList.size());
			request.getSession().setAttribute("productListByCategory", newProductList);
			System.out.println("CategoryController success...");
			return new ModelAndView(path);
		
		
		} catch (Exception e) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!! ERROR DURING CategoryController Operation !!!!!!!!!!!!!!!!!!!!!!!");
			e.printStackTrace();
			return new ModelAndView("main.jsp");

			// TODO: handle exception
		} // catch 
	
	} // handle

}// class