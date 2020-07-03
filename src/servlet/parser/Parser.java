package servlet.parser;
import model.VO.ProductVO;


public interface Parser {
	public ProductVO handle(String url) throws Exception;
}
