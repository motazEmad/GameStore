package servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import businessLayer.ProfileProcessor;
import dto.User;

public class EditUser extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		User user = (User)req.getSession().getAttribute("user");
		
		user.setName((String)req.getAttribute("user-name"));
		user.setBirthday((Date)req.getAttribute("user-birthdate"));
		user.setAddress((String)req.getAttribute("user-address"));
		user.setJob((String)req.getAttribute("user-job"));
		user.setInterests((String)req.getAttribute("user-interests"));
		user.setEmail((String)req.getAttribute("user-email"));
		
		ProfileProcessor profileProcessor = (ProfileProcessor) context.getAttribute("profileProcessor");
		profileProcessor.updateUser(user);
	}

}
