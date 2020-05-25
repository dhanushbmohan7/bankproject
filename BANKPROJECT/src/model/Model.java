package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model {
	String name=null;
	String accno=null;
	String balance=null;	
	String custid=null;
	String password=null;
	String email=null;
	String url="jdbc:oracle:thin:@//localhost:1522/XE";
	String uname="SYSTEM";
	String passwd="system";
	PreparedStatement pstmt=null;
	Connection con=null;
	ResultSet res=null;
	public Model()
	{
	
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection(url, uname, passwd);
		System.out.println("loaded and connected");
	} 
	catch (Exception e) {
	System.out.println("not loaded and connected");
	}
	
	}
	
	public boolean getLogin()
	{

		try {
			pstmt=con.prepareStatement("SELECT * FROM BANK WHERE CUSTID=? AND PASSWORD=?");
			pstmt.setString(1,custid );
			pstmt.setString(2, password);
			res=pstmt.executeQuery();
			
			if (res.next()==true)
			{
				
				accno=res.getString(2);
				setAccno(accno);
				System.out.println(accno);
				return true;
			}
			else
				
			{
				return false;
			}
			
			
		} catch (SQLException e) {
			System.out.println("not accesed");
		}
		
		return false;
	}
	public boolean Balance()
	{
		try {
			pstmt=con.prepareStatement("SELECT * FROM BANK WHERE ACCNO=?");
			pstmt.setString(1, accno);
			res=pstmt.executeQuery();	
		
			if (res.next()==true)
			{
				balance=res.getString(3);
				setBalance(balance);
				System.out.println("balance ids"+balance);
				return true;
			}
			else
				
			{
				return false;
			}			
					
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in balance");
		}
		return false;
	}
	public int changePassword()
	{
		try {
			 
			pstmt=con.prepareStatement("UPDATE BANK SET PASSWORD=? WHERE ACCNO=?");
			pstmt.setString(1, password);
			pstmt.setString(2, accno);
			  int re=pstmt.executeUpdate();
			 if(re!=0)
			 {
				 return 1;
			 }
			 else
			 {
				 return 0;
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public int transfer(String amount)
	{
         try {
			pstmt=con.prepareStatement("UPDATE BANK SET BALANCE=BALANCE-? WHERE ACCNO=?");
			pstmt.setString(1, amount);
			pstmt.setString(2, accno);
			int res=pstmt.executeUpdate();
			pstmt=con.prepareStatement("INSERT INTO BANKSTATEMENT VALUES(?,?)");
			pstmt.setString(1, accno);
			pstmt.setString(2, amount);
			pstmt.executeUpdate();
			if(res>0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		}

		public ArrayList getStatement()
	{
		ArrayList al=new ArrayList();
		try {
			pstmt=con.prepareStatement("SELECT * FROM BANKSTATEMENT WHERE ACCNO=?");
			pstmt.setString(1, accno);
			res=pstmt.executeQuery();
			while(res.next()==true)
			{
				String temp=res.getString(2);
				al.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	public boolean applyLoan()
	{
		try {
			pstmt=con.prepareStatement("SELECT * FROM BANK WHERE ACCNO=?");
			pstmt.setString(1, accno);
			res=pstmt.executeQuery();
			
			if(res.next()==true)
			{
				name=res.getString(1);
				setName(name);
				
				return true;
			}
			else
			{
				return false;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in apply loan");
		}
		return false;
	}
	public int forgotPassword(String email)
	{
		try {
			pstmt=con.prepareStatement("UPDATE BANK SET PASSWORD=? WHERE EMAIL=?");
			pstmt.setString(1,password);
			pstmt.setString(2,email);
			int res=pstmt.executeUpdate();
			if(res!=0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getAccno() {
		return accno;
	}

	public String getBalance() {
		return balance;
	}

	public String getCustid() {
		return custid;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	
		}
	


	


