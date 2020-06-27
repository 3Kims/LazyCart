package servlet.function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.controller.ModelAndView;

public class LogoutController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response){
		System.out.println("LogoutController start...");
		String path="main.jsp";
		HttpSession session=request.getSession();
		session.invalidate();
		System.out.println("LogoutController success...");
		return new ModelAndView(path);
	}

}
