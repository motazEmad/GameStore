package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businessLayer.GamesProcessor;

/**
 * Servlet implementation class OrdersServlet
 */
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletContext context;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
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
		GamesProcessor gamesProcessor = (GamesProcessor)context.getAttribute("gamesProcessor");
		
		request.setAttribute("orders", gamesProcessor.getOrders());	
	}

}
