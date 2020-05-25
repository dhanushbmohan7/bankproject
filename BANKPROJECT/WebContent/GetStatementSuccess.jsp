<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>transaction succes</title>
</head>
<body>
<h2>Transaction Details</h2>
 <%
HttpSession hs=request.getSession();
out.println(hs.getAttribute("AL"));
%>

</body>
</html>