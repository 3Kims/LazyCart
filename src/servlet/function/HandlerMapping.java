package servlet.function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerMapping {
	
	private static HandlerMapping handler = new HandlerMapping();   

	private HandlerMapping() {};
	
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	//create controller...
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("loginFrm.do")) {
			controller = new LoginController();
			System.out.println("loginfrmController.....생성");
		}else if(command.equals("registerSubmit.do")) {
			controller = new registerController();
			System.out.println("registerController.....생성");
		}else if(command.equals("addcart.do")) {
			controller = new addcartController();
			System.out.println("addcartController.....생성");
		}else if(command.equals("category.do")) {
			controller = new categoryController();
			System.out.println("categoryController.....생성");
		}
		return controller;
	}
	
}
