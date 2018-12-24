<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"       	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" 		uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" 		uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<%-- <c:set var = "path" scope = "session" value = "../"/> --%>
	<c:set var = "pageName" scope = "session" value = "Trial Dashboard"/>
    <jsp:include page="headIncludes.jsp" />
    
    <style type="text/css">
    	.randImg{
    		background-image: url('../images/checked40x40.png');
    		height: 40px;
    		margin-left: -8%;
    		background-repeat: no-repeat;
    	}
    	.space { margin:0; padding:0; height:30px; }
    </style>
    
    <body>
    	<jsp:include page="navBar.jsp" />
    	
    	
        <div class="container">
			     <div class="row" style="max-height: 250px;overflow: auto;">
			     
			     	<div class="col-4">

				     	<div class="row">
							<label class="col-sm-5">Trial Number</label>
							<div class="col-sm-7">${trial.trialNum}</div>
						</div>
				     	<div class="row">
							<label class="col-sm-5">Trial Name</label>
							<div class="col-sm-7">${trial.name}</div>
						</div>
				     	<div class="row">
							<label class="col-sm-5">Number Of Visits</label>
							<div class="col-sm-7">${trial.numOfVisits}</div>
						</div>
				     	<div class="row">
							<label class="col-sm-5">Comments</label>
							<div class="col-sm-7" style="overflow: auto; max-height: 50px;">${trial.comment}</div>
						</div>	
					</div>
					<div class="col-8">
						<table class="table table-sm">
							  <thead>
							    <tr>
							      <th scope="col">#</th>
							      <th scope="col">Treatment</th>
							      <th scope="col">Interval</th>
							      <th scope="col">+/-</th>
							      <th scope="col">Visit Type</th>
							      <th scope="col">Site Visit Type</th>
							      <th scope="col">Rand</th>
							    </tr>
							  </thead>	
							  <tbody>
								  	<c:forEach items="${trial.visits}" var="visit" varStatus="visitIndex">
										    <tr>
										      <th scope="row">${visit.order}</th>
										      <td >
											      <c:forEach items="${visit.treatments}" var="treatment" varStatus="treatmentIndex">
											      		<c:out value="${treatment.treatment}"/>
											      		<c:if test="${treatmentIndex.index+1 < visit.treatments.size()}">,</c:if> 
											      </c:forEach>
										      </td>
										      <td><span>${visit.interval}</span> <span>${visit.intervalType.name}</span></td>
										      <td><span>${visit.visitWindow}</span> <span>${visit.visitWindowType.name}</span></td>
										      <td>${visit.visitType.visitType}</td>
										      <td>${visit.siteVisitType.siteVisitType}</td>
										      <td>
										      			<c:if test="${visit.isRandomization}">
										      				<div  style="text-align: center;"> 
										      					<!-- <img src="../images/checked.png"  style="max-width: 44px"> -->
										      					<div class="randImg"></div>
										      				</div>
										      			</c:if>
										      </td>
										    </tr>
								    </c:forEach>
							  </tbody>
						</table>						
					</div>		     
			     </div>
			     <div class="space"></div>
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
											      <th scope="row">${patientIndex.index +1}</th>
											      <td>${patient.subjectId}</td>
											      <td>${patient.firstName}</td>
											      <td>${patient.lastName}</td>
											      <td>${patient.telepone}</td>
											      <td>${patient.email}</td>
											      <td><fmt:formatDate value="${patient.screeningDate}" pattern="dd-MM-yyyy" /></td>
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
				<button type="button" class="btn btn-secondary" onclick="history.go(-1);">Back</button>
	   		</div>
    </body>
</html>