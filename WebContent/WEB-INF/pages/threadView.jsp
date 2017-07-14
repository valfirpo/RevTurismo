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

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RevTurismo ${thread.getName()}</title>
</head>
<body>
<jsp:include page = "bannerAndNav.jsp" />
<div id="jd" class="jumbotron">
	<div id="wl" class="well">
		<div class="tname">
			<span>${thread.getName() }</span>
		</div>
		<c:forEach var="post" items="${posts }">
			<div id="postId" class="p-contianer">
				<span class="author-info">${post.getAuthor().getUsername() }</span>
				<span class="post-content">${post.getContent()}</span>
			</div>
		</c:forEach>
		<div class="t-foot">
			<button id="addPost" class="f-btn">Create Post</button>
		</div>
		<div id="newPost" class="hide">
			<form:form id="createPostForm" modelAttribute="post" action="createPost" method="POST">
				<div class="content-container">
					<form:textarea class="form-control" path="content" name="content" id="content-box"/>
					<form:hidden path="tid"  value="${thread.getId() }" />
					<input type = "submit" class="btn btn-default" value = "Save Post" aria-label="Left Align" />
					
				</div>
			
			</form:form>
		</div>
	</div>
</div>

</body>
</html>