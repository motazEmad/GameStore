package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLayer.GamesProcessor;
import businessLayer.ProfileProcessor;
import dto.User;







/**
 * Servlet implementation class GetImage
 */
public class GetImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ServletContext context;
    public GetImage() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gameName = request.getParameter("Game");
		String profile = request.getParameter("Profile");
		
		byte[] image = null;
		if(gameName != null)
			image = ((GamesProcessor) context.getAttribute("gamesProcessor")).getImage(gameName);
		else if(profile != null) {
			User user = (User) request.getSession().getAttribute("user");
			if(user != null) {
				if(user.getType() == User.ADMIN_TYPE) 
					image = ((ProfileProcessor)context.getAttribute("profileProcessor")).getUser(profile).getImage();
				else
					image = user.getImage();
			}
		}
		
		if (image != null) {
			response.setContentType("image/jpeg");
			response.setContentLength(image.length);
			response.getOutputStream().write(image);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
