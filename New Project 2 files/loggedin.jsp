<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login successful!</title>
</head>
<body>
	<p>You are logged in!</p>
	
	<br>
	<br>
	<p>Search:</p>
	
	<form action="search" method="post">
		<input type="text" name="params">
		<input type="submit" value="submit">
	</form>
	
	<br><br>
	
	<form action="showfavorites" method="post">
		<input type="submit" value="Go to favorites">
	</form>
</body>
</html>