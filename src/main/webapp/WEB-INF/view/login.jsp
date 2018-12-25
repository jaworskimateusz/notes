<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Notes</title>
	<link rel="icon" href="${pageContext.request.contextPath}/resources/img/pen-icon.png" type="image/png">
	
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">

</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('${pageContext.request.contextPath}/resources/img/login-bg.jpg');">
			<div class="fixed-top pt-3 ml-3">
				<a class=" btn btn-outline-secondary" href="index">
					<img src="${pageContext.request.contextPath}/resources/img/pen-icon.png"/>
				</a>
			</div>
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
				Sign in
				</span>
				<form:form action="${pageContext.request.contextPath}/authenticate-user" method="POST" class="login100-form validate-form p-b-33 p-t-5">
					<c:if test="${param.error != null}">
						<div class="alert alert-dark col-xs-offset-1 col-xs-10 mx-4 mt-3 text-center">
							<p>Invalid username and password.</p>
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-info col-xs-offset-1 col-xs-10 mx-4 mt-3 text-center">
							<p>You have been logged out.</p>
						</div>
					</c:if>
					<div class="wrap-input100 validate-input" data-validate = "Enter Username">
						<input class="input100" type="text" name="username" placeholder="Userame">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>

					<div class="container-login100-form-btn m-t-32">
						<button type="submit" class="login100-form-btn">
							Login
						</button>
					</div>
					<div class="text-center mt-3">
					<p>
						First time here? <a class="text-info" href="registration"> Create an account.</a>	
					</p>
					</div>
					
				</form:form>
			</div>
		</div>
	</div>
	

	<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>