<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <jsp:include page="headIncludes.jsp" />
    
    
    <body>
        <div class="container">
			
			<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			  	<a class="navbar-brand" href="#">Dashboard<span class="sr-only">(current)</span></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
				  	<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavDropdown">
					<ul class="navbar-nav">
						<li class="nav-item active">
							<a class="nav-link" href="/tour-guide/addTrial">Add New Trial</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#">Features</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#">Pricing</a>
						</li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#"
									id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"> Dropdown link </a>
							
							<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
								<a class="dropdown-item" href="/tour-guide/addTrial">Add New Trial</a> <a
									class="dropdown-item" href="#">Another action</a> <a
									class="dropdown-item" href="#">Something else here</a>
							</div></li>
					</ul>
				</div>
		</nav>

   		</div>
    </body>
    
</html>