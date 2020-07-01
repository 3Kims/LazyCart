package servlet.parser;
import model.ProductVO;

public class ParserMapping {
	
	private static ParserMapping handler = new ParserMapping();   

	private ParserMapping() {};
	
	public static ParserMapping getInstance() {
		return handler;
	}
	
	//create controller...
	public ProductVO createParser(String url) throws Exception {
		ProductVO product = null;
		if(url.toLowerCase().contains("musinsa")) {
			product = new MusinsaParser().handle(url);
			System.out.println("MusinsaParser.....생성");
			
		}else if(url.toLowerCase().contains("coupang")) {
			product = new CoupangParser().handle(url);
			System.out.println("Coupang.....생성");
			
		}else if(url.toLowerCase().contains("auction")) {
			product = new AuctionParser().handle(url);
			System.out.println("auction.....생성");
		}
		return product;
	}
	
}
