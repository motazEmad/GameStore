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

import dto.User;

import businessLayer.CreditProcessor;

/**
 * Servlet implementation class AddCreditSerial
 */
public class AddCreditSerial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ServletContext context;
    public AddCreditSerial() {
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
		String serial=request.getParameter("serial");
		String serialvalue=request.getParameter("value");

		
		
		//String email=user.getEmail();
		Pattern pattern=Pattern.compile("\\d{10}");
		Matcher matcher=pattern.matcher(serial);
		serial=serial.trim();
		
		if(!matcher.matches())
		{
			request.setAttribute("Msg", "Invalid .. Must Be Numeric of Length 10 !!");
		}
		else
		{
			int value=Integer.parseInt(serialvalue);
			float notfound=(float)(((CreditProcessor) context.getAttribute("creditProcessor")).checkSerial(serial));
			if(notfound==-1)
			{
				((CreditProcessor) context.getAttribute("creditProcessor")).addSerial(serial, value);
				request.setAttribute("Msg", "Done !!");
				
			}
			else
			{
				request.setAttribute("Msg", "Used Before");
			}
			
	 }
		request.getRequestDispatcher("addSerial.jsp").include(request, response);
	}
}
