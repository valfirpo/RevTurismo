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
<title>Edit Challenges</title>
</head>
<body>
<jsp:include page = "bannerAndNav.jsp" />
	
<div id="jd" class="jumbotron">
	<div id="wl" class="well">
		<div id="challenge-edit" class="container">
			<form:form id="editChallenge" modelAttribute="Challenge"
				action="editChallenge" method="POST">
				<div class="input-group">
					<form:label class="form-control" path="name">${challenge.getName()}</form:label>
					<form:input class="form-control" path="name" />
				</div>
				<div class="input-group">
					<form:label class="form-control" path="reward">${challenge.getReward()}</form:label>
					<form:input class="form-control" path="reward" />
				</div>
				<div class="input-group">
					<form:label class="form-control" path="level">${challenge.getLevel() }</form:label>
					<form:input class="form-control" path="level" />
				</div>
				<div class="input-group">
					<form:label class="form-controL" path="entryFee">${challenge.getEntryFee() }</form:label>
					<form:input class="form-control" path="entryFee" />
				</div>
				<div class="input-group">
					<form:label class="form-control" path="time">${challenge.getTime() }</form:label>
					<form:input class="form-control" path="time" />
				</div>
				
				
				
				
				
			</form:form> 
		</div>
	</div>
</div>

</body>
</html>