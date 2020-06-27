package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.function.Controller;
import servlet.function.HandlerMapping;


@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ModelAndView mv = null;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dispatcher doget...");
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dispatcher dopost");
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dispatcher doprocess.");

		String requestURI=request.getRequestURI();		
		String contextPath=request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);	
		System.out.println("command: "+command+" extract success..");
		
		Controller controller=HandlerMapping.getInstance().createController(command);
		String path = "index.jsp";
		
		try {
			mv = controller.handle(request, response);		
			path = mv.getPath();
		}catch(Exception e) {
			System.out.println(e);
		}
		if(mv != null) {
			if(mv.isRedirect()) 
				response.sendRedirect(path);
			else 
				request.getRequestDispatcher(path).forward(request, response);
		}
	}
}






















