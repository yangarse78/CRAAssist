<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
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
        <div class="container">
    		<h2>Add New Trial</h2>
			<form:form action="trial/addTrial" method="post" modelAttribute="trial">
		    	<div class="row">
			    	<div class="col">
					    	<div class="form-group">
							    <form:label path="trialNum">Trial Number</form:label>
							    <form:input path="trialNum" cssClass="form-control" id="trialNum"/>
							</div>
							<div class="form-group">
							    <label for="TroialName">Trial Name</label>
							    <form:input path="name" type="text" cssClass="form-control" id="trialName" placeholder="Enter Trial name"/>
							</div>
							<div cssClass="form-group">
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
			    	<div class="col">
							<div class="form-group">
								<div class="row">
									<div class="col-8">
							    		<label for="Interval">Interval</label>
							    		<form:input path="interval" type="text" cssClass="form-control" id="interval" placeholder="Enter an interval"/>
							    	</div>
							    	<div class="col-4">
										<fieldset style="padding-top: 37px;">
											<label class="radio">
												<form:radiobutton path="intervalType" value="1" checked="checked" />
												days
											</label>
											<label class="radio">
												<form:radiobutton path="intervalType" value="2" />
												weeks
											</label>
										</fieldset>
							    	</div>
							    </div>
							</div>	
							<div class="form-group">
							    <div class="input-group mb-3">
									  <div class="input-group-prepend">
									    	<label class="input-group-text" for="VisitType">Visit Type</label>
									  </div>
									  <form:select path="visitType" cssClass="custom-select" id="visitType" onchange="visitTypeChanged(this.value);">
										    <option selected>Choose...</option>
										    <option value="1">Telephone</option>
										    <option value="2">Site Visit</option>
									  </form:select>
								</div>
							</div>
							<div class="form-group" id="siteVisitTypeDiv" style="display: none">
							    <div class="input-group mb-3">
									  <div class="input-group-prepend">
									    	<label class="input-group-text" for="SiteVisitType">Site Visit Type</label>
									  </div>
									  <select path="siteVisitType" class="custom-select" id="siteVisitType">
										    <option selected>Choose...</option>
										    <option value="1">Normal</option>
										    <option value="2">Fasting</option>
									  </select>
								</div>
							</div>							
			    	</div>
		    	</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
   		</div>
    </body>
    
</html>