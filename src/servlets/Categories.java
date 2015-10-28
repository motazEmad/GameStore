package servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Category;

import businessLayer.CategoryProcessor;
import businessLayer.GamesProcessor;

/**
 * Servlet implementation class Categories
 */
public class Categories extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	ServletContext context;

	public Categories() {
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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List Categories = ((CategoryProcessor) context
				.getAttribute("categoryProcessor")).getAllCategories();

		request.setAttribute("categories", Categories);
		if (request.getParameter("category") != null) {
			int id = Integer.parseInt(request.getParameter("category"));
			List gamesList = ((GamesProcessor) context
					.getAttribute("gamesProcessor")).getGamesByCategory(id);

			request.setAttribute("GamesByCategories", gamesList);
		}

		
	}

}
