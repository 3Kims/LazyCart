package servlet.function.user.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.ModelAndView;
import servlet.function.Controller;

public class PasswordAjaxController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response){
		System.out.println("PasswordAjaxController start...");
		String path="pwCheckResult.jsp";
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");

		if(password1.equals(password2)) {
			request.setAttribute("result","Each password is same...controller");
			System.out.println("PasswordAjaxController success...");
		}
		else 
			request.setAttribute("result","password is different");
		
		return new ModelAndView (path);
	}
}

