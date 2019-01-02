<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"       	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 		uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
	<c:set var = "pageName" scope = "session" value = "Dashboard"/>
    <jsp:include page="headIncludes.jsp" />

	<style type="text/css">
		th, td {text-align: center}
		

	.checkbox {
		  zoom: 2;
		  transform: scale(2);
		  -ms-transform: scale(2);
		  -webkit-transform: scale(2);
		  -o-transform: scale(2);
		  -moz-transform: scale(2);
		
		  -ms-transform-origin: 0 0;
		
		  -o-transform-origin: 0 0;
		  -moz-transform-origin: 0 0;
		 
		}
	</style>


    <body>
		<jsp:include page="navBar.jsp" />
                
             

                
                
                
           <form:form action="updatePatientVisits" method="post" modelAttribute="pVisits" id="pVisitForm">   
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
								      <th scope="col">Subject</th>
								      <th scope="col">Trial</th>
								      <th scope="col">Name</th>
								      <th scope="col">Telephone</th>
								      <th scope="col">Visit window</th>
								      <th scope="col">Treatment</th>
								      <th scope="col">Planned visit date</th>
								      <th scope="col">Done</th>
								    </tr>
								  </thead>
								  <tbody id="myTable">
					  
									  	<c:forEach items="${pVisits.visits}" var="visit" varStatus="visitIndex">
												<%@include file="visitModal.jsp" %>
									  	
									  			<form:hidden path="visits[${visitIndex.index}].patient.id"/>
									  			<form:hidden path="visits[${visitIndex.index}].defVisit.id"/>
									  			<form:hidden path="visits[${visitIndex.index}].id"/>
									  			<form:hidden path="visits[${visitIndex.index}].windowBefore"/>
									  			<form:hidden path="visits[${visitIndex.index}].visitDate"/>
									  			<form:hidden path="visits[${visitIndex.index}].windowAfter"/>
									  			
											    <tr>
											      <th scope="row"  data-toggle="modal" data-target="#myModal_${visitIndex.index}">${visitIndex.index}</th>
											      <td data-toggle="modal" data-target="#myModal_${visitIndex.index}">${visit.patient.subjectId}</td>
											      <td data-toggle="modal" data-target="#myModal_${visitIndex.index}">${visit.patient.trial.name}</td>
											      <td data-toggle="modal" data-target="#myModal_${visitIndex.index}">${visit.patient.firstName} ${visit.patient.lastName}</td>
											      <td data-toggle="modal" data-target="#myModal_${visitIndex.index}">${visit.patient.telepone}</td>
											      <td data-toggle="modal" data-target="#myModal_${visitIndex.index}" style="width: 20%">
											      		<fmt:formatDate value="${visit.windowBefore}" pattern="dd/MM/yyyy" />
											      		 - 
											      		<fmt:formatDate value="${visit.windowAfter}" pattern="dd/MM/yyyy" />
											      </td>
											      <td data-toggle="modal" data-target="#myModal_${visitIndex.index}">
												      <c:forEach items="${visit.defVisit.treatments}" var="treatment" varStatus="treatmentIndex">
												      		<c:out value="${treatment.treatment}"/>
												      		<c:if test="${treatmentIndex.index+1 < patient.nearestVisitForDash.defVisit.treatments.size()}">,</c:if> 
												      </c:forEach>
											      </td>
											      <td>
												  	 	<form:input path="visits[${visitIndex.index}].plannedVisitDate" type="date" cssClass="form-control" placeholder="dd"/>
												  </td>
												  <td>
												  		<div class="checkbox">
															<form:checkbox path="visits[${visitIndex.index}].isVisited" />
														</div>
												  </td>
											    </tr>
									    </c:forEach>
								  </tbody>
								</table>
								<div>
									<button type="submit" class="btn btn-primary">Update</button>
								</div>
						</div>
					</div>
				</div>
		</form:form>		
				
				
				
    </body>
    
</html>