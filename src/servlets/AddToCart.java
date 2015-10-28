package servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLayer.CartProcessor;
import businessLayer.GamesProcessor;

import dto.CartGame;
import dto.User;

/**
 * Servlet implementation class AddToCart
 */
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServletContext context;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
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
		String gameName = request.getParameter("gameName");
		User user = (User) request.getSession().getAttribute("user");
		
		GamesProcessor gamesProcessor = (GamesProcessor) context.getAttribute("gamesProcessor");
		CartProcessor cartProcessor = (CartProcessor) context.getAttribute("cartProcessor");
		
		
		CartGame cartGame = new CartGame();
		cartGame.setGame(gamesProcessor.getGameByName(gameName));
		cartGame.setQuantity(1);
		cartGame.setCart(user.getCart());
		
		boolean found = false;
		for (Iterator iterator = user.getCart().getCartGames().iterator(); iterator.hasNext();) {
			CartGame added = (CartGame) iterator.next();
			if(cartGame.equals(added)) {
				found = true;
				cartGame = added;
				break;
			}
		}
		if(!found)
			user.getCart().addCartGames(cartGame);
		else 
			cartGame.setQuantity(cartGame.getQuantity() + 1);
		
		 cartProcessor.save(user.getCart());
		response.sendRedirect("../GamesHome.jsp?category=" + cartGame.getGame().getCategory().getId());
	}

}
