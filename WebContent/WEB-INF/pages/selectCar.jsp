<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<script type="text/javascript" src = "resources/js/main.js"></script>

<title>Select Car</title>
</head>
<body class="container-fluid">

<c:if test="${sessionScope.currentUser.getRole() != null }">

	<img src="resources/img/header.png" width="100%">
	<nav id="nv" class="navbar navbar-inverse">
	<div class="container-fluid">
		<ul class="nav navbar-nav navbar-right">
			<li><a href="logout" style="color: #ffffff;"><span
					class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
		</ul>
	</div>
	</nav>

	<div id="wl" class="well">
		<h2 id="welcome2">${currentUser.getUsername()}you entered
			challenge ${currentChallenge.getName()}</h2>
	</div>
	<h4>Select Car</h4>
	<table class="table">
		<thead>
			<tr>
				<th class="col-xs-1">#</th>
				<th class="col-xs-4">Name</th>
				<th class="col-xs-2">Price</th>
				<th class="col-xs-2">Top Speed</th>
				<th class="col-xs-1">Acc</th>
				<th class="col-xs-2">
					<!-- Button -->
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${currentUser.getCars()}">
				<tr>
					<td class="col-xs-1">${c.getId()}</td>
					<td class="col-xs-4">${c.getCarName()}</td>
					<td class="col-xs-2">$ ${c.getPrice()}</td>
					<td class="col-xs-2">${c.getTopSpeed()}MPH</td>
					<td class="col-xs-1">${c.getAcceleration()}</td>
					<td class="col-xs-2"><button onclick="startChallenge(${currentChallenge.getId()}, ${c.getId()})">Start</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
</body>
</html>