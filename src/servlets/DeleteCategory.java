package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLayer.CategoryProcessor;

/**
 * Servlet implementation class DeleteCategory
 */
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ServletContext context;
    public DeleteCategory() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String catName=(String)request.getParameter("cname");
		
		boolean isDeleted=((CategoryProcessor) context
				.getAttribute("categoryProcessor")).deleteCategory(catName);
		
		if(isDeleted)
		{
			response.sendRedirect("../admin/admin.jsp?deleted=1");
		}
		else if(!isDeleted)
		{
			response.sendRedirect("../admin/admin.jsp?deleted=0");
		}
		
		
	}
}

