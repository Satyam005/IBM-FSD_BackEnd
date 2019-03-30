<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.employee.model.Employee" %>
<%

	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma","no-cache");
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
 <body class="bg-dark">
    <div class="container">
    <%
    	String name = "", dob = "", dept = "";
    	int salary = 0, id=0;
    	
    	Employee<Integer> emp = null;
    	if(session.getAttribute("username")!=null){
			if(request.getAttribute("emp")!=null){
				emp = (Employee<Integer>)request.getAttribute("emp");
				name = emp.getName();
				dept = emp.getDepartment();
				salary = emp.getSalary();
				id = emp.getEmpID();
			}
			else{
				response.sendRedirect("EmployeeList.do");
			}
		}
		else{
			response.sendRedirect("EmployeeList.do");
		}
    	
		String msg ="";
		if(request.getAttribute("msg")!=null){
			msg = (String)request.getAttribute("msg");
	%>
	<div id="alert" class="alert alert-danger" role="alert"><%=msg %></div>
	<%} %>
      <div class="row">
        <div class="col-md-7">
          <div class="card mt-3">
            <div class="card-header h3 text-center text-black bg-default">
             EDIT EMPLOYEE
            </div>
            <form action="UpdateEmployee.do" method="post">
              <div class="card-body">
                <div class="form-group">
                <input type="hidden" name="eid" value="<%=id %>"/>
                  <label for="exampleInputName">NAME</label>
                  <input
                    type="text"
                    class="form-control"
                    id="exampleInputName1"
                    name="name"
                    aria-describedby="nameHelp"
                    placeholder="Enter name"
                    required
                    value="<%=name %>"
                  />
                </div>
                <div class="form-group">
                  <label for="exampleInputDob">DOB</label>
                  <input
                    type="date"
                    class="form-control"
                    id="exampleInputDob1" 
                    name="dob"
                    aria-describedby="dobHelp"
                    placeholder="Enter age"
                    required
                    value="1996/07/23"
                  />
                </div>
                <div class="form-group">
                  <label for="exampleInputGender">GENDER</label>
                  <select name="gender" id="" class="form-control" required>
                      <option value="">Select Gender</option>
                      <option value="Male">MALE</option>
                      <option value="Female">FEMALE</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="exampleInputDepartment">DEPARTMENT</label>
                  <input
                    type="text"
                    class="form-control"
                    id="exampleInputdepartment1" 
                    name="department"
                    aria-describedby="departmentHelp"
                    placeholder="Enter department"
                    required
                    value="<%=dept %>"
                  />
                <div class="form-group">
                  <label for="exampleInputSalary">SALARY</label>
                  <input
                    type="number"
                    class="form-control"
                    id="exampleInputSalary"
                    name="salary"
                    aria-describedby="salaryHelp"
                    placeholder="Enter salary"
                    min="0"
                    required
                    value="<%=salary %>"
                  />
                </div>
              </div>
              <div class="card-footer">
                <div class="col-md-6 mx-auto">
                	<button type="submit" class="btn btn-success btn-block btn-lg">UPDATE</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <div class="row mt-5">
          <div class="col-md-7 mx-auto">
            <a href="EmployeeList.do" class="btn btn-warning btn-lg">VIEW LIST</a>
          </div>
      </div>
    
    <script type="text/javascript">
		var alert = document.getElementById("alert");
		setTimeout(() => {
			alert.remove();
		}, 5000);
	</script>
  </body>
</html>