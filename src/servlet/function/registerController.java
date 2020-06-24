package servlet.function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.ModelAndView;

public class registerController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path = "registerSuccess.jsp";
		
		
		return new ModelAndView(path);
	}

}
