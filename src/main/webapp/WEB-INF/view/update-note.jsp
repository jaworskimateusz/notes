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
				Add/Edit note
				</span>
				<form:form action="${pageContext.request.contextPath}/home/save-note" method="POST" modelAttribute="note" class="login100-form validate-form p-b-33 p-t-5">
					<div class="wrap-input100 validate-input" >
						<form:input path="title" class="input100" type="text"  placeholder="Title"/>
						<form:errors path="title" class="ml-5 help-block text-danger small"/>
						<span class="focus-input100" data-placeholder="">
						</span>
					</div>
					<div class="wrap-input100 validate-input" >
						<form:textarea path="content" class="input100" type="text" placeholder="Content"/>
						<form:errors path="content" class="ml-5 help-block text-danger small"/>
						<span class="focus-input100" data-placeholder=""></span>
					</div>
					<div class="wrap-input100 validate-input" >
						<span class="input100">Set high/low priority
							<form:radiobutton path="priority" class="ml-3" value="h" />
							<form:radiobutton path="priority" class="ml-3" value="l" />
						</span>
						<span class="focus-input100" data-placeholder=""></span>
					</div>
					<div class="container">
						<div class="row">
							<div class="container-login100-form-btn m-t-32 col-sm-6">
								<a class="login100-form-btn" href="${pageContext.request.contextPath}/home">
								Back
								</a>
							</div>
						<div class="container-login100-form-btn m-t-32 col-sm-6">
							<button type="submit" class="login100-form-btn">
								Save
							</button>
						</div>
					</div>
					</div>
					
				</form:form>
			</div>
		</div>
	</div>
	

	<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>