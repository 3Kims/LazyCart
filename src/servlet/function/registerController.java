package servlet.function;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.customerVO;
import model.ezbasketDAOImpl;
import servlet.controller.ModelAndView;

public class registerController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		String path = "registerSuccess.jsp";
		
		System.out.println("1. 폼값을 받아옵니다..");//추후 삭제
		String id = request.getParameter("id");
		String password= request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone1")+request.getParameter("phone2")+request.getParameter("phone3");
		String address = request.getParameter("address");
		System.out.println(id+password+name+phone+address);
		
		customerVO vo=ezbasketDAOImpl.getInstance().searchCustomer(id);
		if(id.contentEquals(vo.getId());
		//2.VO 객체 생성
		System.out.println("2. customerVO 생성..");
		customerVO vo = new customerVO(id, password, name, address,phone);
		ezbasketDAOImpl.getInstance().registerCustomer(vo);
		
		if(vo!=null) request.setAttribute("vo",vo);
		return new ModelAndView(path);
		}
	}

