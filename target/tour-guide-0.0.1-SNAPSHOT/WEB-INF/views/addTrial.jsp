<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"       	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<c:set var = "path" scope = "session" value = ""/>
    <jsp:include page="headIncludes.jsp" />
    
    
    <script type="text/javascript">
    	function visitTypeChanged(chosenVal) {
    		if(chosenVal == "2")
    			jQuery('#siteVisitTypeDiv').show('slow');
    		else
    			jQuery('#siteVisitTypeDiv').hide('slow');
		}
    
    </script>
    
    <body>
    	<jsp:include page="navBar.jsp" />
    
    
        <div class="container">
    		<h2>Add New Trial</h2>
			<form:form action="trial/addTrial" method="post" modelAttribute="trial">
		    	<div class="row">
		    		<div class="col-8">
				    	<div class="form-group">
						    <form:label path="trialNum">Trial Number</form:label>
						    <form:input path="trialNum" cssClass="form-control" id="trialNum"/>
						</div>
						<div class="form-group">
						    <label for="TroialName">Trial Name</label>
						    <form:input path="name" type="text" cssClass="form-control" id="trialName" placeholder="Enter Trial name"/>
						</div>
						<div class="form-group">
						    <label for="NumOfVisits">Number Of Visits</label>
						    <form:input path="numOfVisits" type="text" cssClass="form-control" id="numOfVisits" placeholder="Enter number of visits"/>
						</div>
						<div class="form-group">
							 <div class="form-group">
							   <label for="TrialComments">Comments</label>
							   <form:textarea path="comment" cssClass="form-control" id="trialComments" rows="3"/>
							 </div>
						</div>
					</div>
			    </div>
			    <div class="row">
			    	<button type="submit" name="editVisits" class="btn btn-secondary">Edit Visits</button>
									<table class="table table-striped">
										  <thead>
										    <tr>
										      <th scope="col">#</th>
										      <th scope="col">Treatment</th>
										      <th scope="col">Visit Type</th>
										      <th scope="col">Interval</th>
										      <th scope="col">Interval Type</th>
										      <th scope="col">Site Visit Type</th>
										      <th scope="col"></th>
										    </tr>
										  </thead>
										  <tbody>
											  	<c:forEach items="${trial.visits}" var="visit" varStatus="visitIndex">
													    <tr>
													      <th scope="row">${visitIndex.index}</th>
													      <td>
																<fieldset style="padding-top: 37px;">
																			<c:forEach items="${treatmentsList}" var="opt" varStatus="optionIndex">
																					<label class="radio">
																						<form:radiobutton path="${visit.selectedTreatment}"  
																														value="${opt.id}" 
																														label="${opt.treatment}"/>
																					</label>
																			</c:forEach>
																</fieldset>														      
													      
													      
													      </td>
													      <td>
													      		<form:input path="${visit.interval}" type="text" cssClass="form-control" id="interval_${visitIndex.index}" placeholder="Enter an interval"/>
													      </td>
													      <td>
																<fieldset style="padding-top: 37px;">
																			<c:forEach items="${intervalTypeList}" var="opt" varStatus="optionIndex">
																					<label class="radio">
																						<form:radiobutton path="${visit.selectedIntervalType}"  
																														value="${opt.id}" 
																														label="${opt.intervalType}"/>
																					</label>
																			</c:forEach>
																</fieldset>													      
													      </td>
<%-- 													      <td>${visit.siteVisitType}</td>
													      <td>${visit.screeningDate}</td> --%>
													    </tr>
											    </c:forEach>
										  </tbody>
									</table>			    
			    
			    
			    
	
<%-- 						<div class="form-group">
						    <div class="input-group mb-3">
								  <div class="input-group-prepend">
								    	<label class="input-group-text" for="VisitType">Visit Type</label>
								  </div>
								  <form:select path="selectedVisitType"  cssClass="custom-select" id="selectedVisitType" onchange="visitTypeChanged(this.value);">
								        <form:option value="-" label="--Please Select"/>
     										<form:options items="${visitTypeList}" itemValue="id" itemLabel="visitType"/>
								  </form:select>
							</div>
						</div>
						<div class="form-group" id="siteVisitTypeDiv" style="display: none">
						    <div class="input-group mb-3">
								  <div class="input-group-prepend">
								    	<label class="input-group-text" for="SiteVisitType">Site Visit Type</label>
								  </div>
								  <form:select path="selectedSiteVisitType"  cssClass="custom-select" id="siteVisitType">
								        <form:option value="-" label="--Please Select"/>
     										<form:options items="${siteVisitTypeList}" itemValue="id" itemLabel="siteVisitType"/>
								  </form:select>
							</div>
						</div>		 --%>					
		    	</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
   		</div>
    </body>
    
</html>