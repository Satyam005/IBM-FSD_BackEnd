<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="com.examples.spring.web.mvc.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Success Page</title>
</head>
<body>
	<h1>Registration Successful...!!!</h1>
	<h3><a href="login">Go to Login Page</a></h3>
	<%
	
		if(session.getAttribute("username")!=null){
			String username = (String)session.getAttribute("username");
			String password = (String)session.getAttribute("password");
			out.println(username);
			out.println(password);
		}
		
	%>
</body>
</html>