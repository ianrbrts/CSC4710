
<!DOCTYPE html>
<html>
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
	color: #07594D;
	background-color: #006bb3;
	border: 5px solid #07594D;
	border-radius: 15px;
	padding: 2px;
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
function CheckPasswordEqual(form)
{
	password1 = form.password1.value;
	password2 = form.password2.value;
	
	if (password1 != password2){
		alert ("Passwords do not match.");
        return false;
    }   
	else {
	    return true; 
    } 
				
		
}
</script>
<meta "charset=UTF-8">
<title>Sign-up Page</title>

</head>

<body>
	
	<h1>Sign-up Page</h1>
	<br>
	<br>
	<form onSubmit="return CheckPasswordEqual(this)" method="post" action="signup">
		
			<label for="username"><b>Email:</label></b> <input type="email"
				id="email" name="email"><br>
			<br> <label for="password"><b>Password:</label></b> <input
				type="password" id="password1" name="password1"><br>
			<br> <label for="password"><b>Confirm Password:</label></b> <input
				type="password" id="password2" name="password2"><br>
			<br> <label for="fname"><b>First Name:</label></b> <input type="text"
				id="fname" name="fname"><br>
			<br> <label for="lname"><b>Last Name:</label></b> <input type="text"
				id="lname" name="lname"><br>
			<br> <label for="fname"><b>Age:</label></b> <input type="text" id="age"
				name="age"><br>
			<br> <input type="submit" id="submitbtn" value="Submit">
		
		<br>
	</form>
	
	
		<form method="post" action="login.jsp">
			<p>
				<u>Already a member?</u>
			</p>
			<input type="submit" id="submitbtn" value="Log in">
		</form>
</body>
</html>