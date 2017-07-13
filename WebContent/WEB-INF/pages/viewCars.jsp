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

<title>View Carsl</title>
</head>
<body class = "container-fluid">

<jsp:include page = "bannerAndNav.jsp" />

<div id = "jd" class = "jumbotron">
	<div id = "wl" class = "well">
		<table class = "table">
			<tr><td>ID</td><td>Name</td><td>Price</td><td>Top Speed</td><td>Acceleration</td></tr>
			<c:forEach var = "c" items = "${allCars}">
				<tr>
					<td>${c.getId()}</td>
					<td>${c.getCarName()}</td>
					<td>${c.getPrice()}</td>
					<td>${c.getTopSpeed()}</td>
					<td>${c.getAcceleration()}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

</body>
</html>