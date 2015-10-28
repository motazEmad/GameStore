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
import businessLayer.DmException;
import businessLayer.GamesProcessor;

import dto.Cart;
import dto.CartGame;
import dto.User;

/**
 * Servlet implementation class RemoveFromCart
 */
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletContext context;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCart() {
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
		String operation = request.getParameter("op");
		String gameName = request.getParameter("gn");
		CartProcessor cartProcessor = ((CartProcessor)context.getAttribute("cartProcessor"));
		GamesProcessor gamesProcessor = (GamesProcessor) context.getAttribute("gamesProcessor");
		
		Cart cart = ((User) request.getSession().getAttribute("user")).getCart();
		for (Iterator<CartGame> iterator = cart.getCartGames().iterator(); iterator.hasNext();) {
			CartGame cartGame = (CartGame) iterator.next();
			
			if (cartGame.getGame().getName().equals(gameName)) {
				
				if (operation.equals("delete")) {
					cart.getCartGames().remove(cartGame);
					 cartProcessor.delete(cartGame);
				
				} else if (operation.equals("decrement")) {
					cartGame.setQuantity(cartGame.getQuantity() - 1);
					 cartProcessor.save(cartGame);
					if (cartGame.getQuantity() == 0) {
						cart.getCartGames().remove(cartGame);
						 cartProcessor.delete(cartGame);
					}
				} else if(operation.equals("buy")) {
					try {
						gamesProcessor.buy(cartGame, false);
						request.setAttribute("Msg", "Congratulation !!");
					} catch (DmException e) {
						request.setAttribute("Msg", e.getMessage());
					}
				}
				break;
			}	
		}
		request.getRequestDispatcher("cart").include(request, response);
	}

}
