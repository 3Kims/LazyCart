package servlet.controller.workers;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.RequestGroupInfo;

import model.EzbasketDAOImpl;
import model.VO.CustomerVO;
import model.VO.ProductVO;
import servlet.controller.Controller;

public class DeleteProductController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("DeleteProductController start...");
		String path="main.jsp";
		
		
		
		HttpSession session = request.getSession();
		CustomerVO customer = (CustomerVO) session.getAttribute("customer");
		String customerId = customer.getId();
		System.out.println("customerID ==== "+ customerId);
		ArrayList<ProductVO> productList = null;
		try {
			
			String id = request.getParameter("productId");
			System.out.println("deleting product No."+id);
			EzbasketDAOImpl.getInstance().deleteProduct(id);
			
			productList = (ArrayList<ProductVO>) EzbasketDAOImpl.getInstance().getUsersProducts(customerId);
			session.setAttribute("productList", productList);
		} catch (SQLException e) {
			System.out.println("DELETEPRODUCT CONTROLLER getUsersProducts ERROR ");
			e.printStackTrace();
		}
		
		System.out.println("DeleteProductController DELETE PROCESS success...");
		return new ModelAndView(path);
	}

}
