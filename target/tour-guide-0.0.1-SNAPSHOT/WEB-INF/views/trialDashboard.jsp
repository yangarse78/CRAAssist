<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"       	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<c:set var = "path" scope = "session" value = "../"/>
    <jsp:include page="headIncludes.jsp" />
    
    
    
    <body>
    	<jsp:include page="navBar.jsp" />
    	
    	
        <div class="container">
			     <h2>Trial Dashboard</h2>
			     	<div class="row">
						<label class="col-sm-2">Trial Number</label>
						<div class="col-sm-10">${trial.trialNum}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Trial Name</label>
						<div class="col-sm-10">${trial.name}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Number Of Visits</label>
						<div class="col-sm-10">${trial.numOfVisits}</div>
					</div>
	<%-- 		     	<div class="row">
						<label class="col-sm-2">Interval</label>
						<div class="col-sm-10">
							<span class="">${trial.interval}</span>
							<span class="">${trial.intervalType.intervalType}</span>
						</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Visit Type</label>
						<div class="col-sm-10">${trial.visitType.visitType}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Site Visit Type</label>
						<div class="col-sm-10">${trial.siteVisitType.siteVisitType}</div>
					</div> --%>
			     	<div class="row">
						<label class="col-sm-2">Comments</label>
						<div class="col-sm-10">${trial.comment}</div>
					</div>			     
			     
			     <div class="row">
								<div class="col">
										<table class="table table-striped">
										  <thead>
										    <tr>
										      <th scope="col">#</th>
										      <th scope="col">Subject Id</th>
										      <th scope="col">First Name</th>
										      <th scope="col">Last Name</th>
										      <th scope="col">Telephone</th>
										      <th scope="col">Email</th>
										      <th scope="col">Screening Date</th>
										      <th scope="col"></th>
										    </tr>
										  </thead>
										  <tbody>
											  	<c:forEach items="${trial.patients}" var="patient" varStatus="patientIndex">
													    <tr>
													      <th scope="row">${patientIndex.index}</th>
													      <td>${patient.subjectId}</td>
													      <td>${patient.firstName}</td>
													      <td>${patient.lastName}</td>
													      <td>${patient.telepone}</td>
													      <td>${patient.email}</td>
													      <td>${patient.screeningDate}</td>
													      <td>
													      		<spring:url value="/patient/${patient.id}" var="viewUrl" />
				  												<spring:url value="/patient/${patient.id}/update" var="updateUrl" />
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