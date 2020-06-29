package servlet.function;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.CustomerVO;
import model.EzbasketDAO;
import model.EzbasketDAOImpl;
import servlet.controller.ModelAndView;

public class ChangeProfileController implements Controller {
	
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response){
		System.out.println("ChangeProfileController start...");
		EzbasketDAO dao = null;
		String path = "fileResult.jsp";
		
		CustomerVO customer = (CustomerVO) request.getSession().getAttribute("customer");
		String customerId = customer.getId();
					
		String fileRoute = (String)request.getParameter("fileRoute");
		String fileName = (String)request.getParameter("fileName");

		
		String tempStorePath = "c:/temp"; 
		String storePath = "c:/store"; 
		try { 
			DiskFileItemFactory diskFactory = new DiskFileItemFactory(); 
			diskFactory.setSizeThreshold(4096); //업로드시 사용할 임시 메모리
			diskFactory.setRepository(new File(tempStorePath)); //임시저장폴더 
			ServletFileUpload upload = new ServletFileUpload(diskFactory); 
			upload.setSizeMax(100 * 1024 * 1024); //100MB : 전체 최대 업로드 파일 크기 
			
			@SuppressWarnings("unchecked") 
			List<FileItem> items = upload.parseRequest(request); 
			Iterator iter = items.iterator(); 
			while(iter.hasNext()) { 
				FileItem item = (FileItem) iter.next(); 
				if(item.isFormField()){ //파일이 아닌경우 
					String fieldName = item.getFieldName(); 
					String fieldValue = item.getString("UTF-8");
				} else { //파일인 경우 
					if (item.getSize() > 0) { 
						String newFileName = UUID.randomUUID().toString(); 
						String name = item.getFieldName(); 
						fileName = item.getName(); 
						String contentType = item.getContentType(); 
						long fileSize = item.getSize(); 
						Path newFilePath = Paths.get(storePath+"/"+newFileName); 
						File uploadedFile = newFilePath.toFile(); 
						item.write(uploadedFile); //파일 저장 
					} 
				} 
			} 
		} catch(Exception e) {
			;
		}
	
		try {
			dao = EzbasketDAOImpl.getInstance();
			
			dao.changeUsersImg(customer.getId(), "img/"+customerId+"/"+fileName);
			System.out.println("Change user's img success...controller");
			
			customer = dao.searchCustomer(customer.getId());
			System.out.println("Get customer success...controller");
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("ChangeProfileController sql error...");
		}
		request.getSession().setAttribute("customer",customer);	
		return new ModelAndView(path);
	}
}
