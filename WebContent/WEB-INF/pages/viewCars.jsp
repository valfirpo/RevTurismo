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

<jsp:include page = "bannerAndNav.jsp" />

<div id = "wl" class = "well" >
	<h2>${currentUser.getUsername()} current cash: $${currentUser.getCash()}</h2>
</div>

<c:if test="${currentUser.getRole().getUrId() == 3}">
	<div class="container">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>Cars Owned</h4>
				</div>
				<table class="table table-fixed">
					<thead>
						<tr>
							<th class="col-xs-1">#</th>
							<th class="col-xs-4">Name</th>
							<th class="col-xs-2">Price</th>
							<th class="col-xs-2">Top Speed</th>
							<th class="col-xs-1">Acc</th>
							
						</tr>
					</thead>
					<tbody>
						
						<c:forEach var="c" items="${currentUser.getCars()}">
							<tr>	
								<td class="col-xs-1">${c.getId()}</td>
								<td class="col-xs-4">${c.getCarName()}</td>
								<td class="col-xs-2">Price</td>
								<td class="col-xs-2">Top Speed</td>
								<td class="col-xs-1">Acc</td>
							</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
</c:if>	
	<div class="container">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>Available Cars</h4>
				</div>
				<table class="table table-fixed">
					<thead>
						<tr>
							<th class="col-xs-1">#</th>
							<th class="col-xs-4">Name</th>
							<th class="col-xs-2">Price</th>
							<th class="col-xs-2">Top Speed</th>
							<th class="col-xs-1">Acc</th>
							<th class="col-xs-2">.</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="c" items="${allCars}">
							<tr>
								<td class="col-xs-1">${c.getId()}</td>
								<td class="col-xs-4">${c.getCarName()}</td>
								<td class="col-xs-2">${c.getPrice()}</td>
								<td class="col-xs-2">Top Speed</td>
								<td class="col-xs-1">Acc</td>
								<c:choose>
									<c:when test="${sessionScope.currentUser.getRole().getUrId() == 3}">
										<td class="col-xs-2"><button onclick = "buy(${c.getId()}, ${c.getPrice()},${currentUser.getCash()})">Buy</button></td>
									</c:when>
									<c:otherwise>
										<td class="col-xs-2"><button>Edit</button></td>
									</c:otherwise>
								</c:choose>
								
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>