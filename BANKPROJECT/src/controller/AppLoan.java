package controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class AppLoan extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		Model m=new Model();
	
	HttpSession hs=x.getSession();
	String accno=(String) hs.getAttribute("ACCNO");
	//System.out.println("accno in chk blnc session"+accno);

	m.setAccno(accno);
	boolean temp=m.applyLoan();
	if(temp==true)
	{
		try
		{
		String name=m.getName();
		HttpSession hs1=x.getSession(true);
		hs1.setAttribute("NAME", name);
		y.sendRedirect("/BANKPROJECT/ApplyLoanSuccess.jsp");
		}
		catch(Exception e)
		{
			System.out.println("problem in loan servlet");
		}
	}
	else
	{
		try {
			y.sendRedirect("/BANKPROJECT/ApplyLoanfailure.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

}