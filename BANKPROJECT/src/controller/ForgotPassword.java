package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

/**
 * Servlet implementation class ForgotPassword
 */
public class ForgotPassword extends HttpServlet {
	
	@Override
public void service(HttpServletRequest x, HttpServletResponse y)  {
		
		
		String password=x.getParameter("password");
		Model m=new Model();
		m.setPassword(password);
		HttpSession hs=x.getSession();
		String email=(String) hs.getAttribute("EMAIL");
		
	
		int temp=m.forgotPassword(email);
		if(temp!=0)
		{
			try {
				y.sendRedirect("/BANKPROJECT/Success.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try {
				y.sendRedirect("/BANKPROJECT/Failed.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
				}
	
	
}
