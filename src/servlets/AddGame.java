package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import businessLayer.CategoryProcessor;
import businessLayer.GamesProcessor;

import dto.Category;
import dto.Game;

/**
 * Servlet implementation class AddGame
 */
public class AddGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ServletContext context;
    public AddGame() {
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
		
		
		//request.getAttribute("")
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Game game = new Game();
		CategoryProcessor cpreocessor=((CategoryProcessor) context.getAttribute("categoryProcessor"));
		GamesProcessor gprocessor=((GamesProcessor) context.getAttribute("gamesProcessor"));
		//////////////////////////////
		byte[] imageInByte=null;
	 	
		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {

			// Parse the request
			//FileItemIterator iter = upload.getItemIterator(request);
			 List /* FileItem */ items = upload.parseRequest(request);  
             
             // Process the uploaded items  
             Iterator iter = items.iterator();
           //  request.getRequestDispatcher("../admin/admin.jsp").include(request, response);
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (item.isFormField()) {
					String property = item.getFieldName();
					switch (property) {
					case "gameName":
						game.setName(item.getString());
						break;
					case "price":
						game.setPrice(Float.parseFloat(item.getString()));
						break;
					case "desc":
						game.setDescription(item.getString()); 
						break;
					case "quantity":
						game.setQuantity(Integer.parseInt(item.getString()));
						break;
					case "category":
						Category gameCategory=cpreocessor.findById(Integer.parseInt(item.getString()));
						game.setCategory(gameCategory);
						break;
					default:
						break;
					}
					
				} else {
					imageInByte = item.get();
					game.setImage(imageInByte);
				}
			}
			if(gprocessor.getGame(game)!=null);
			{
				gprocessor.addGame(game);
			}
	
			//request.getRequestDispatcher("../admin/admin.jsp").forward(request, response);
			response.sendRedirect("../admin/admin.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
