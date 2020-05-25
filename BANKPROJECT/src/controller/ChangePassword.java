package controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class ChangePassword extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		String password=x.getParameter("password");
		Model m=new Model();
		
		 HttpSession hs=x.getSession();
			String accno=(String) hs.getAttribute("ACCNO");
		
		
	 
	  m.setPassword(password);
	 	m.setAccno(accno);
		//System.out.println("accno and passwrd is:"+ accno+password);
		 int temp=m.changePassword();
	  if (temp>0)
	  {
		  try {
			  
			y.sendRedirect("/BANKPROJECT/ChangePasswordSuccess.jsp");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  else
	  {
		  try {
			y.sendRedirect("/BANKPROJECT/ChangePasswordFailure.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
		
	}
	
}