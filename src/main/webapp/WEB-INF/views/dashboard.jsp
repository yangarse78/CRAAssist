<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"       	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%-- 	<c:set var = "path" scope = "session" value = ""/> --%>
	<c:set var = "pageName" scope = "session" value = "Dashboard"/>
    <jsp:include page="headIncludes.jsp" />

    
    <body>
		<jsp:include page="navBar.jsp" />
                
						<div class="container">
							<div class="row" style="margin: 0px">
								<div class="col border">
										<table class="table table-striped">
										  <thead>
										    <tr>
										      <th scope="col">#</th>
										      <th scope="col">Trial Number</th>
										      <th scope="col">Name</th>
										      <th scope="col">Number of Visits</th>
										      <th scope="col">Creation Date</th>
										      <th scope="col">Action</th>
										    </tr>
										  </thead>
										  <tbody>
											  	<c:forEach items="${trials}" var="item" varStatus="itemIndex">
													    <tr>
													      <th scope="row">${itemIndex.index}</th>
													      <td>${item.trialNum}</td>
													      <td>${item.name}</td>
													      <td>${item.numOfVisits}</td>
													      <td>${item.creationDate}</td>
													      <td>
													      		<spring:url value="/trial/${item.id}" var="viewUrl" />
				  												<spring:url value="/trial/${item.id}/update" var="updateUrl" />
													      		<button class="btn btn-info" onclick="location.href='${viewUrl}'">View</button>
				  												<button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>	
													      </td>
													    </tr>
											    </c:forEach>
										  </tbody>
										</table>
								</div>
							    <div class="w-100"></div>
							    <div class="col border">Column</div>
							</div>
					</div>
		
    </body>
    
</html>