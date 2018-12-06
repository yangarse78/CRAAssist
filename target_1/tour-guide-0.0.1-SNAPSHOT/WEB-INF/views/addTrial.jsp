<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"       	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%-- 	<c:set var = "path" scope = "session" value = ""/>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/> --%>
    <jsp:include page="headIncludes.jsp" />
    
    
    <script type="text/javascript">
    	function visitTypeChanged(chosenVal, selectedId) {
     		if(chosenVal == "2")
    			jQuery('#siteVisitType_' + selectedId).show('slow');
    		else
    			jQuery('#siteVisitType_' + selectedId).hide('slow'); 
		}
    	
    	function addVisits() {
    		var action = 'trial/editVisits';
    		if(location.pathname.indexOf('/trial/') != -1)
    			action = 'editVisits';
    		
	   		$('#trialForm').attr('action', action);
	   		$("#trialForm").submit();
   		}
    
    </script>
    
    <body>
    	<jsp:include page="navBar.jsp" />
    
    
        <div class="container">
    		<h2>Add New Trial</h2>
			<form:form action="addTrial" method="post" modelAttribute="trial" id="trialForm">
		    	<div class="row">
		    		<div class="col-8">
				    	<div class="form-group">
						    <form:label path="trialNum">Trial Number</form:label>
						    <form:input path="trialNum" cssClass="form-control" id="trialNum"/>
						    <form:errors path="trialNum" cssClass="alert-danger" />
						</div>
						<div class="form-group">
						    <label for="TroialName">Trial Name</label>
						    <form:input path="name" type="text" cssClass="form-control" id="trialName" placeholder="Enter Trial name"/>
						</div>
						<div class="form-group">
						    <label for="NumOfVisits">Number Of Visits</label>
						    <form:input path="numOfVisits" type="text" cssClass="form-control" id="numOfVisits" placeholder="Enter number of visits" onchange="addVisits()"/>
						    <form:errors path="numOfVisits" cssClass="alert-danger" />
						</div>
						<div class="form-group">
							 <div class="form-group">
							   <label for="TrialComments">Comments</label>
							   <form:textarea path="comment" cssClass="form-control" id="trialComments" rows="3"/>
							   <form:errors path="comment" cssClass="alert-danger" />
							 </div>
						</div>
					</div>
			    </div>
			    <div class="row">
						<table class="table table-striped">
							  <thead>
							    <tr>
							      <th scope="col">#</th>
							      <th scope="col">Treatment</th>
							      <th scope="col">Interval</th>
							      <th scope="col">Interval Type</th>
							      <th scope="col">Visit Window</th>
							      <th scope="col">Window Type</th>
							      <th scope="col">Visit Type</th>
							      <th scope="col">Site Visit Type</th>
							    </tr>
							  </thead>
							  <tbody>
								  	<c:forEach items="${trial.visits}" var="visit" varStatus="visitIndex">
								  		<form:hidden path="visits[${visitIndex.index}].order" value="${visitIndex.index+1}"/>
										    <tr>
										      <th scope="row">${visitIndex.index+1}</th>
										      <td>
													<fieldset>
																<form:select path="visits[${visitIndex.index}].selectedTreatment"  cssClass="custom-select" id="treatment_${visitIndex.index+1}">
															        <form:option value="0" label="--Please Select"/>
							     									<form:options items="${treatmentsList}" itemValue="id" itemLabel="treatment"/>
															    </form:select>
													</fieldset>														      
										      </td>
										      <td>
										      		<form:input path="visits[${visitIndex.index}].interval" type="text" cssClass="form-control" id="interval_${visitIndex.index+1}" placeholder="Enter an interval"/>
										      </td>
										      <td>
													<fieldset>
																<form:select path="visits[${visitIndex.index}].selectedIntervalType"  cssClass="custom-select" id="intervalType_${visitIndex.index+1}">
															        <form:option value="0" label="--Please Select"/>
							     									<form:options items="${trialTimeUnitList}" itemValue="id" itemLabel="name"/>
															    </form:select>
													</fieldset>												      
										      </td>
										      <td>
										      		<form:input path="visits[${visitIndex.index}].visitWindow" type="text" cssClass="form-control" id="visitWindow_${visitIndex.index+1}" placeholder="Enter an visit window"/>
										      </td>
										      <td>
													<fieldset>
																<form:select path="visits[${visitIndex.index}].selectedVisitWindowType"  cssClass="custom-select" id="visitWindowType_${visitIndex.index+1}">
															        <form:option value="0" label="--Please Select"/>
							     									<form:options items="${trialTimeUnitList}" itemValue="id" itemLabel="name"/>
															    </form:select>
													</fieldset>												      
										      </td>										      
											      <td>
														<fieldset>
																<form:select path="visits[${visitIndex.index}].selectedVisitType" cssClass="custom-select" id="visitType_${visitIndex.index+1}" onchange="visitTypeChanged(this.value, ${visitIndex.index+1});">
															        <form:option value="0" label="--Please Select"/>
							     									<form:options items="${visitTypeList}" itemValue="id" itemLabel="visitType"/>
															    </form:select>
														</fieldset>													      
											      </td>
										      <td>
													<fieldset>
															<form:select path="visits[${visitIndex.index}].selectedSiteVisitType" cssClass="custom-select" id="siteVisitType_${visitIndex.index+1}" cssStyle="display: none">
														        <form:option value="0" label="--Please Select"/>
						     									<form:options items="${siteVisitTypeList}" itemValue="id" itemLabel="siteVisitType"/>
														    </form:select>
													</fieldset>														      
										      </td>
										    </tr>
								    </c:forEach>
							  </tbody>
						</table>			    
		    	</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
   		</div>
    </body>
    
</html>