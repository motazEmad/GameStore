package servlets;



import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import businessLayer.ProfileProcessor;
import dto.User;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserEdit
 */
public class UserEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletContext context;
	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

			
				User user = (User)req.getSession().getAttribute("user");
				
				user.setName((String)req.getParameter("user-name"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
		         Date convertedDate = null;
				try {
					if(req.getParameter("user-birthdate") != null && !req.getParameter("user-birthdate").equals(""))
						convertedDate = dateFormat.parse(req.getParameter("user-birthdate"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				user.setBirthday(convertedDate);
				user.setAddress((String)req.getParameter("user-address"));
				user.setJob((String)req.getParameter("user-job"));
				user.setInterests((String)req.getParameter("user-interests"));
				user.setEmail((String)req.getParameter("user-email"));
				
				ProfileProcessor profileProcessor = (ProfileProcessor) context.getAttribute("profileProcessor");
				profileProcessor.updateUser(user);
				
				response.sendRedirect("user/profile.jsp");
			

		}

	
	}


