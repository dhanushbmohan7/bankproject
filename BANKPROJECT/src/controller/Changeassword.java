package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Changeassword
 */
public class Changeassword implements Filter {

    /**
     * Default constructor. 
     */
    public Changeassword() {
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

		
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("confirmpassword");
		{
			if(password.equals(confirmpassword))
			{
                chain.doFilter(request, response);
			}
			else
			{
				((HttpServletResponse)(response)).sendRedirect("/BANKPROJECT/ChangePasswordFailure.jsp");
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
