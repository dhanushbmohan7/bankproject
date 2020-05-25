package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Login extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		String custid=x.getParameter("custid");
		String password=x.getParameter("password");
		Model m=new Model();
		m.setCustid(custid);
		m.setPassword(password);
		
		boolean temp=m.getLogin();
		String accno=m.getAccno();
		System.out.println(accno+"in login");
		if(temp==true)
		{
			try {
				
				HttpSession hs=x.getSession(true);
				 hs.setAttribute("ACCNO", accno);
				//System.out.println("accno in http session login"+accno);
				y.sendRedirect("/BANKPROJECT/Home.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try {
				y.sendRedirect("/BANKPROJECT/loginfailure.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	
		

	}
	
}