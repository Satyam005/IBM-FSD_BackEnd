<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration | Bean Validation</title>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
</head>
<body>
	<div align="center">
        <h2>Registration | Bean Validation</h2>
        <table border="0" width="90%">
        <form:form action="register" modelAttribute="user">
                <tr>
                    <td align="left" width="20%">Username: </td>
                    <td align="left" width="40%"><form:input path="userName" size="30"/></td>
                    <td align="left"><form:errors path="userName" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><form:password path="password" size="30"/></td>
                    <td><form:errors path="password" cssClass="error"/></td>
                </tr>
                <tr>
                	<td></td>
                    <td align="center"><input type="submit" value="Register"/></td>
                </tr>
        </form:form>
        </table>
    </div>
	
</body>
</html>