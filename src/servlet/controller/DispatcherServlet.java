package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import servlet.function.Controller;
import servlet.function.HandlerMapping;

@WebServlet(urlPatterns="*.do",loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;     
	//private HandlerMapping componentFactory = null;
	ModelAndView mv = null;
	String command = "";
	String path = "";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String servletpath = request.getServletPath();
		String subPath = (String) servletpath.subSequence(1, servletpath.length()-3);
		
		//componentFactory = HandlerMapping.getInstance();
		/*Controller component = componentFactory.createController(subPath);
		mv = component.handle(request, response);
		if(!mv.isRedirect())
			request.getRequestDispatcher(mv.getPath()).forward(request, response);
		else response.sendRedirect(mv.getPath());
		*/
	}//doProcess
}
	










