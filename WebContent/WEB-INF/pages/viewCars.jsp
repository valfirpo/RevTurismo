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

<script type="text/javascript" src = "resources/js/main.js"></script>

<title>View Cars</title>
</head>
<body>

	<jsp:include page="bannerAndNav.jsp" />
	
	<c:if test="${sessionScope.currentUser.getRole() != null }">
				
	
	
	<c:if test="${currentUser.getRole() == 3}">
		<div id="wl" class="well">
			<h2 id = "welcome2">${currentUser.getUsername()} current cash:
				$${currentUser.getCash()}</h2>
		</div>
	</c:if>
	<c:if test="${currentUser.getRole() == 3}">

		<h4>Available Cars</h4>
		<table class = "table">
			<thead>
				<tr>
					<th class="col-xs-1">#</th>
					<th class="col-xs-4">Name</th>
					<th class="col-xs-2">Price</th>
					<th class="col-xs-2">Top Speed</th>
					<th class="col-xs-1">Acc</th>
					<th class="col-xs-2"><!-- Button --></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${currentUser.getCars()}">
					<tr>
						<td class="col-xs-1">${c.getId()}</td>
						<td class="col-xs-4">${c.getCarName()}</td>
						<td class="col-xs-2">$ ${c.getPrice()}</td>
						<td class="col-xs-2">${c.getTopSpeed()} MPH</td>
						<td class="col-xs-1">${c.getAcceleration()}</td>
						<td class="col-xs-2"><button onclick = "sellCar(${c.getId()})">Sell</button></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</c:if>

	<h4>Available Cars</h4>
	<table class = "table">
		<thead>
			<tr>
				<th class="col-xs-1">#</th>
				<th class="col-xs-4">Name</th>
				<th class="col-xs-2">Price</th>
				<th class="col-xs-2">Top Speed</th>
				<th class="col-xs-1">Acc</th>
				<th class="col-xs-2"><!-- Button --></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${allCars}">
				<c:if test="${currentUser.getLevel() >= c.getMinLevel()}">
					<tr>
						<td class="col-xs-1">${c.getId()}</td>
						<td class="col-xs-4">${c.getCarName()}</td>
						<td class="col-xs-2">$ ${c.getPrice()}</td>
						<td class="col-xs-2">${c.getTopSpeed()} MPH</td>
						<td class="col-xs-1">${c.getAcceleration()}</td>
						<c:choose>
							<c:when test="${sessionScope.currentUser.getRole() == 3}">
								<td class="col-xs-2"><button
										onclick="buyCar(${c.getId()}, ${c.getPrice()},${currentUser.getCash()})">Buy</button></td>
							</c:when>
							<c:otherwise>
								<td class="col-xs-2"><a href="editCar?cId=${c.getId()}"><button class="btn btn-default">Edit</button></a></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:if>
			</c:forEach>

		</tbody>
	</table>
</c:if>



</body>
</html>