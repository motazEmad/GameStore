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
 * Servlet implementation class DeleteGame
 */
public class DeleteGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ServletContext context;
    public DeleteGame() {
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

		String gname=(String)request.getParameter("gameName");
		GamesProcessor gprocessor=((GamesProcessor) context.getAttribute("gamesProcessor"));
		Game game=gprocessor.getGameByName(gname);
		if(game !=null)
		{
			gprocessor.deleteGame(game);
			request.setAttribute("Msg", "Succefully Removed !!");
		}
		else
		{
			request.setAttribute("Msg", " Game Not Found !!");
		}
		
		response.sendRedirect("../admin/admin.jsp");
		//request.getRequestDispatcher("../admin/admin.jsp").forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gname=(String)request.getParameter("gameName");
		GamesProcessor gprocessor=((GamesProcessor) context.getAttribute("gamesProcessor"));
		Game game=gprocessor.getGameByName(gname);
		if(game !=null)
		{
			gprocessor.deleteGame(game);
			//request.setAttribute("Msg", "Succefully Removed !!");
			response.sendRedirect("../admin/admin.jsp?deleted=1");
		}
		else
		{
			//request.setAttribute("Msg", " Game Not Found !!");
			response.sendRedirect("../admin/admin.jsp?deleted=0");
		}
		//request.getRequestDispatcher("../admin/admin.jsp").forward(request, response);
		//response.sendRedirect("../admin/admin.jsp?delted=true");
	}

}
