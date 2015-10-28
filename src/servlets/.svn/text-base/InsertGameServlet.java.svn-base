package servlets;

import java.awt.image.BufferedImage;
import businessLayer.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import businessLayer.CategoryProcessor;
import dao.CategoryHome;
import dao.GameHome;
import dto.Category;
import dto.Game;

/**
 * Servlet implementation class GameServlet
 */
public class InsertGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	ServletContext context;

	public InsertGameServlet() {
		super();

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Game game = new Game();
//		byte[] imageInByte=null;
//		FileItemFactory factory = new DiskFileItemFactory();
//		ServletFileUpload upload = new ServletFileUpload(factory);
//		try {
//			 List /* FileItem */ items = upload.parseRequest(request);
		File fnew = new File("D:\\1.jpg");
		ByteArrayOutputStream baos = null;

		try {
			BufferedImage originalImage = ImageIO.read(fnew);
			baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
		} catch (IOException e) {

			e.printStackTrace();
		}
		byte[] imageInByte = baos.toByteArray();

		CategoryProcessorImp categoryprocessor= new CategoryProcessorImp();
		
		List cats =categoryprocessor.getAllCategories();
		game.setName(request.getParameter("gamename"));
		game.setName(request.getParameter("gamequantity"));
		game.setName(request.getParameter("gameprice"));
		game.setName(request.getParameter("gamedis"));
		game.setImage(imageInByte);
		Category cat = new Category();
		cat.setName(request.getParameter("cate"));
		CategoryHome cathome =new CategoryHome();
		cat =cathome.merge(cat);
		
		
		//cat.setName(request.getAttribute("Category").toString());
		game.setCategory(cat);
		GameHome gamehome = new GameHome();
		gamehome.persist(game);
		response.sendRedirect("adminHome.jsp");
	}

}
