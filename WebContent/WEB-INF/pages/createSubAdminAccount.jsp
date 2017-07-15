<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="resources/css/main.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>Create SubAdmin Account</title>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

</head>
<body class="container-fluid">

	<jsp:include page="bannerAndNav.jsp" />


	<!-- CREATE SUBADMIN ACCOUNT FORM -->
	<div id="jd" class="jumbotron">
		<div class="row">
			<div class="col-lg-6">
				<div id="wl" class="well">
					<h2>Create SubAdmin Account</h2>

					<form:form id="userForm" modelAttribute="user"
						action="createSubUserAccount" method="POST">


						<form:label class="form-control" path="username">Username:</form:label>
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user"></i>
							</span>
							<form:input class="form-control" path="username" name="username"
								id="username" placeholder="username" required="required" />
						</div>
						<br>
						
						<form:label class="form-control" path="password">Password:</form:label>
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-lock"></i>
							</span>
							<form:password class="form-control" path="password"
								name="password" id="password" placeholder="password"
								required="required" />
						</div>
						<div>
							<form:errors path="password" cssClass="error" />
						</div>
						<br>
						
						<form:label class="form-control" path="confirmPassword">Confirm Password:</form:label>
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-lock"></i>
							</span>
							<form:password class="form-control" path="confirmPassword"
								name="confirmPassword" id="confirmPassword"
								placeholder="password" required="required" />
						</div>
						<div>
							<form:errors path="confirmPassword" cssClass="error" />
						</div>
						<br>
						
						<div>
							<input id="register" type="submit" class="btn btn-default"
								value="Create" aria-label="Left Align">
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>