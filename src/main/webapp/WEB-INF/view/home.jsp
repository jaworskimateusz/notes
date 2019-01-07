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
       	  <a class="navbar-brand btn btn-outline-secondary rounded" href="${pageContext.request.contextPath}/home">
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
    <h1 class="my-3">Home Page</h1>    
	<h2 class="mb-3">Welcome ${user.userName}, Let's make some notes!</h2>
	<div class="row mb-3"> 
		<button class="ml-3 mt-2 btn btn-outline-dark rounded" onclick="location.href='${pageContext.request.contextPath}/home/add-note'"> 
			Add new <i class="ml-2 fas fa-plus"></i>
		</button>
		<form:form action="${pageContext.request.contextPath}/home/search-notes" method="POST" class="mt-2 col row justify-content-end">
			<input type="text" name="searchInput" class="pl-2" placeholder="Search..." />
			<button type="submit" class="btn btn-outline-dark rounded-right" >
				<i class="fas fa-search"></i>
			</button>
		</form:form>
	</div>
		<div class="dropdown row justify-content-end mt-2 mb-2">
		  <button class="btn btn-outline-dark rounded dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Sort by
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			  <form:form action="${pageContext.request.contextPath}/home/order-notes" method="POST">
			    <input type="submit"  class="dropdown-item" value="Ascending date" name="sequence"/>
			    <input type="submit"  class="dropdown-item" value="Descending date" name="sequence"/>
			    <input type="submit"  class="dropdown-item" value="Ascending priority" name="sequence"/>
			    <input type="submit"  class="dropdown-item" value="Descending priority" name="sequence"/>
			  </form:form>
		  </div>
		</div>
	    <div class="row">
	    <c:if test="${empty user.notes}">
		    <p class="col row justify-content-center">
		   		No suitable notes found. <i class="ml-2 mt-1 fas fa-exclamation-circle"></i>
		    </p>
	     </c:if>
	   	<c:forEach var="note" items="${user.notes}">
			<c:url var="updateNote" value="/home/update-note">
				<c:param name="noteId" value="${note.noteId}" />
			</c:url>	
			<c:url var="deleteNote" value="/home/delete-note">
				<c:param name="noteId" value="${note.noteId}" />
			</c:url>	       
	       <div class="col-lg-4 col-sm-6 my-2">
	         <div class="card h-100">
	           <img class="card-img-top" src="${pageContext.request.contextPath}/resources/img/note-bg.jpg" alt="note-img">
	            <div class="card-body">
	             <h3 class="card-title">
	      	     	<c:if test="${note.priority == 'high'}">
	        			<i class="far fa-star float-right"></i>
	        		</c:if>  
	        		${note.title} 
	             </h3>
	             <p class=" mt-1 card-text"> ${note.content} </p>
	           </div>
	           <div class="row">
		           <span class="ml-3 mb-2 col-sm-1">
		           		<a href="${updateNote}" ><i class="fas fa-edit"></i></a>
		           </span>
		           <span class="mb-2 col-sm-3">
		          		<a href="${deleteNote}" class=" mb-2 col-sm-1" onclick="loaction.reload()" ><i class="fas fa-trash-alt"></i></a>
		           </span>
		           <span class="small col row justify-content-end mr-2">${note.modificationDate}</span>
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
