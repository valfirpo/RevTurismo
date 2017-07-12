<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.rev.bean.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="resources/css/main.css">

<link
	href="https://fonts.googleapis.com/css?family=Lobster|Titillium+Web"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<title>Home Page</title>
</head>
<body class="container-fluid">

	<img src="resources/img/header.png" width="100%">

	<nav id="nv" class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index" style="color: #ffffff;">Home</a>
		</div>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="createAccount" style="color: #ffffff;"><span
					class="glyphicon glyphicon-plus"></span> CreateAccount</a></li>
		</ul>
	</div>
	</nav>

	<c:if test="${errorMessage == null }">
		<c:choose>
			<c:when test="${user == null }">
				<div id="jd" class="jumbotron">
					<div id="wl" class="well">
						<h1 id="welcome">Welcome to RevTurismo</h1>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div id="wl" class="well">
								<h2>Login</h2>


								<c:if test="${message != null }">
									<div class="alert alert-danger">${message}</div>
								</c:if>

								<form:form id="loginForm" modelAttribute="login" action="index"
									method="POST">


									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-user"></i>
										</span>
										<!-- 						<input type = "text" name = "user" class = "form-control" placeholder = "username" required>
 -->
										<form:label class ="form-control" path="username">Username:</form:label>
										<form:input class="form-control" path="username" name="username" id="username" placeholder ="username"  />
										
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-lock"></i>
										</span>
										<!-- 						<input type = "password" name = "pass" class = "form-control" placeholder = "password" required>
 -->
										<form:label class ="form-control"  path="password">Password:</form:label>
										<form:password class="form-control" path="password" name="password" id="password" placeholder ="password"  />
									</div>

									<br>
									<div>
<%-- 										<form:button id="login" name="login">Login</form:button>
 --%>										<input type = "submit" class="btn btn-default" value = "Login" aria-label="Left Align">
 
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div id="jd" class="jumbotron">
					<div id="wl" class="well">
						<h1 id="welcome">Welcome to RevTurismo</h1>
					</div>
					<div id="wl" class="well">
						<p>You are logged in to RevTurismo as (role type) (user name)!
							RevTurismo is a car collecting application was created by
							RevTurismo Group. Group members: Lucas Vance, Paul Wesson,
							Matthew Young & Valentin Firpo.</p>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>

</body>
</html>