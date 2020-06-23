package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		//String servletpath = request.getServletPath();
		//String subPath = (String) servletpath.subSequence(1, servletpath.length()-3);
		
		String requestURI = request.getRequestURI();
		System.out.println("RequestURI :: "+requestURI); 
		String contextPath = request.getContextPath();
		
		String command=requestURI.substring(contextPath.length()+1);
		System.out.println("command :: "+command); 
		
		Controller controller = HandlerMapping.getInstance().createController(command);
		String path = "index.jsp";
		ModelAndView mv =null;
		try {
			mv = controller.handle(request, response);
			path = mv.getPath();
		} catch (Exception e) {
			System.out.println(e);
		}
		if(mv!=null) {
			if(mv.isRedirect()) response.sendRedirect(path);
			else 
				request.getRequestDispatcher(path).forward(request, response);
		}
		System.out.println("contextPath :: "+contextPath); 
	}//doProcess
}
	










