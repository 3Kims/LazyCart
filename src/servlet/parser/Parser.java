package servlet.parser;
import model.ProductVO;


public interface Parser {
	public ProductVO handle(String url);
}
