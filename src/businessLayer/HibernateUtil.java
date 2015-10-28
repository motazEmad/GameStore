package businessLayer;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static HibernateUtil hibernateUtil = new HibernateUtil();

	private HibernateUtil() {
		try {
			new InitialContext().rebind("SessionFactory", sessionFactory);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static HibernateUtil getInstance() {
		return hibernateUtil;
	}

	private static SessionFactory buildSessionFactory() {
		try {
		
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void closeSession(Session session) {
		if(session.isOpen())
			session.close();
	}
	
	public void closeAll() {
		long x = (HibernateUtil.getSessionFactory().getStatistics().getSessionOpenCount()
				- HibernateUtil.getSessionFactory().getStatistics().getSessionCloseCount());
		for (int i = 0; i < x; i++) {
			sessionFactory.getCurrentSession().close();
		}
	}

	public void clearAll() {
		long x = (HibernateUtil.getSessionFactory().getStatistics().getSessionOpenCount()
				- HibernateUtil.getSessionFactory().getStatistics().getSessionCloseCount());
		for (int i = 0; i < x; i++) {
			sessionFactory.getCurrentSession().clear();
		}
	}
	
	
}
