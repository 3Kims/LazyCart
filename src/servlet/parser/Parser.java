package servlet.parser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.productVO;


public interface Parser {
	public productVO handle(String url);
}
