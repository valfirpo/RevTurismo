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
			
			<form:form id="editCar" modelAttribute="car"
				action="updateCar" method="POST">
				<form:hidden path="id" value="${car.getId() }"/>
				
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-pencil"></i>
					</span>
					<form:label class="form-control" path="carName">Car Name</form:label>
					<form:input class="form-control" path="carName" />
				</div>
				<br>
				
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-usd"></i>
					</span>
					<form:label class="form-control" path="price">Car Price</form:label>
					<form:input class="form-control" path="price" />
				</div>
				<br>
				
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-time"></i>
					</span>
					<form:label class="form-control" path="topSpeed">Top Speed</form:label>
					<form:input class="form-control" path="topSpeed" />
				</div>
				<br>
				
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-road"></i>
					</span>
					<form:label class="form-control" path="handling">Car Handling</form:label>
					<form:input class="form-control" path="handling" />
				</div>
				<br>
				
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-fire"></i>
					</span>
					<form:label class="form-control" path="acceleration">Acceleration</form:label>
					<form:input class="form-control" path="acceleration" />
				</div>
				<br>
				
				<br>
				
				<div class="input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-star"></i>
					</span>
					<form:label class="form-control" path="minLevel">Car Level</form:label>
					<form:input class="form-control" path="minLevel" />
				</div>
				<br>
				
				<div class="input-group">
					<input  type="submit" class="btn btn-default" value="Edit Car" />
				</div>
			</form:form> 
			
		</div>
	</div>
</div>

</body>
</html>