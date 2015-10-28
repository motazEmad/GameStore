package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.User;

/**
 * Servlet Filter implementation class AdminAutherizationFilter
 */
public class AdminAutherizationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminAutherizationFilter() {
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
		if(((HttpServletRequest)request).getSession().getAttribute("user") == null 
				|| ((User)((HttpServletRequest)request).getSession().getAttribute("user")).getType() != User.ADMIN_TYPE){
			((HttpServletResponse)response).sendRedirect("/GameStore/login.jsp");
		}
		chain.doFilter(request, response);  
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
