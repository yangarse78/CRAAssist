<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"       	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 		uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
<%-- 	<c:set var = "path" scope = "session" value = "../"/> --%>
	<c:set var = "pageName" scope = "session" value = "Patient Details"/>
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
        	<div class="row">
        		<div class="col-4">
			     	<div class="row">
						<label class="col-sm-5">Subject Number</label>
						<div class="col-sm-7">${patient.subjectId}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-5">Trial Number</label>
						<div class="col-sm-7">${patient.trial.trialNum} - ${patient.trial.name}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-5">Name</label>
						<div class="col-sm-7">
							<span class="">${patient.firstName}</span>
							<span class="">${patient.lastName}</span>						
						</div>
					</div>
			     	<div class="row">
						<label class="col-sm-5">Telephone</label>
						<div class="col-sm-7">${patient.telepone}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-5">Email</label>
						<div class="col-sm-7">${patient.email}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-5">Screening Date</label>
						<div class="col-sm-7"><fmt:formatDate value="${patient.screeningDate}" pattern="dd-MM-yyyy" /></div>
					</div>
			     	<div class="row">
						<label class="col-sm-5">Comment</label>
						<div class="col-sm-7">${patient.comment}</div>
					</div>
				</div>
	   		</div>
			<div class="space"></div>
	   		<div class="row">
				<table class="table table-striped table-bordered">
					  <thead>
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">Treatment</th>
					      <th scope="col">Before Window</th>
					      <th scope="col">Next Visit</th>
					      <th scope="col">After Window</th>
					      <th scope="col">Visit Type</th>
					      <th scope="col">Site Visit Type</th>
					      <th scope="col">Rand</th>
					    </tr>
					  </thead>	
					  <tbody>
						  	<c:forEach items="${patient.visits}" var="visit" varStatus="visitIndex">
								    <tr>
								      <th scope="row">${visit.defVisit.order}</th>
								      <td >
									      <c:forEach items="${visit.defVisit.treatments}" var="treatment" varStatus="treatmentIndex">
									      		<c:out value="${treatment.treatment}"/>
									      		<c:if test="${treatmentIndex.index+1 < visit.defVisit.treatments.size()}">,</c:if> 
									      </c:forEach>
								      </td>
								      <td><fmt:formatDate value="${visit.windowBefore}" pattern="dd-MM-yyyy" /></td>
								      <td><fmt:formatDate value="${visit.visitDate}" pattern="dd-MM-yyyy" /></td>
								      <td><fmt:formatDate value="${visit.windowAfter}" pattern="dd-MM-yyyy" /></td>
								      <td>${visit.defVisit.visitType.visitType}</td>
								      <td>${visit.defVisit.siteVisitType.siteVisitType}</td>
								      <td>
							      			<c:if test="${visit.defVisit.isRandomization}">
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
	   		<button type="button" class="btn btn-secondary" onclick="history.go(-1);">Back</button>
	   </div>
    </body>
    
</html>