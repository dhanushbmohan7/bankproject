<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controller.CheckBalance" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance</title>
</head>
<body>
<h3>The Balance Is</h3>

<%

HttpSession hs=request.getSession();
String balance=(String)hs.getAttribute("BALANCE");
out.println(balance);
%>
</form>
</body>
</html>