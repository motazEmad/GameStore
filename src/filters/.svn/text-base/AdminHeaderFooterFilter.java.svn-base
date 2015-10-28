package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class AdminHeaderFooterFilter
 */
public class AdminHeaderFooterFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminHeaderFooterFilter() {
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
		// TODO Auto-generated method stub
		// place your code here
		
			if(((HttpServletRequest)request).getServletPath().contains("admin")) {
				request.getRequestDispatcher("../AdminHeader.jsp").include(request, response);
				chain.doFilter(request, response);
				request.getRequestDispatcher("../footer.jsp").include(request, response);
			} else {
				request.getRequestDispatcher("header.jsp").include(request, response);
				chain.doFilter(request, response);
				request.getRequestDispatcher("footer.jsp").include(request, response);
			}
		

		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
