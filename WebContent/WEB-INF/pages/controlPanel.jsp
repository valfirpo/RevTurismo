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

<jsp:include page = "bannerAndNav.jsp" />

<c:if test="${sessionScope.currentUser.getRole() != null }">


<div id = "jd" class = "row jumbotron">
	<div id = "wl" class = "col-lg-6 well">



		<h1>Role: ${sessionScope.currentUser.getUserRole()}</h1>
		<p>Username: ${sessionScope.currentUser.getUsername()}</p>
		<c:if test="${currentUser.getRole() >= 3}">
			<p>Level: ${sessionScope.currentUser.getLevel()}</p>
		</c:if>
		<p>First Name: ${sessionScope.currentUser.getFirstname()}</p>
		<p>Last Name: ${sessionScope.currentUser.getLastname()}</p>
		<p>Email: ${sessionScope.currentUser.getEmail()}</p>
	</div>
	<div id = "wl1" class = "col-lg-6 well" >
		<c:choose>
			<c:when test="${sessionScope.currentUser.getRole() == 1}">
				<img src="resources/img/admin.png" width="40%">
			</c:when>
			<c:when test="${sessionScope.currentUser.getRole() == 2}">
				<img src="resources/img/subadmin.png" width="49%">
			</c:when>
			<c:otherwise>
				<h2>Cash Available</h2>
				<p>$ ${sessionScope.currentUser.getCash()}</p>
			</c:otherwise>			
		</c:choose>
	</div>
</div>
</c:if>
</body>
</html>