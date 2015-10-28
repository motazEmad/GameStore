package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Game;
import dto.User;

import businessLayer.GamesProcessor;

/**
 * Servlet implementation class BestGames
 */
public class BestGames extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServletContext context; 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BestGames() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	context = config.getServletContext();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Game> bestGames = ((GamesProcessor)context.getAttribute("gamesProcessor")).getBestGames();
		request.setAttribute("bestGames", bestGames);
	}

}
