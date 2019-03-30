<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
</head>
<body class="bg-dark">
	<div class="container-fluid">
	<%
		String msg ="";
		if(request.getAttribute("message")!=null){
			msg = (String)request.getAttribute("message");
	%>
	<div id="alert" class="alert alert-success" role="alert"><%=msg %></div>
	<%} %>
		<div class="row">
			<div class="col-md-6 mt-3 mx-auto">
				<h1 class="text-primary"><i><b>EMPLOYEE MANAGEMENT APP</b></i></h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 mx-auto">
			<%
				String errorMsg = "";
				if(request.getAttribute("errorMessage")!=null){
					errorMsg = (String)request.getAttribute("errorMessage");
				}
			%>
				<h3 class="text-danger"><%=errorMsg %></h3>
				<div class="card mt-5 mx-auto">
					<form action="login.do" method="post">
						<div class="card-header bg-default text-center text-warning h2"><i><b>LOGIN</b></i></div>
						<div class="card-body">
							<div class="form-group">
								<label for="exampleInputEmail1">Email</label> <input type="text"
									class="form-control" name="email" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email" required>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" name="pass" class="form-control"
									id="exampleInputPassword1" placeholder="Password" required>
							</div>
						</div>
						<div class="card-footer">
							<div class="col-md-4 mx-auto">
								<button type="submit" class="text-white btn btn-warning btn-lg btn-block">Login</button>
							</div>
						</div>
					</form>
				</div>
				<div>
					<div class="float-right mt-3">
						<a href="register.jsp" class="h3 text-white btn btn-lg btn-warning">REGISTER</a>
					</div>
				</div>
			</div>
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