package controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class TransferAmount extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		String amount=x.getParameter("amount");
		Model m=new Model();
		
		 HttpSession hs=x.getSession();
			String accno=(String) hs.getAttribute("ACCNO");
			m.setAccno(accno);
			int temp=m.transfer(amount);
			if(temp>0)
			{
				try {
					y.sendRedirect("/BANKPROJECT/TransferSuccess.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				try {
					y.sendRedirect("/BANKPROJECT/Transferfailed.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			

	}
}