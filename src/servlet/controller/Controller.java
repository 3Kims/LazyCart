package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.workers.ModelAndView;


public interface Controller {
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response);
}
