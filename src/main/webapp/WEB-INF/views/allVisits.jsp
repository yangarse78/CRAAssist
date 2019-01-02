<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"       	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" 		uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html>
	<c:set var = "pageName" scope = "session" value = "All Visits"/>
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



	<script type="text/javascript">
	
    /* Create an array with the values of all the checkboxes in a column */
    $.fn.dataTable.ext.order['dom-checkbox'] = function  ( settings, col )
    {
        return this.api().column( col, {order:'index'} ).nodes().map( function ( td, i ) {
            return $('input', td).prop('checked') ? 'checked' : '';
        } );
    }
    
    
	$(document).ready(function() {

			
	    // DataTable
	    var table = $('#visitsTable').DataTable({
	    	"searching": false,
	    	"lengthMenu": [[5, 10, 15, -1], [5, 10, 15, "All"]],
	    	"pagingType": "numbers",
	    	"sPaginationType": "four_button",
	    	"columns": [
	            null,
	            null,
	            null,
	            null,
	            null,
	            null,
	            null,
	            null,
	            { "orderDataType": "dom-checkbox" }
	        ]
	    });
	 


	} );
	

	</script>


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
								<table class="table table-striped table-bordered display" id="visitsTable">
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
											    <tr data-toggle="modal" data-target="#myModal_${visitIndex.index}">
											      <th scope="row">${visitIndex.index}</th>
											      <td>${visit.patient.subjectId}</td>
											      <td>${visit.patient.trial.name}</td>
											      <td>${visit.patient.firstName} ${visit.patient.lastName}</td>
											      <td>${visit.patient.telepone}</td>
											      <td style="width: 20%">
											      		<fmt:formatDate value="${visit.windowBefore}" pattern="dd/MM/yyyy" />
											      		 - 
											      		<fmt:formatDate value="${visit.windowAfter}" pattern="dd/MM/yyyy" />
											      </td>
											      <td>
												      <c:forEach items="${visit.defVisit.treatments}" var="treatment" varStatus="treatmentIndex">
												      		<c:out value="${treatment.treatment}"/>
												      		<c:if test="${treatmentIndex.index+1 < patient.nearestVisitForDash.defVisit.treatments.size()}">,</c:if> 
												      </c:forEach>
											      </td>
											      <td>
											      		<fmt:formatDate value="${visit.plannedVisitDate}" pattern="dd/MM/yyyy" />
												  </td>
												  <td>
												  		<div class="checkbox">
															<input type="checkbox"  <c:if test="${visit.isVisited == 'true'}">checked</c:if> disabled="disabled">
														</div>
												  </td>
											    </tr>
									    </c:forEach>
									            <tfoot>
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
										        </tfoot>
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