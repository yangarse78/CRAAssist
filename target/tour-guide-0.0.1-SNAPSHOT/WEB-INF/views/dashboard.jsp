<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <jsp:include page="headIncludes.jsp" />
    
    
    <body>
		<jsp:include page="navBar.jsp" />
			<div class="container">
				<table class="table">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Trial Number</th>
				      <th scope="col">Name</th>
				      <th scope="col">Number of Visits</th>
				    </tr>
				  </thead>
				  <tbody>
					  	<c:forEach items="${trials}" var="item" varStatus="itemIndex">
							    <tr>
							      <th scope="row">${itemIndex}</th>
							      <td>${item.trialNum}</td>
							      <td>${item.name}</td>
							      <td>${item.numOfVisits}</td>
							    </tr>
					    </c:forEach>
				    
				  </tbody>
				</table>
		</div>

		
    </body>
    
</html>