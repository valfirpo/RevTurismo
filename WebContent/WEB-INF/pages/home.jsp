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

<jsp:include page = "bannerAndNav.jsp" />


	<form:form id="notifyForm" modelAttribute="admin" action="createAdminNotifications"
								method="GET">
								
		<form action="createAdminNotifications">
			<div id="jd" class="row jumbotron">
				<div id = "wl" class = "col-lg-6 well">
					<h1 id="welcome">Welcome to RevTurismo</h1>
				
					<p>You are logged in to RevTurismo as a ${sessionScope.currentUser.getUserRole()}, 
						${sessionScope.currentUser.getUsername()}!
						RevTurismo is a car collecting application was created by
						RevTurismo Group. Group members: Lucas Vance, Paul Wesson,
						Matthew Young & Valentin Firpo.</p>
				</div>
		
				<div id = "wl" class = "col-lg-6 well">
					<h1 id="welcome">Notifications!</h1>
					
					<c:if test ="${not empty notes }">
						<ul>
							<c:forEach var = "listValue" items = "${notes}">
								<li>${listValue.getNotifications}</li>
							</c:forEach>
						</ul>
					</c:if>
	
				</div>
			</div>
			</form>
		
	</form:form>


</body>
</html>