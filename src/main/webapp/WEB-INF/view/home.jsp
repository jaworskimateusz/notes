<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Notes</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/img/pen-icon.png" type="image/png">

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
    <!-- Custom fonts for this template -->
    <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/clean-blog.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  </head>

  <body>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" id="mainNav">
      <div class="container">
       	  <a class="navbar-brand btn btn-outline-secondary rounded" href="home">
			<img src="${pageContext.request.contextPath}/resources/img/pen-icon-black.png"/>
		  </a>
          <button class="btn-small navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
            <i class="fas fa-bars"></i>
          </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
			<li class="nav-item mt-1">
				<form:form action="${pageContext.request.contextPath}/logout" method="POST">
              		<input class="btn btn-sm btn-outline-dark rounded "  type="submit" value="Logout" />
              	</form:form>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container mt-5"> <br>
    <h1 class="my-4">Home Page</h1>    
	<h2 class="mb-3">Welcome ${user.userName}, Let's make some notes!</h2>
	<button class="btn btn-outline-dark rounded mb-3"> 
		Add new <i class=" ml-2 fas fa-plus"></i>
	</button>
	    <div class="row">
	   	<c:forEach var="note" items="${user.notes}" >
	       <div class="col-lg-4 col-sm-6 my-2">
	         <div class="card h-100">
	           <img class="card-img-top" src="${pageContext.request.contextPath}/resources/img/note-bg.jpg" alt="note-img">
	            <div class="card-body">
	             <h3 class="card-title">
	               ${note.title}
	             </h3>
	             <p class="card-text"> ${note.content} </p>
	           </div>
	         </div>
	       </div>
	    </c:forEach>
	    </div>
    </div>
    <hr>
    <!-- Footer -->
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto my-auto">
            <ul class="list-inline text-center">
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
            </ul>
            <p class="copyright text-muted">Copyright &copy; Your Website 2018</p>
          </div>
        </div>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="${pageContext.request.contextPath}/resources/js/clean-blog.min.js"></script>

  </body>

</html>
