package servlets;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import businessLayer.ProfileProcessor;

import dao.UserHome;
import dto.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServletContext context;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	context = config.getServletContext();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      response.sendRedirect("user/profile.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         User user = new User();

 		byte[] imageInByte=null;
 	
		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {

			// Parse the request
			//FileItemIterator iter = upload.getItemIterator(request);
			 List /* FileItem */ items = upload.parseRequest(request);  
             
             // Process the uploaded items  
             Iterator iter = items.iterator();  
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (item.isFormField()) {
					String property = item.getFieldName();
					switch (property) {
					case "username":
						user.setName(item.getString());
						break;
					case "email":
						user.setEmail(item.getString());
						break;
					case "password":
						user.setPassword(item.getString());
						break;
					case "birthday":
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
				         Date convertedDate = null;
						try {
							convertedDate = dateFormat.parse(item.getString());
						} catch (ParseException e) {
							e.printStackTrace();
						} 
						user.setBirthday(convertedDate);
						break;
					case "job":
						user.setJob(item.getString());
						break;
					case "address":
						user.setAddress(item.getString());
						break;
					case "interests":
						user.setInterests(item.getString());
						break;
					default:
						break;
					}
					
				} else {
					imageInByte = item.get();
					user.setImage(imageInByte);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		user.setType(User.USER_TYPE);
		try {
			((ProfileProcessor)context.getAttribute("profileProcessor")).registerUser(user);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("home.jsp");
		} catch(Exception e) {
			request.setAttribute("Msg", "User already exist");
			request.getRequestDispatcher("RegisterForm.jsp").include(request, response);
		}
	}

}
