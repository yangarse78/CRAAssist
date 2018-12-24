<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"       	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

    <jsp:include page="headIncludes.jsp" />
    
    
    <script type="text/javascript">
    	function visitTypeChanged(chosenVal, selectedId) {
     		if(chosenVal == "2")
    			jQuery('#siteVisitType_' + selectedId).show('slow');
    		else
    			jQuery('#siteVisitType_' + selectedId).hide('slow'); 
		}
    	
    	function addVisits(trial_id) {
    		var action = '../' + trial_id + '/updateVisits';
    		
	   		$('#trialForm').attr('action', action);
	   		$("#trialForm").submit();
   		}
    	
    	function disableOtherChkBoxes(checkedRand){
    		if($('#' + checkedRand).is(':checked')){
    			$('input:checkbox[id^="randChkBox_"]:not(:checked)').prop("disabled", true);
    		} else {
    			$('input:checkbox[id^="randChkBox_"]').prop("disabled", false);
    		}
    	}
    
    </script>
    
    <body>
    	<jsp:include page="navBar.jsp" />
    
    
        <div class="container">
    		<h2>Update Trial</h2>
			<form:form action="updateTrial" method="post" modelAttribute="trial" id="trialForm">
				<form:hidden path="id"/>
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
						    <form:input path="numOfVisits" type="text" cssClass="form-control" id="numOfVisits" placeholder="Enter number of visits" onchange="addVisits(${trial.id})"/>
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
							      <th scope="col">Randomization</th>							      
							    </tr>
							  </thead>
							  <tbody>
								  	<c:forEach items="${trial.visits}" var="visit" varStatus="visitIndex">
								  		<form:hidden path="visits[${visitIndex.index}].order" value="${visitIndex.index+1}"/>
										    <tr>
										      <th scope="row">${visitIndex.index+1}</th>
										      <td style="width: 200px">
													<div class="well" style="max-height: 100px;overflow: auto;">
														<ul class="list-group checked-list-box">														
																<c:forEach var="i" varStatus="treatment" items="${treatmentsList}"> 
															             	<li class="list-group-item" style="padding: 5px">           
															                    <form:checkbox cssStyle="margin-bottom:0px" path = "visits[${visitIndex.index}].selectedTreatmentsList"  value="${i.id}" />
															                    <c:out value="${i.treatment}"/>
															                    <form:errors path="visits[${visitIndex.index}].selectedTreatmentsList" cssClass="error" />
																			</li>                      	
															     </c:forEach>	
														</ul>
													</div>													      
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
										      <td>
													<fieldset>
														<form:checkbox cssStyle="margin-bottom:0px"
																		onclick="disableOtherChkBoxes(this.id)"
																		id="randChkBox_${visitIndex.index+1}" 
																		path="visits[${visitIndex.index}].isRandomization" />
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