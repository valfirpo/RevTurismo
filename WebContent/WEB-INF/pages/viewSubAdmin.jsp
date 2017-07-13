<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<link href="https://fonts.googleapis.com/css?family=Lobster|Titillium+Web" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<title>View SubAdmin</title>
</head>
<body>

<jsp:include page = "bannerAndNav.jsp" />

<table class = "table">
		<tr><th>ID</th><th>Username</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Cash</th></tr>
		<c:forEach var = "u" items = "${allSubAdmin}">
			<tr>
				<td>${u.getId()}</td>
				<td>${u.getUsername()}</td>
				<td>${u.getFirstname()}</td>
				<td>${u.getLastname()}</td>
				<td>${u.getEmail()}</td>
				<td>${u.getCash()}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>