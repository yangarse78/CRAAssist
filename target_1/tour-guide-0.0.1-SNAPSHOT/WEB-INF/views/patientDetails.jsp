<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c"       	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<c:set var = "path" scope = "session" value = "../"/>
    <jsp:include page="headIncludes.jsp" />
    
    
    
    <body>
    	<jsp:include page="navBar.jsp" />
    	
    	
        <div class="container">
			     <h2>Patient Details</h2>
			     	<div class="row">
						<label class="col-sm-2">Subject Number</label>
						<div class="col-sm-10">${patient.subjectId}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Trial Number</label>
						<div class="col-sm-10">${patient.trial.trialNum}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Name</label>
						<div class="col-sm-10">
							<span class="">${patient.firstName}</span>
							<span class="">${patient.lastName}</span>						
						</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Telephone</label>
						<div class="col-sm-10">${patient.telepone}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Email</label>
						<div class="col-sm-10">${patient.email}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Screening Date</label>
						<div class="col-sm-10">${patient.screeningDate}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Comment</label>
						<div class="col-sm-10">${patient.comment}</div>
					</div>
	   		</div>
    </body>
    
</html>