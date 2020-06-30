package servlet.analysis;
import servlet.function.Controller;

public class AnalysisMapping {	
	private static AnalysisMapping handler = new AnalysisMapping();   
	private AnalysisMapping() {};
	public static AnalysisMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("ProductsByShop.do")) {
			controller = new ProductsByShop();
			System.out.println("Create ProductsByShop Instance");
		}
		return controller;
	}
}