<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/login.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="wrapper">
			<form class="form-signin" action="login" method="post">
				<h3 class="form-signin-heading">
					
					<b style="color: #c7c7c7 !important">Customer Management</b>
				</h3>

				<input type="text" class="form-control" name="username"
					placeholder="Username" required="" autofocus="" /><br /> 
				<input
					type="password" class="form-control" name="password"
					placeholder="Password" required="" />

				<button class="btn btn-lg btn-primary btn-block" name="Submit"
					value="Login" type="Submit">Login</button>
			</form>
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>
