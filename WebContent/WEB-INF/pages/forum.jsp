<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.rev.bean.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RevTurismo Forum</title>
<link rel = "stylesheet" type = "text/css" href = "resources/css/main.css">

<link href="https://fonts.googleapis.com/css?family=Lobster|Titillium+Web" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<nav id = "nv" class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
     <a class="navbar-brand" href="index" style="color: #ffffff;">Home</a>
		</div>
		<%-- <c:if test="${user != null }"> --%>
			<ul class="nav navbar-nav">
				<li ><a href="controlPanel" style="color: #ffffff;">Control Panel</a></li>
				<li class="active"  ><a href="viewCars">View Cars</a></li>
				<li ><a href="viewChallenges" style="color: #ffffff;">View Challenges</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="logout" style="color: #ffffff;"><span class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
			</ul>
  </div>
</nav>
<div id="forumBody" class="jumbotron">
	<div class="well">
		<!-- For loop -->
		<c:forEach var="cat" items="${categories }">
			<div id="catId" class="cat-container">
				<span class="catName">${cat.getName() }</span>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>