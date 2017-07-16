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


<title>Home Page</title>
</head>
<body class="container-fluid">

<<<<<<< HEAD
<jsp:include page = "bannerAndNav.jsp" />

<c:if test="${sessionScope.currentUser.getRole() == null }">
	<c:choose>
		<c:when test="${session.getAttribute('user') == null }">
			<div id="jd" class="jumbotron">
				<div id="wl" class="well">
					<h1 id="welcome">Welcome to RevTurismo</h1>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div id="wl" class="well">
							<h2>Login</h2>
=======
	<jsp:include page="bannerAndNav.jsp" />

	<c:if test="${sessionScope.currentUser == null }">
		<c:choose>
			<c:when test="${session.getAttribute('user') == null }">
				<div id="jd" class="jumbotron">
					<div id="wl" class="well">
						<h1 id="welcome">Welcome to RevTurismo</h1>
					</div>
					<div class="row">
						<div class="col-lg-6">
							<div id="wl" class="well">
								<h2>Login</h2>
>>>>>>> e13ea8851988b2b4343738d4ef74378519cf59e6


								<c:if test="${sessionScope.errorMessage != null }">
									<div class="alert alert-danger">INVALID USERNAME OR
										PASSWORD</div>
								</c:if>

								<form:form id="loginForm" modelAttribute="login" action="index"
									method="POST">


									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-user"></i>
										</span>
										<!-- 						<input type = "text" name = "user" class = "form-control" placeholder = "username" required>
-->
										<form:label class="form-control" path="username">Username:</form:label>
										<form:input class="form-control" path="username"
											name="username" id="username" placeholder="username"
											required="required" />

									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon"> <i
											class="glyphicon glyphicon-lock"></i>
										</span>
										<!-- 						<input type = "password" name = "pass" class = "form-control" placeholder = "password" required>
-->
										<form:label class="form-control" path="password">Password:</form:label>
										<form:password class="form-control" path="password"
											name="password" id="password" placeholder="password"
											required="required" />
									</div>

									<br>
									<div>
										<%-- 										<form:button id="login" name="login">Login</form:button>
 --%>
										<input type="submit" class="btn btn-default" value="Login"
											aria-label="Left Align">

										<c:if test="${sessionScope.errorMessage != null }">

											<div class="form-group">
												<a href="#forgot" data-toggle="modal"> Forgot Password?
												</a>

											</div>
										</c:if>


									</div>


								</form:form>

							</div>
						</div>
					</div>
				</div>
<<<<<<< HEAD
			</div>
	<c:if test="${sessionScope.errorMessage != null  }">
	
	
	<form:form id="forgotForm" modelAttribute="user" action="forgotPass"
								method="POST"> 		
	<div class="modal fade" id="forgot">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-header">
               <button type="button" class="close" data-dismiss='modal' aria-hidden="true"><span class="glyphicon glyphicon-remove"></span></button>
               <h4 class="modal-title" style="font-size: 32px; padding: 12px;"> Recover Your Password </h4>
            </div>

            <div class="modal-body">
               <div class="container-fluid">
                  <div class="row">
                     <div class="col-xs-12 col-sm-12 col-md-12">
                        <div class="form-group">
                           <div class="input-group">
                              <div class="input-group-addon iga2">
                                 <span class="glyphicon glyphicon-user"></span>
                              </div>
                              <input value="${currentUser.getUsername()}"  id="username" type="text" class="form-control" placeholder="Enter Your Username" name="username">
                           </div>
                        </div>
                     </div>
                  </div>

                  <div class="row">
                     <div class="col-xs-12 col-sm-12 col-md-12">
                        <div class="form-group">
                           <div class="input-group">
                              <div class="input-group-addon iga2">
                                 <span class="glyphicon glyphicon-lock"></span>
                              </div>
                              <input value="${currentUser.getPassword()}" id="password" type="password" class="form-control" placeholder="Enter Your New Password" name="password">
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="row">
                     <div class="col-xs-12 col-sm-12 col-md-12">
                        <div class="form-group">
                           <div class="input-group">
                              <div class="input-group-addon iga2">
                                 <span class="glyphicon glyphicon-lock"></span>
                              </div>
                              <input value= "${currentUser.getConfirmPassword()}" id = "confirmPassword" type="password" class="form-control" placeholder="Confirm Your New Password" name="confirmPassword">
                              
                           </div>
                        </div>
                     </div>
                  </div>
                  
               </div>
            </div>

            <div class="modal-footer">
               <div class="form-group">
                  <button type="submit" class="btn btn-lg btn-info">Save<span class="glyphicon glyphicon-saved"></span></button>

                  <button type="button" data-dismiss="modal" class="btn btn-lg btn-default"> Cancel <span class="glyphicon glyphicon-remove"></span></button>
               </div>
            </div>
         </div>
      </div>
   </div>
</form:form>			
</c:if>	
			
			
			
			
			
			
			
			
			
			
			
		</c:when>
=======
				<c:if test="${sessionScope.errorMessage != null  }">
					<form:form id="forgotForm" modelAttribute="user"
						action="forgotPass" method="POST">
						<div class="modal fade" id="forgot">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss='modal'
											aria-hidden="true">
											<span class="glyphicon glyphicon-remove"></span>
										</button>
										<h4 class="modal-title"
											style="font-size: 32px; padding: 12px;">Recover Your
											Password</h4>
									</div>

									<div class="modal-body">
										<div class="container-fluid">
											<div class="row">
												<div class="col-xs-12 col-sm-12 col-md-12">
													<div class="form-group">
														<div class="input-group">
															<div class="input-group-addon iga2">
																<span class="glyphicon glyphicon-user"></span>
															</div>
															<input id="username" type="text" class="form-control"
																placeholder="Enter Your Username" name="username">
														</div>
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-xs-12 col-sm-12 col-md-12">
													<div class="form-group">
														<div class="input-group">
															<div class="input-group-addon iga2">
																<span class="glyphicon glyphicon-lock"></span>
															</div>
															<input type="password" class="form-control"
																placeholder="Enter Your New Password" name="newpwd">
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-xs-12 col-sm-12 col-md-12">
													<div class="form-group">
														<div class="input-group">
															<div class="input-group-addon iga2">
																<span class="glyphicon glyphicon-lock"></span>
															</div>
															<input type="password" class="form-control"
																placeholder="Confirm Your New Password"
																name="confirmNewpwd">
														</div>
													</div>
												</div>
											</div>

										</div>
									</div>

									<div class="modal-footer">
										<div class="form-group">
											<button type="submit" class="btn btn-lg btn-info">
												Save <span class="glyphicon glyphicon-saved"></span>
											</button>

											<button type="button" data-dismiss="modal"
												class="btn btn-lg btn-default">
												Cancel <span class="glyphicon glyphicon-remove"></span>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form:form>
				</c:if>
			</c:when>
>>>>>>> e13ea8851988b2b4343738d4ef74378519cf59e6
		</c:choose>
	</c:if>

<<<<<<< HEAD
		
		<c:if  test = "${sessionScope.currentUser.getRole() != null}">
			<div id="jd" class="jumbotron">
				<div id="wl" class="well">
					<h1 id="welcome">Welcome to RevTurismo</h1>
				</div>
				<div id="wl" class="well">
					<p>You are logged in to RevTurismo as a ${sessionScope.currentUser.getUserRole()}, 
						${sessionScope.currentUser.getUsername()}!
						RevTurismo is a car collecting application was created by
						RevTurismo Group. Group members: Lucas Vance, Paul Wesson,
						Matthew Young & Valentin Firpo.</p>
				</div>
=======
	<c:if test="${sessionScope.currentUser != null}">
		<div id="jd" class="jumbotron">
			<div id="wl" class="well">
				<h1 id="welcome">Welcome to RevTurismo</h1>
>>>>>>> e13ea8851988b2b4343738d4ef74378519cf59e6
			</div>
			<div id="wl" class="well">
				<p>You are logged in to RevTurismo as a
					${sessionScope.currentUser.getUserRole()},
					${sessionScope.currentUser.getUsername()}! RevTurismo is a car
					collecting application was created by RevTurismo Group. Group
					members: Lucas Vance, Paul Wesson, Matthew Young & Valentin Firpo.</p>
			</div>
		</div>
	</c:if>

</body>
</html>