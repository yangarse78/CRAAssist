<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"       	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 		uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
<%-- 	<c:set var = "path" scope = "session" value = ""/> --%>
	<c:set var = "pageName" scope = "session" value = "Dashboard"/>
    <jsp:include page="headIncludes.jsp" />

	<style type="text/css">
		th, td {text-align: center}
	</style>

    
    <body>
		<jsp:include page="navBar.jsp" />
                
				<div class="container">
					<div class="row">
						<div class="col-4">
							<input class="form-control" id="myInput" type="text" placeholder="Search..">
						</div>
					</div>
					<div class="w-100"></div>
					<div class="row">
					    <div class="col ">
								<table class="table table-striped table-bordered">
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
								  <tbody id="myTable">
									  	<c:forEach items="${trials}" var="item" varStatus="itemIndex">
											    <tr>
											      <th scope="row">${itemIndex.index}</th>
											      <td>${item.trialNum}</td>
											      <td>${item.name}</td>
											      <td>${item.numOfVisits}</td>
											      <td><fmt:formatDate value="${item.creationDate}" pattern="dd-MM-yyyy" /></td>
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
					</div>
				</div>
    </body>
    
</html>