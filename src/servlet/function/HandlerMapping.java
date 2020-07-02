package servlet.function;

import servlet.function.cart.AddCartController;
import servlet.function.cart.ajax.CategoryController;
import servlet.function.cart.ajax.SearchInCartController;
import servlet.function.product.DeleteProductController;
import servlet.function.user.ChangeProfileController;
import servlet.function.user.ChangeUserInfoController;
import servlet.function.user.DeleteCustomerController;
import servlet.function.user.LoginController;
import servlet.function.user.LogoutController;
import servlet.function.user.RegisterController;
import servlet.function.user.ajax.IdCheckController;

public class HandlerMapping {
	
	private static HandlerMapping handler = new HandlerMapping();   
	private HandlerMapping() {};
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("loginFrm.do")) {
			controller = new LoginController();
			System.out.println("Create LoginController Instance");
		}
		else if(command.equals("LoginController.do")) {
			controller = new LoginController();
			System.out.println("Create LoginController Instance.");
		}
		else if(command.equals("registerSubmit.do")) {
			controller = new RegisterController();
			System.out.println("Create RegisterController Instance");
		}
		else if(command.equals("IdCheckController.do")) {
			controller = new IdCheckController();
			System.out.println("Create IdCheckController Instance");
		}
		else if(command.equals("addcart.do")) {
			controller = new AddCartController();
			System.out.println("Create AddCartController Instance.");
		}
		else if(command.equals("category.do")) {
			controller = new CategoryController();
			System.out.println("Create CategoryController Instance");
		}
		else if(command.equals("ChangeUserInfoController.do")) {
			controller = new ChangeUserInfoController();
			System.out.println("Create ChangeUserInfoController Instance");
		}else if(command.equals("SearchInCart.do")) {
			controller = new SearchInCartController();
			System.out.println("Create SearchInCartController Instance");
		}
			else if(command.equals("LogoutController.do")) {
			controller = new LogoutController();
			System.out.println("Create LogoutController Instance");
		}
		else if(command.equals("DeleteCustomer.do")) {
			controller = new DeleteCustomerController();
			System.out.println("Create DeleteCustomerController Instance");
		}else if(command.equals("profileImg.do")) {
			controller = new ChangeProfileController();
			System.out.println("Create ChangeProfileController Instance");
		}else if(command.equals("DeleteProduct.do")) {
			controller = new DeleteProductController();
			System.out.println("Create DeleteProductController Instance");
		}
		return controller;
	}
}