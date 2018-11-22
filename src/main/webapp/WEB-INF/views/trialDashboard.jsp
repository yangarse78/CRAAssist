<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <jsp:include page="headIncludes.jsp" />
    
    
    <body>
    	<jsp:include page="navBar.jsp" />
        <div class="container">
	     <h2>Trial Dashboard</h2>
	     
			     
			     	<div class="row">
						<label class="col-sm-2">Trial Number</label>
						<div class="col-sm-10">${trial.trialNum}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Trial Name</label>
						<div class="col-sm-10">${trial.name}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Number Of Visits</label>
						<div class="col-sm-10">${trial.numOfVisits}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Comments</label>
						<div class="col-sm-10">${trial.comment}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Interval</label>
						<div class="col-sm-10">${trial.interval}</div>
						<div class="col-sm-10">${trial.intervalType.intervalType}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Visit Type</label>
						<div class="col-sm-10">${trial.visitType.visitType}</div>
					</div>
			     	<div class="row">
						<label class="col-sm-2">Site Visit Type</label>
						<div class="col-sm-10">${trial.siteVisitType.siteVisitType}</div>
					</div>
			     
	     
   
	   		</div>
    </body>
    
</html>