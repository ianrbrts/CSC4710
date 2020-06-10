<!DOCTYPE html>

<head>
	<script>
		function CheckPasswordEqual(form)
		{
			password1 = form.password1.value;
			password2 = form.password2.value;
			
			if (password1 != password2){
				alert ("Please make sure passwords match.");
                return false;
            }   
			else {
			    return true; 
            } 
						
				
		}
	</script>
	<meta"charset=UTF-8">
    <title>Sign-up Page</title>
    <link rel="stylesheet" href="index.css">
</head>

<body>
	<h><u>Sign-up page</u></h>
	<br><br>
	<form onSubmit = "return CheckPasswordEqual(this)">
	<form method="post" action="placeholder.php">
		<label for="username">Email:</label>
        <input type="email" id="username" name="username"><br><br>
        
		<label for="password">Password:</label>
        <input type="password" id="password1" name="password1"><br><br>
        
		<label for="password">Confirm Password:</label>
        <input type="password" id="password2" name="password2"><br><br>

        <label for="fname">First Name:</label>
        <input type="text" id="fname" name="fname"><br><br>

        <label for="lname">Last Name:</label>
        <input type="text" id="lname" name="lname"><br><br>

        <label for="fname">Age:</label>
        <input type="text" id="age" name="age"><br><br>
        
		<input type="submit" id="submitbtn" value="Submit">
      </form>
      <br>

    <form method="post" action="login.jsp">
        <p>Already a member?</p>
        <input type="submit" id="submitbtn" value="Log in">
    </form>
      
</body>