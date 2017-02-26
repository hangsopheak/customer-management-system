<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>My Profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
<style>
body{padding-top:30px;}

.glyphicon {  margin-bottom: 10px;margin-right: 10px;}

small {
display: block;
line-height: 1.428571429;
color: #999;
}
</style>
</head>
<body>
	<div class="container">
	    <div class="row">
	        <div class="col-xs-12 col-sm-8 col-md-8">
	            <div class="well well-sm">
	                <div class="row">
	                    <div class="col-sm-6 col-md-4">
	                        <img src="<%= (request.getAttribute("urlPhoto") == "" ? "http://placehold.it/380x500" : request.getAttribute("urlPhoto")) %>" alt="" class="img-rounded img-responsive" />
	                    </div>
	                    <div class="col-sm-6 col-md-8">
	                        <h4>
	                            My Profile
	                         	&nbsp;|&nbsp;<a href="/logout">Logout</a>
	                         </h4>
	                        <p>
	                            <label>User ID: &nbsp;</label><%= request.getAttribute("userId") %>
	                            <br />
	                            <label>Email: &nbsp;</label><%= request.getAttribute("email") %>
	                            <br />
	                            <label>Created Date: &nbsp;</label><%= request.getAttribute("createdDate") %>
	                        	<br />
	                            <label>Photo URL: &nbsp;</label></i><%= request.getAttribute("urlPhoto") %>
	                        </p>
	                        <!-- Split button -->
	                        <div class="btn-group">
	                            <form action="uploadServlet" method="post" enctype="multipart/form-data">
									<input type="file" name="file" size="50" />
									<br />
									<input type="submit" class="btn btn-primary" value="Upload File" />
								</form>
	                        </div>
	                        
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
	
	
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>
