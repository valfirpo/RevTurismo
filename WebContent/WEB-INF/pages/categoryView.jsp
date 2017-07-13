<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.rev.bean.*,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RevTurismo {Category Name}</title>
</head>
<body>
<div id="forumBody" class="jumbotron">
	<div class="well">
		<c:forEach var="thread" items="${threads }">
			<div id="threadId" class="t-container">
				<span class="tName">${thread.getName() }</span>
			</div>
		</c:forEach>
		<div class="t-foot">
			<button id="addThread" class="f-btn">Create Post</button>
		</div>
	</div>
</div>
</body>
</html>