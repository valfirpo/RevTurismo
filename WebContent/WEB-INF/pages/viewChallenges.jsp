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

	<div id = "wl" class = "well">
		<h2>Available Challenges</h2>
	</div>

	<table class = "table">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Level</th>
			<th>Reward</th>
			<th><!-- Button --></th>
		</tr>
		<c:forEach var="c" items="${allChallenges}">
			<tr>
				<td>${c.getId()}</td>
				<td>${c.getName()}</td>
				<td>${c.getLevel()}</td>
				<td>${c.getReward()}</td>
				<c:choose>
					<c:when test="${sessionScope.currentUser.getRole() == 3}">
						<td class="col-xs-2"><button
								onclick="EnterChallenge(${c.getId()})">Enter</button></td>
					</c:when>
					<c:otherwise>
						<td class="col-xs-2"><button>Edit</button></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
	</table>

</body>
</html>