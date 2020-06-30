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

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.CustomerVO;
import model.EzbasketDAO;
import model.EzbasketDAOImpl;
import servlet.controller.ModelAndView;


@MultipartConfig (fileSizeThreshold=1024*1024*10, maxFileSize=1024*1024*50, maxRequestSize=1024*1024*100)  
public class ChangeProfileController implements Controller {
	
	private static final String UPLOAD_DIR = "filefolder";
	
	public ChangeProfileController() {}

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response){
		System.out.println("ChangeProfileController start...");
		EzbasketDAO dao = null;
		String path = "fileResult.jsp";
		
		CustomerVO customer = (CustomerVO) request.getSession().getAttribute("customer");
		String customerId = customer.getId();
	
		// 서버의 실제 경로
		String applicationPath = request.getServletContext().getRealPath("");
		String uploadFilePath = applicationPath + UPLOAD_DIR;
				
		System.out.println(" LOG :: [서버 루트 경로] :: " + applicationPath);
		System.out.println(" LOG :: [파일 저장 경로] :: " + uploadFilePath);
				
		// creates the save directory if it does not exists
		File fileSaveDir = new File(uploadFilePath);
				
		// 파일 경로 없으면 생성
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}

		String fileName = null;
	    //Get all the parts from request and write it to the file on server
	    try {
			for (Part part : request.getParts()) {
				getPartConfig(part);
			    fileName = getFileName(part);
			    System.out.println(" LOG :: [ 업로드 파일 경로 ] :: " + uploadFilePath + File.separator + fileName);
			    part.write(uploadFilePath + File.separator + fileName);
			}
		} catch (IOException | ServletException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    request.setAttribute("fileName", fileName);
	    
	    
	    
	    
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
	
	private void getPartConfig(Part part) {
		System.out.println("------------------------------------------------------------");
		System.out.println(" LOG :: [HTML태그의 폼태그 이름] :: " + part.getName());
		System.out.println(" LOG :: [ 파일 사이즈 ] :: " + part.getSize());
		for(String name : part.getHeaderNames()) {
			System.out.println(" LOG :: HeaderName :: " + name + ", HeaderValue :: " + part.getHeader(name) + "\n");
		}
		System.out.println("------------------------------------------------------------");
	}
	private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println(" LOG :: content-disposition 헤더 :: = "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
            	System.out.println(" LOG :: 파일 이름 :: " + token);
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
}
