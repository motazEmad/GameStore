package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Game;

import businessLayer.GamesProcessor;

/**
 * Servlet implementation class EditGame
 */
public class EditGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ServletContext context;
    public EditGame() {
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
		String gname=request.getParameter("gameName");
		String quantity=request.getParameter("quantity");
		String price=request.getParameter("price");
		//System.out.println(gname);
		//System.out.println(quantity);
		//System.out.println(price);
		GamesProcessor gprocessor=((GamesProcessor) context.getAttribute("gamesProcessor"));

		//int quantity=(int)Integer.parseInt((String)request.getParameter("quantity"));
		//float price=(float)Float.parseFloat((String)request.getParameter("price"));
		Game game=gprocessor.getGameByName(gname);
		if(game !=null)
		{
			gprocessor.editGame(game, Float.parseFloat(price),Integer.parseInt(quantity) );
			request.setAttribute("Msg", "Done !!");
		}
		else
		{
			request.setAttribute("Msg", " Game Not Found !!");
		}
		
		//request.getRequestDispatcher("EditGame.jsp").include(request, response);
		response.sendRedirect("../admin/admin.jsp?category=1");
	}

}
