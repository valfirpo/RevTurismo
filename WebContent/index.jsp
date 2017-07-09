<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.rev.bean.*,java.util.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel = "stylesheet" type = "text/css" href = "resources/css/main.css">

<link href="https://fonts.googleapis.com/css?family=Lobster|Titillium+Web" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<title>Home Page</title>
</head>
<body class = "container-fluid">

<img src="resources/img/header.png" width = "100%">

<nav id = "nv" class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp" style = "color: #ffffff;">Home</a>
    </div>
    
    <ul class="nav navbar-nav navbar-right">
    		<li><a href="createAccount.jsp" style = "color: #ffffff;"><span class="glyphicon glyphicon-plus" ></span> CreateAccount</a></li>		
    </ul>
  </div>
</nav>

<%if(session.getAttribute("user") == null){%>
<div id = "jd" class = "jumbotron">
	<div id = "wl" class = "well">
		<h1 id = "welcome">Welcome to RevTurismo</h1>
	</div>
	<div class = "row">
		<div class = "col-lg-6">
			<div id = "wl" class = "well">
				<h2>Login</h2>
			
			
			
				<%if(session.getAttribute("issue") != null){%>
					<div class = "alert alert-danger">Invalid credentials!!</div>
				<%}%>
				
				<form method = "post" action = "Login.do">
				
					<div class = "input-group">
						<span class = "input-group-addon"> <i class = "glyphicon glyphicon-user"></i> </span>
						<input type = "text" name = "user" class = "form-control" placeholder = "username" required>
					</div>
					<br>
					<div class = "input-group">
						<span class = "input-group-addon"> <i class = "glyphicon glyphicon-lock"></i> </span>
						<input type = "password" name = "pass" class = "form-control" placeholder = "password" required>
					</div>
				
					<br>
					<div>
						<input type = "submit" class="btn btn-default" value = "Login" aria-label="Left Align">
					</div>	
				</form>
			</div>
		</div>
	</div>
</div>
<%}else{%>
<%}%>

</body>
</html>