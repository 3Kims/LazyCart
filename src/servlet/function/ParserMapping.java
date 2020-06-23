package servlet.function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.productVO;
import servlet.controller.Controller;
import servlet.controller.Parser;

public class ParserMapping {
	
	private static ParserMapping handler = new ParserMapping();   

	private ParserMapping() {};
	
	public static ParserMapping getInstance() {
		return handler;
	}
	
	//create controller...
	public productVO createParser(String url) {
		productVO product = null;
		if(url.toLowerCase().contains("musinsa")) {
			product = new MusinsaParser().handle(url);
			System.out.println("MusinsaParser.....생성");
		}
		return product;
	}
	
}
