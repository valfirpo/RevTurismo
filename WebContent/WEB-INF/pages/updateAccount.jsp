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
		<h3>Update your information</h3> 
	
		<form:form id="updateUser" modelAttribute="user" action="updateAccount" method="POST">
			
				<div class = "input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-user"></i>
					</span>
					<form:label class="form-control" path="">Username:</form:label>
					<form:input class="form-control" path="username" name="username" id="username" placeholder="username"/>
				</div>
				<br>


				<div class = "input-group">
					<span class="input-group-addon"> <i
						class="glyphicon glyphicon-lock"></i>
					</span>
					<form:label class="form-control" path="password">Password:</form:label>
					<form:input class="form-control" path="password" name="password" id="password" placeholder="password"/>
				</div>
				<br>			
			

			<div class = "input-group">
				<span class="input-group-addon"> <i
					class="glyphicon glyphicon-user"></i>
				</span>
				<form:label class="form-control" path="">Firstname:</form:label>
				<form:input class="form-control" path="firstname" name="firstname" id="firstname" placeholder="firstname"/>
			</div>
			<br>

			<div class = "input-group">
				<span class="input-group-addon"> <i
					class="glyphicon glyphicon-user"></i>
				</span>
				<form:label class="form-control" path="">Lastname:</form:label>
				<form:input class="form-control" path="lastname" name="lastname" id="lastname" placeholder="lastname"/>
			</div>
			<br>

			<div class = "input-group">
				<span class="input-group-addon"> <i
					class="glyphicon glyphicon-user"></i>
				</span>
				<form:label class="form-control" path="">Email:</form:label>
				<form:input class="form-control" path="email" name="email" id="email" placeholder="email"/>
			</div>
			<br>
			 
			<div>
				<input type = "submit" value = "Update">
			</div>
		</form:form>
	</div>
</div>

</body>
</html>