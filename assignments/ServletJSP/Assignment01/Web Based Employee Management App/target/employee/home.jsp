<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,org.employee.model.Employee" %>
<%

	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma","no-cache");
	
	session = request.getSession(false);
	String name = "";
	if (session.getAttribute("username") == null || session.getAttribute("username").equals("")){
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	else
	{
		name = (String)session.getAttribute("username");
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body class="bg-light">
    <div class="container">
        <div class="row mb-5">
        <div class="col-md-12 mt-4">
        <div class="h3 text-info"><marquee width="100%" direction="right"><i><b>WELCOME <%=name %>....</b></i></marquee></div>
        </div>
        </div>
        <div class="row mb-2">
            <div class="col-md-4 mx-auto h2 text-warning"><i><b>EMPLOYEE LIST</b></i></div>
        </div>
        <div class="row">   
            <table class="table table-bordered table-striped table-dark">
                <thead class="text-danger">
                  <tr>
                    <th scope="col">Sr.No</th>
                    <th scope="col">NAME</th>
                    <th scope="col">AGE</th>
                    <th scope="col">GENDER</th>
                    <th scope="col">DEPARTMENT</th>
                    <th scope="col">SALARY</th>
                    <th scope="col">ACTIONS</th>
                  </tr>
                </thead>
                <tbody>
                <%
					if(request.getAttribute("empList")!=null){
					List<Employee<Integer>> empList = (List<Employee<Integer>>)request.getAttribute("empList");
					for(Employee emp : empList){
			
				%>
                  <tr class="bg-danger">
                    <th scope="row"><%=emp.getEmpID() %></th>
                    <td><%=emp.getName() %></td>
                    <td><%=emp.getAge() %></td>
                    <td><%=emp.getGender() %></td>
                    <td><%=emp.getDepartment() %></td>
                    <td><%=emp.getSalary() %></td>
                    <td>
                    	<a href="FindEmployee.do?eid=<%=emp.getEmpID() %>" class="btn btn-primary">EDIT</a>
                    	<a href="delete.do?eid=<%=emp.getEmpID() %>" class="btn btn-warning">DELETE</a>
                    </td>
                  </tr>
<%}} %>
                </tbody>
              </table>
        </div>
    </div>
    <div class="row mb-4">
    <div class="col-md-10 mt-5 mx-auto">
        	<a href="add.jsp" class="btn btn-success">ADD EMPLOYEE</a>
            <a href="logout.do" class="btn btn-danger float-right">LOGOUT</a>
       </div>
            </div>
</body>
</html>
</html>