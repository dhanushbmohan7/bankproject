<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h3 text align="center">Login </h3>
<form action="http://localhost:1002/BANKPROJECT/Login">
<table align="center">
<tr>
<td>CUSTOMER_ID</td>
<td><input type="text" name="custid"/></td>
</tr>
<tr>
<td>PASSWORD</td>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td><input type="submit" value="Login"/></td>
</tr>
</form>

<tr>
<td>
<form action="http://localhost:1002/BANKPROJECT/ForgotPassword.jsp">
<input type="submit" value="forgot password"/></td>
</form>
</tr>

</table>

</form>

</body>
</html>