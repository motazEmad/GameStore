package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLayer.GamesProcessor;

import dto.Game;

/**
 * Servlet implementation class GameServlet
 */
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletContext context;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	context = config.getServletContext();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gameName = request.getParameter("gn");
		if (gameName != null) {
			Game game = new Game();
			game.setName(gameName);

			GamesProcessor gamesProcessor = ((GamesProcessor) context
					.getAttribute("gamesProcessor"));
			game = gamesProcessor.getGame(game);
			request.setAttribute("gameBean", game);

			List<Game> similarGames = gamesProcessor.getSimilarGames(game, 3);
			request.setAttribute("similarGames", similarGames);
		}
		request.getRequestDispatcher("game.jsp")
				.include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
