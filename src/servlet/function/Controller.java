package servlet.function;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.ModelAndView;


public interface Controller {
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException;
}
