              <div class="modal fade" id="myModal_${visitIndex.index}" role="dialog">
				    <div class="modal-dialog" style="max-width: 800px;">
					      <!-- Modal content-->
					      <div class="modal-content">
					        <div class="modal-header">
					          	<h4 class="modal-title">
										${visit.patient.subjectId} - ${visit.patient.firstName} ${visit.patient.lastName}
								</h4>
					          <button type="button" class="close" data-dismiss="modal">&times;</button>
					        </div>
					        <div class="modal-body">
					        	<div class="container-fluid">
						        	<div class="row">
		      									<div class="col font-weight-bold">Visit From</div>
		      									<div class="col font-weight-bold">Visit Date</div>
		      									<div class="col font-weight-bold">Visit To</div>
		      									<div class="col font-weight-bold">Visit Type</div>
		      									<div class="col font-weight-bold">Site Visit Type</div>
						        	</div>
						        	<div class="row">
						          				<div class="col"><fmt:formatDate value="${visit.windowBefore}" pattern="dd/MM/yyyy" /></div>
						          				<div class="col"><fmt:formatDate value="${visit.visitDate}" pattern="dd/MM/yyyy" /></div>
						          				<div class="col"><fmt:formatDate value="${visit.windowAfter}" pattern="dd/MM/yyyy" /></div>
						          				<div class="col">${visit.defVisit.visitType.visitType}</div>
						          				<div class="col">${visit.defVisit.siteVisitType.siteVisitType}</div>												        	
						        	</div>
					          	</div>
					        </div>
					        <div class="modal-footer">
					          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					        </div>
					      </div>
				    </div>
			</div>