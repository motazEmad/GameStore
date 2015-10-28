package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import dto.User;

import businessLayer.HibernateUtil;

/**
 * Servlet Filter implementation class HeaderFooterFilter
 */
public class HeaderFooterFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HeaderFooterFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Session session = HibernateUtil.getInstance().openSession();
		System.out.println("Hibernate: Sessions = " + (HibernateUtil.getSessionFactory().getStatistics().getSessionOpenCount()
				- HibernateUtil.getSessionFactory().getStatistics().getSessionCloseCount()));
		User user = (User) ((HttpServletRequest)request).getSession().getAttribute("user");
		if(user != null) {
			session.beginTransaction();
			HibernateUtil.getInstance().clearAll();
			session.refresh(user);
			if(user.getCart() != null)
				session.refresh(user.getCart());
		}
		if(((HttpServletRequest)request).getServletPath().contains("user")
				|| ((HttpServletRequest)request).getServletPath().contains("admin")) {
			try{
				if(user != null && user.getType() == User.ADMIN_TYPE)
					request.getRequestDispatcher("../AdminHeader.jsp").include(request, response);
				else
					request.getRequestDispatcher("../header.jsp").include(request, response);
				chain.doFilter(request, response);
			} catch(Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("../ErrorPage.jsp").include(request, response);
			}
			request.getRequestDispatcher("../footer.jsp").include(request, response);
		} else {
			try{
			if(user != null && user.getType() == User.ADMIN_TYPE)
				request.getRequestDispatcher("AdminHeader.jsp").include(request, response);
			else
				request.getRequestDispatcher("header.jsp").include(request, response);
				chain.doFilter(request, response);
			} catch(Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("ErrorPage.jsp").include(request, response);
			}
			request.getRequestDispatcher("footer.jsp").include(request, response);
		}
		HibernateUtil.getInstance().closeAll();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
