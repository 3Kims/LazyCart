package servlet.function;

public class HandlerMapping {
	
	private static HandlerMapping handler = new HandlerMapping();   

	private HandlerMapping() {};
	
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	//create controller...
	//..
}
