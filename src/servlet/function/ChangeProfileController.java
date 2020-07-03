package servlet.function;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
	
	private static final int LIMIT_SIZE_BYTES = 1024 * 1024;
	public ChangeProfileController() {}

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response){
		System.out.println("ChangeProfileController start...");
		EzbasketDAO dao = null;
		String path = "main.jsp";
		String fileName = "";
		
		CustomerVO customer = (CustomerVO) request.getSession().getAttribute("customer");
		String customerId = customer.getId();
	
		String usersPath = request.getServletContext().getRealPath("/img/"+customerId);
		//String usersPath = "../WebContent/img/"+customerId;

		//String usersPath = "C:/Users/Playdata/github/EZbasket/WebContent/img/"+customerId;
		System.out.println(usersPath);
         
        File serverDir = new File(usersPath);
        //File projectDir = new File(projectPath);
		if(!serverDir.exists()) {
			try {
				serverDir.mkdirs();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Already folder exist...");
		}
 
		/*if(!projectDir.exists()) {
			try {
				projectDir.mkdirs();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Already folder exist...");
		}*/
		
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        fileItemFactory.setRepository(serverDir);
        fileItemFactory.setSizeThreshold(LIMIT_SIZE_BYTES);
        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
        
        try {
            List<FileItem> items = fileUpload.parseRequest(request);
            System.out.println("items: "+items);
            for (FileItem item : items) {
                if (item.isFormField()) {
                    System.out.printf("parameter name : %s, parameter value :  %s \n", item.getFieldName(), item.getString("utf-8"));
                } else {
                    System.out.printf("parameter name : %s, parameter value : %s,  filename : %s bytes \n", item.getFieldName(),
                            item.getName(), item.getSize());
                    if (item.getSize() > 0) {
                        String separator = File.separator;
                        int index =  item.getName().lastIndexOf(separator);
                        fileName = item.getName().substring(index  + 1);
                        File uploadFile = new File(usersPath +  separator + fileName);
                        item.write(uploadFile);
                    }
                }
            }
            //out.println("<h1>파일 업로드 완료</h1>");
 
        } catch (Exception e) {
            // 파일 업로드 처리 중 오류가 발생하는 경우
            e.printStackTrace();
           // out.println("<h1>파일 업로드 중 오류가  발생하였습니다.</h1>");
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
		return new ModelAndView(path, true);
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
