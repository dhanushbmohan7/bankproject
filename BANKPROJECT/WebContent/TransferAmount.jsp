<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Amount</title>
</head>
<body>
<h2 text align="center">Transaction</h2>
<form action="http://localhost:1002/BANKPROJECT/TransferAmount"/>
<table align="center">
<tr>
<td>To</td>
<td><input type="text" name="to"/></td>
</tr>
<tr>
<td>Amount</td>
<td><input type="text" name="amount"/></td>
</tr>
<tr>
<td>
<input type="submit"  value ="Pay" />
</td>
</tr>
</table>
</body>
</html>