<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.rev.bean.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update User</title>
</head>
<body>

<jsp:include page = "bannerAndNav.jsp" />

<div id = "jd" class = "jumbotron">
	<div id = "wl" class = "well">
		<h3>Update you information</h3> 
	
		<form method = "post" action="Update.do">
			<label>Username:</label>
			<div class = "input-group">
				<span class = "input-group-addon"> <i class = "glyphicon glyphicon-user"></i> </span>
				<input type = "text" name = "user" class = "form-control" value = "" required>
			</div>
			<br>
			<label>Password:</label>
			<div class = "input-group">
				<span class = "input-group-addon"> <i class = "glyphicon glyphicon-lock"></i> </span>
				<input type = "password" name = "pass" class = "form-control" value = "" required>
			</div>
			<br>
			<label>First Name:</label>
			<div class = "input-group">
				<span class = "input-group-addon"> <i class = "glyphicon glyphicon-info-sign"></i> </span>
				<input type = "text" name = "fname" class = "form-control" value = "" required>
			</div>
			<br>
			<label>Last Name:</label>
			<div class = "input-group">
				<span class = "input-group-addon"> <i class = "glyphicon glyphicon-info-sign"></i> </span>
				<input type = "text" name = "lname" class = "form-control" value = "" required>
			</div>
			<br>
			<label>Email:</label>
			<div class = "input-group">
				<span class = "input-group-addon"> <i class = "glyphicon glyphicon-envelope"></i> </span>
				<input type = "email" name = "email" class = "form-control" value = "" required>
			</div>
			<br>
			<div>
				<input type = "submit" value = "Update">
			</div>
		</form>
	</div>
</div>

</body>
</html>