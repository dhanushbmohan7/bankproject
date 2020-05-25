package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

/**
 * Servlet implementation class CheckBalance
 */
public class CheckBalance extends HttpServlet {
	
	
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		Model m=new Model();
	
	HttpSession hs=x.getSession();
	String accno=(String) hs.getAttribute("ACCNO");
	System.out.println("accno in chk blnc session"+accno);

	m.setAccno(accno);
	
	
	boolean temp=m.Balance();
	
	
  
	if (temp==true)
	{
		try {
            String balance=m.getBalance();
			HttpSession hs1=x.getSession(true);
			 hs.setAttribute("BALANCE", balance);
			//System.out.println("balamce"+balance);
			y.sendRedirect("/BANKPROJECT/BalanceSuccess.jsp");
		
		}
		catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
	}
	else
	{
		try {
			y.sendRedirect("/BANKPROJECT/BalanceFailure.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	}
}
