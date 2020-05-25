<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>loan success</title>
</head>
<body>
<%

HttpSession hs=request.getSession();
String name=(String)hs.getAttribute("NAME");
out.println("THANK YOU"+" "+name+" "+"YOUR LOAN HAS BEEN APPROVED");
%>

</body>
</html>