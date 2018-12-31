<div class="container">
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	  	<a class="navbar-brand" href="/tour-guide">Dashboard<span class="sr-only">(current)</span></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		  	<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown"  style="position: relative;">
				<div class="h2" style="color: white;position: absolute;right: 0;">${pageName}</div>
			<ul class="navbar-nav">
				<li class="nav-item active">
					<a class="nav-link" href="/tour-guide/trial/trialList">Trials</a>
				</li>
<!-- 				<li class="nav-item">
					<a class="nav-link" href="/tour-guide/gotoAddPatient">Add New Patient</a>
				</li> -->
<!-- 				<li class="nav-item">
					<a class="nav-link" href="#">Pricing</a>
				</li> -->
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">Action</a>
					
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="/tour-guide/gotoAddTrial">Add New Trial</a> <a
							class="dropdown-item" href="/tour-guide/gotoAddPatient">Add New Patient</a> <a
							class="dropdown-item" href="#">Something else here</a>
					</div></li>
			</ul>
			
		</div>
  	</nav>
</div>