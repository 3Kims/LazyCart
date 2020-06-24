package servlet.function;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.ModelAndView;

public class PasswordAjax implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String path="pwCheckResult.jsp";
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		System.out.println("여기까지 성공"+password1+password2);
		if(password1==password2) {
			request.setAttribute("result","비밀번호가 일치합니다.");}
		else request.setAttribute("result","비밀번호가 일치하지 않습니다.");
		 return new ModelAndView (path);
		}
	}

