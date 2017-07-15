<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel = "stylesheet" type = "text/css" href = "resources/css/main.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

<title>Create Account</title>
</head>
<body class = "container-fluid">

<img src="resources/img/header.png" width = "100%">

<nav id = "nv" class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index" style = "color: #ffffff;">Home</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
    		<li><a href="createAccount" style = "color: #ffffff;"><span class="glyphicon glyphicon-plus" ></span> CreateAccount</a></li>		
    </ul>
  </div>
</nav>



<!-- CREATE ACCOUNT FORM -->
	<div id = "jd" class = "jumbotron">
		<div class = "row">
			<div class = "col-lg-6">
				<div id = "wl" class = "well">
					<h2>Create Account</h2>
				
						<form:form id="userForm" modelAttribute="user" action="createAccount"
									method="POST">
							
					<!-- <form method = "post" action = "CreateAccount.do"> -->
						<!-- <label>Username:</label> -->
						<form:label class ="form-control" path="username">Username:</form:label>
						<div class = "input-group">
							<span class = "input-group-addon"> <i class = "glyphicon glyphicon-user"></i> </span>
							<form:input class="form-control" path="username" name="username" id="username" placeholder ="username" required="required" />
<!-- 							<input type = "text" name = "user" class = "form-control" placeholder = "username" required>
 -->						</div>
						<br>
						<form:label class="form-control" path="password">Password:</form:label>
						<!-- <label >Password:</label> -->
						<div class = "input-group">
							<span class = "input-group-addon"> <i class = "glyphicon glyphicon-lock"></i> </span>
							<form:password class = "form-control" path="password" name="password" id="password" placeholder="password" required="required"/>
							
							<!-- <input type = "password" name = "pass" class = "form-control" placeholder = "password" required> -->
						</div>
						<br>
						<div><form:errors path = "password" cssClass="error"/></div>
						<br>
						<form:label class="form-control" path="confirmPassword">Confirm Password:</form:label>
						<!-- <label >Confirm Password:</label> -->
						<div class = "input-group">
							<span class = "input-group-addon"> <i class = "glyphicon glyphicon-lock"></i> </span>
							<form:password class="form-control" path="confirmPassword" name="confirmPassword" id="confirmPassword" placeholder="password" required="required"/>
							
							<!-- <input type = "password" name = "pass" class = "form-control" placeholder = "password" required> -->
							
							
						</div>
						<br>
					<div><form:errors path = "confirmPassword" cssClass="error"/></div>
						<br>
						<div>
						
							<input id = "register" type = "submit" class="btn btn-default" value = "Create" aria-label="Left Align">
						</div>	
					</form:form>
				</div>
		</div>
	</div>
	</div>
</body>
</html>