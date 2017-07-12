<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.rev.bean.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Control Panel</title>
</head>
<body class = "container-fluid">

<img src="resources/img/header.png" width = "100%">

	<nav id="nv" class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index" style="color: #ffffff;">Home</a>
		</div>
		<c:if test="${user != null }">

			<c:choose>
				<c:when test="${sessionScope.currentUser.getRole().getUrId() == 1}">
					<ul class="nav navbar-nav">
						<li><a href="controlPanel" style="color: #ffffff;">Control
								Panel</a></li>
						<li><a href="viewSubAdmin" style="color: #ffffff;">View
								SubAdmin</a></li>
						<li><a href="viewUsers" style="color: #ffffff;">View
								Users</a></li>
						<li><a href="viewCars" style="color: #ffffff;">View Cars</a></li>
						<li><a href="viewChallenges" style="color: #ffffff;">View
								Challenges</a></li>
					</ul>
				</c:when>
				<c:when test="${sessionScope.currentUser.getRole().getUrId() == 2}">
					<ul class="nav navbar-nav">
						<li><a href="controlPanel" style="color: #ffffff;">Control
								Panel</a></li>
						<li><a href="viewUsers" style="color: #ffffff;">View
								Users</a></li>
						<li><a href="viewCars" style="color: #ffffff;">View Cars</a></li>
						<li><a href="viewChallenges" style="color: #ffffff;">View
								Challenges</a></li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="nav navbar-nav">
						<li><a href="controlPanel" style="color: #ffffff;">Control
								Panel</a></li>
						<li><a href="viewCars" style="color: #ffffff;">View Cars</a></li>
						<li><a href="viewChallenges" style="color: #ffffff;">View
								Challenges</a></li>
					</ul>
				</c:otherwise>
			</c:choose>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="logout" style="color: #ffffff;"><span
						class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
			</ul>
		</c:if>

		<c:if test="${user == null }">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="createAccount" style="color: #ffffff;"><span
						class="glyphicon glyphicon-plus"></span> CreateAccount</a></li>
			</ul>
		</c:if>
	</div>
	</nav>

<div id = "jd" class = "row jumbotron">
	<div id = "wl" class = "col-lg-6 well">
		<h1>Role: ${sessionScope.currentUser.getRole().getRole()}</h1>
		<p>Username: ${sessionScope.currentUser.getUsername()}</p>
		<p>First Name: ${sessionScope.currentUser.getFirstname()}</p>
		<p>Last Name: ${sessionScope.currentUser.getLastname()}</p>
		<p>Email: ${sessionScope.currentUser.getEmail()}</p>
	</div>
	<div id = "wl1" class = "col-lg-6 well" >
		<c:choose>
			<c:when test="${sessionScope.currentUser.getRole().getUrId() == 1}">
				<p>Master admin img</p>
			</c:when>
			<c:when test="${sessionScope.currentUser.getRole().getUrId() == 2}">
				<p>Sub admin img</p>
			</c:when>
			<c:otherwise>
				<h2>Cash Available</h2>
				<p>${sessionScope.currentUser.getCash()}</p>
			</c:otherwise>			
		</c:choose>
	</div>
</div>

</body>
</html>