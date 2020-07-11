<!DOCTYPE html>

<head>
<link rel="stylesheet" type="text/css" href="index.css">
<style>

label {
	display: inline-block;
	width: 150px;
	margin-right: 15px;
	text-align: left;
}

input {
	width: 200px;
	margin: 0px auto;
}

#submitbtn {
	display: inline-block;
	 width: 200px;
	height: auto;
	font-size: 20px;
	font-weight: bold;
	color: #99ccff;
	background-color: #806000;
	border: 5px solid #07594D;
	border-radius: 15px;
	padding: 2px;
}
h1 {
	color: #99ccff;
	margin-block-start: 5px;
	margin-block-end: 5px;
}
prompts {
	color: #99ccff;
	margin-block-start: 5px;
	margin-block-end: 5px;
}
body {
	border: 4px solid #ff9900;
	border-radius: 20px;
	margin: 5px;
	padding: 5px;
	background-color: #cf941f;
	background-size: 100% 100%;
	text-align: center;
}
</style>
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
			return true; 
		} 
			
		
				
				
		
	</script>
<meta "charset=UTF-8">
<title>Log in</title>
<link rel="stylesheet" href="index.css">
</head>

<body>
	<h>
	<h1>Login page</h1></h>
	<br>
	<br>
	<form onSubmit="return CheckPassword(this)" method="post" action="login">
			<label for="username"><prompts><b>Username:</label></prompts></b> <input type="email"
				id="email" name="email"><br>
			<br> <label for="password"><prompts><b>Password:</label></prompt></b> <input
				type="password" id="password1" name="password1"><br>
			<br> <label for="password"><prompts><b>Confirm Password:</label></prompts></b> <input
				type="password" id="password2" name="password2"><br>
				<br> <input type="submit" id="submitbtn" value="Submit">
		
		</form>
</body>
</html>
