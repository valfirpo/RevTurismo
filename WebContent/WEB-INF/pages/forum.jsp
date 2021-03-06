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
<script src="resources/js/forum.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/forum.css" />
</head>
<body>
	<jsp:include page = "bannerAndNav.jsp" />
<div id="jd" class="jumbotron">
	<div id="wl" class="well">
		<!-- For loop -->
		<c:forEach var="cat" items="${categories }">
			<div id="catId" class="cat-container">
				<span class="catName"><a href="category?catId=${cat.getId()}">${cat.getName() }</a></span>
			</div>
		</c:forEach>
	</div>
</div>
</body>
</html>