package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		try
		{
			
		
		HttpSession hs=x.getSession();
		hs.invalidate();
		y.sendRedirect("/BANKPROJECT/index.jsp");
		}
		catch(Exception e)
		{
			System.out.println("problrm in sessioin");
		}
		
	}
}