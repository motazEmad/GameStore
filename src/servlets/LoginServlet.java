package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLayer.ProfileProcessor;
import dto.User;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// login with cookies
		String username = "";
		String password = "";
		if(request.getCookies() != null)
		
			for (int i = 0; i < request.getCookies().length; i++) {
			if (request.getCookies()[i].getName().equals("username"))
				username = request.getCookies()[i].getValue();
			else if (request.getCookies()[i].getName().equals("password"))
				password = request.getCookies()[i].getValue();
		}
		User user = new User(username, password);
		user = ((ProfileProcessor) context.getAttribute("profileProcessor"))
				.login(user);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			if (user.getType() == User.ADMIN_TYPE)
			{
				
			
				response.sendRedirect("admin/adminHome.jsp?category=1");
			}
			else if (user.getType() == User.USER_TYPE)
				response.sendRedirect("user/profile.jsp");

		} else {
			// redirect to login.jsp
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// login with parameters
		User user = new User(request.getParameter("username"), request.getParameter("password"));
		user = ((ProfileProcessor)context.getAttribute("profileProcessor")).login(user);
		if(user != null) {
			// add cookies
			if(request.getParameter("remember") != null) {
				Cookie username = new Cookie("username", user.getEmail());
				username.setMaxAge(60*60*24*10);
				response.addCookie(username);
				Cookie password = new Cookie("password", user.getPassword());
				password.setMaxAge(60*60*24*10);
				response.addCookie(password);
			}
			request.getSession().setAttribute("user", user);
			if(user.getType() == User.ADMIN_TYPE)
				response.sendRedirect("admin/admin.jsp?category=1");
			else if(user.getType() == User.USER_TYPE)
				response.sendRedirect("home.jsp");
			System.out.println(request.getSession().getAttribute("user"));
		} else {
			request.setAttribute("error", "Error in username or password");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
	}
}
