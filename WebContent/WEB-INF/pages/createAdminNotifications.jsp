<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.rev.bean.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Notifications</title>
</head>
<body>
<jsp:include page = "bannerAndNav.jsp" />
	
<div id="jd" class="jumbotron">
	<div id="wl" class="well">
		<div id="createNotification" class="container">
			
				
			
			<form:form id="admin" modelAttribute="admin"
				action="createAdminNotifications" method="POST">
				<c:if test="${sessionScope.currentUser.getRole() != null }">
				
				<c:if test ="${sessionScope.currentUser.getRole() != 3 }">
				
				<form:hidden path="id" value="${adminNotify.getId() }"/>
				<h1>Create New Notification</h1>
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-pencil"></i>
					</span>
					<form:label class="form-control" path="content">Add Content</form:label>
					<form:textarea class="form-control" path="content" />
				</div>
				
				<br>
				
				<div class="input-group">
					<input  type="submit" class="btn btn-danger" value="Post" >
					<input  type="reset" class="btn btn-default" value="Clear" />
				</div>
				<br>
				<div class ="input-group">
					<input  type="submit" class="btn btn-basic" value="View Notifications">
				</div>
				
				</c:if>
				
			<c:if test="${sessionScope.currentUser.getRole() == 3 }">
				<h1>View Notifications?</h1>
				
					<div class="input-group">
						<input  type="submit" class="btn btn-danger" value="View Notifications" >
						<input onclick="location.href='index';" type ="reset"  class="btn btn-default" value = "Back">
					</div>
			</c:if>
			</c:if>
		</form:form> 
			
			
		</div>
	</div>
</div>

</body>
</html>