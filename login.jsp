<!DOCTYPE html>

<head>
	<script>
		function CheckPassword(form)
		{
			password1 = form.password1.value;
			password2 = form.password2.value;
			
			if (password1 == '')
				alert ("Please enter a password");
			
			else if (password2 == '')
				alert ("Please enter a password");
			else if (password1 != password2)
				{
					alert ("Please make sure that the passwords match");
					return false;
				}
			else {
				alert ("Password match!");
			return true; 
				} 
			
			//Hi Ian
				
				
		}
	</script>
	<meta"charset=UTF-8">
	<title>Log in</title>
	<link rel="stylesheet" href="index.css">
</head>

<body>
	<h><u>Login page</u></h>
	<br><br>
	<form onSubmit = "return CheckPassword(this)">
	<form method="post" action="placeholder.php">
		<label for="username">Username:</label>
		<input type="email" id="username" name="username"><br><br>
		<label for="password">Password:</label>
		<input type="text" id="password1" name="password1"><br><br>
		<label for="password">Confirm Password:</label>
		<input type="text" id="password2" name="password2"><br><br>
		
		<input type="submit" value="Submit">
	  </form>
</body>
