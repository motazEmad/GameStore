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
 * Servlet implementation class AddCategory
 */
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ServletContext context;
    public AddCategory() {
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
		String catName=(String)request.getParameter("CatName");
		//System.out.println("gggggggg"+catName);
		
		boolean isAdded=((CategoryProcessor) context
				.getAttribute("categoryProcessor")).addCategory(catName);
		
		if(isAdded)
		{
			request.setAttribute("Msg", "Congrats .. \n"+catName+" is added to Categories successfully !!");
		}
		else if(!isAdded)
		{
			request.setAttribute("Msg", "can't be added .. It is Already in the categories list !!");
		}
		
		request.getRequestDispatcher("../admin/addCategory.jsp").include(request, response);
	}

}
