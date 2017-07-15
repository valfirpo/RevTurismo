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
			
			<form:form id="editChallenge" modelAttribute="challenge"
				action="updateChallenge" method="POST">
				<form:hidden path="id" value="${challenge.getId() }"/>
				
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-flag"></i>
					</span>
					<form:label class="form-control" path="name">Name</form:label>
					<form:input class="form-control" path="name" />
				</div>
				<br>
				
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-star"></i>
					</span>
					<form:label class="form-control" path="level">Min Level</form:label>
					<form:input class="form-control" path="level" />
				</div>
				<br>
				
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-usd"></i>
					</span>
					<form:label class="form-control" path="reward">Reward</form:label>
					<form:input class="form-control" path="reward" />
				</div>
				<br>
				
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-usd"></i>
					</span>
					<form:label class="form-control" path="entryFee">Entry Fee</form:label>
					<form:input class="form-control" path="entryFee" />
				</div>
				<br>
				
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-time"></i>
					</span>
					<form:label class="form-control" path="time">Time</form:label>
					<form:input class="form-control" path="time" />
				</div>
				<br>
				
				<div class="input-group">
					<input type="submit" class="btn btn-default" value="Edit Challenge" />
				</div>
			</form:form> 
			
		</div>
	</div>
</div>

</body>
</html>