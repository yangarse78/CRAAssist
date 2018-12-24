<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"       	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<c:set var = "pageName" scope = "session" value = "New Patient"/>
<%-- 	<c:set var = "path" scope = "session" value = ""/> --%>
    <jsp:include page="headIncludes.jsp" />
    
    <script>
    $(document).ready(function(){
      var date_input=$('input[name="screeningDate"]'); //our date input has the name "date"
      //var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
      var options={
        format: 'dd/mm/yyyy',
        //container: container,
        todayHighlight: true,
        autoclose: true,
      };
      date_input.datepicker(options);
    })
</script>


    <body>
        <jsp:include page="navBar.jsp" />
        	
        	
        <div class="container">
		 <form:form action="patient/addPatient" method="post" modelAttribute="patient">
		    	<div class="row">
			    	<div class="col">
					    	<div class="form-group">
							    <label for="trialNum">Subject Id</label>
							    <form:input path="subjectId" cssClass="form-control" id="subjectId"/>
							</div>
							<div class="form-group">
							    <label for="TrialNumber">Trial Number</label>
<%-- 							    	  <form:select path="selectedTrial"  cssClass="custom-select" id="selectedTrial" >
									        <form:option value="-" label="--Please Select"/>
      										<form:options items="${trialList}" itemValue="id" itemLabel="trialNum" />
									  </form:select> --%>
									<select name="selectedTrial" class="custom-select">
										<option value="-" label="--Please Select"/>
									    <c:forEach var="selectedTrial" items="${trialList}" >
									        <option value="${selectedTrial.id}" label="${selectedTrial.trialNum} - ${selectedTrial.name}"/>
									    </c:forEach>
									</select>									  
							</div>
							<div class="form-group">
							    <label for="firstName">First Name</label>
							    <form:input path="firstName" type="text" cssClass="form-control" id="firstName" placeholder="Enter first name"/>
							</div>
							<div class="form-group">
							    <label for="lastName">Last Name</label>
							    <form:input path="lastName" type="text" cssClass="form-control" id="lastName" placeholder="Enter last name"/>
							</div>
						</div>
						<div class="col">
							<div class="form-group">
							    <label for="Phone">Phone</label>
							    <form:input path="telepone" type="text" cssClass="form-control" id="telepone" placeholder="Enter phone number"/>
							</div>
							<div class="form-group">
							    <label for="Email">Email</label>
							    <form:input path="email" type="text" cssClass="form-control" id="email" placeholder="Enter email"/>
							</div>
							<div class="form-group">
							    <label for="Screeningdate">Screening date</label>
							    <form:input path="screeningDate" type="text" cssClass="form-control" id="screeningDate" placeholder="DD/MM/YYYY"/>
							</div>	
							<div class="form-group">
								 <div class="form-group">
								   <label for="PatientComments">Comments</label>
								   <form:textarea path="comment" cssClass="form-control" id="patientComments" rows="3"/>
								 </div>
							</div>								
					</div>
		    	</div>
				<button type="submit" class="btn btn-primary">Submit</button>
				<button type="button" class="btn btn-secondary" onclick="history.go(-1);">Cancel</button>
			</form:form>
   		</div>
    </body>
    
</html>