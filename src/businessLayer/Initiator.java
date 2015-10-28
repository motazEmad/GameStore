package businessLayer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Initor
 *
 */
public class Initiator implements ServletContextListener, HttpSessionListener {

    /**
     * Default constructor. 
     */
    public Initiator() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent contextEvent) {
        HibernateUtil.getInstance();
    	
        ProfileProcessor p = new ProfileProcessorImp();
        contextEvent.getServletContext().setAttribute("profileProcessor",p);
        
        GamesProcessor gamesProcessor = new GamesProcessorImp();
        contextEvent.getServletContext().setAttribute("gamesProcessor", gamesProcessor);
        
        CreditProcessor creditProcessor =new CreditProcessorImp();
        contextEvent.getServletContext().setAttribute("creditProcessor",creditProcessor);
        
        CategoryProcessor categoryProcessor =new CategoryProcessorImp();
        contextEvent.getServletContext().setAttribute("categoryProcessor",categoryProcessor);
        
        CartProcessor cartProcessor = new CartProcessorImp();
        contextEvent.getServletContext().setAttribute("cartProcessor", cartProcessor);
        
        
       
        
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
