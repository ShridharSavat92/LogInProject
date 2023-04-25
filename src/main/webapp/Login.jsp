<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>User Login</h1>
</div>
<form action="loginservlet" method="post">
<table align="center">
<tr><td>Enter Email:<input type="text" name="name"></td></tr>
<tr><td>Enter Password::<input type="password" name="password"></td></tr>
<tr><td><input type="submit" name="Login">
</td> <td><input type="reset"></td></tr>
</table>
</form>
</body>
</html>