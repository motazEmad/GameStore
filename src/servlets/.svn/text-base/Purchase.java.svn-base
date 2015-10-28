package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.CartGame;
import dto.Game;
import dto.User;

import businessLayer.DmException;
import businessLayer.GamesProcessor;

/**
 * Servlet implementation class Purchase
 */
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	ServletContext context;

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String gameName = request.getParameter("gn");
		User user = (User) session.getAttribute("user");
		GamesProcessor processor = (GamesProcessor) ((GamesProcessor) context.getAttribute("gamesProcessor"));
		Game game = (Game) processor.getGameByName(gameName);

		try {
			processor.buy(new CartGame(game, user.getCart(), 1), true);
			request.setAttribute("Msg", "Congratulation !!");
			request.setAttribute("currentCredit", user.getCredit());
		} catch (DmException e) {
			request.setAttribute("Msg", e.getMessage());
		}
		
		request.getRequestDispatcher("../game").include(request, response);
	}
}
