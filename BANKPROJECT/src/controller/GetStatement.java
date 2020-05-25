package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class GetStatement extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		ArrayList al=new ArrayList();
		Model m=new Model();
		
		HttpSession hs=x.getSession();
		String accno=(String) hs.getAttribute("ACCNO");
		m.setAccno(accno);
		al=m.getStatement();
		if(al.isEmpty())
		{
			try {
				y.sendRedirect("/BANKPROJECT/GetStatementFailure.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
			HttpSession hs1=x.getSession(true);
			hs1.setAttribute("AL", al);
				y.sendRedirect("/BANKPROJECT/GetStatementSuccess.jsp");
			}
			catch(Exception e)
			{
				System.out.println("problem in getstatement");
			}
			
			
		}
	}
}