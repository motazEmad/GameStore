package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;

import businessLayer.GamesProcessor;
import businessLayer.CreditProcessor;
/**
 * Servlet implementation class recharge
 */
public class recharge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ServletContext context;
    public recharge() {
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
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		
		if(session.getAttribute("user")==null)
		{
			response.sendRedirect("../login.jsp");
		}
		else
		{
			String serial=request.getParameter("serial");
			User user=(User)session.getAttribute("user");
			//String email=user.getEmail();
			Pattern pattern=Pattern.compile("\\d{10}");
			Matcher matcher=pattern.matcher(serial);
			serial=serial.trim();
			
			if(!matcher.matches())
			{
				request.setAttribute("Msg",new String("Invalid Serial ..!!"));
			}
			else
			{
				float valueOfSerial=(float)(((CreditProcessor) context.getAttribute("creditProcessor")).checkSerial(serial));
				
				if(valueOfSerial==-1)
				{
					request.setAttribute("Msg",new String("Invalid Serial !!"));
					
					
				}
				else
				{
					float currentCredit=(float)(((CreditProcessor) context.getAttribute("creditProcessor")).updateCredit(valueOfSerial, user));
					request.setAttribute("Msg",new String("Done !!"));
					request.setAttribute("currentCredit",currentCredit);
					
				}
				
			
			}
			request.getRequestDispatcher("/user/recharge.jsp").include(request, response);
			
		  }
}

}
