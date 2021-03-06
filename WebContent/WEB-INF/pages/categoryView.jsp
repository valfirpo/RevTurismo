<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.rev.bean.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/main.css">

<link href="https://fonts.googleapis.com/css?family=Lobster|Titillium+Web" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link rel="Stylesheet" type="text/css" href="resources/css/forum.css"/>

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RevTurismo ${category.getName()}</title>
<script src="resources/js/forum.js"></script>
</head>
<body>
<jsp:include page = "bannerAndNav.jsp" />
<div id="jd" class="jumbotron">
	<div id="wl" class="well">
		<c:forEach var="thread" items="${threads }">
			<div id="threadId${thread.getId()}" class="t-container">
				<span class="tName"><a href="thread?threadId=${thread.getId()}">${thread.getName() }</a></span>
			</div>
		</c:forEach>
		<div class="t-foot">
			<button id="addThread" class="f-btn">Create</button>
		</div>
		<div id="newPost" class="hide">
			<form:form id="createThread" modelAttribute="newThread" action="createThread" method="POST">
				<div id="nameGroup" class="form-container">
					<form:input  path="tname" placeholder="Thread Name"  />
				</div>
				<form:hidden path="catId" value="${category.getId() }" />
				<div class="form-container">
					<form:textarea path="content" ></form:textarea>
				</div>
				<div class="form-container button-container">
					<input type="submit" value="Save Thread"/>
				</div>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>