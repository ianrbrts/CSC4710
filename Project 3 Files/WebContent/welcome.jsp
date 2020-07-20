<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<meta charset="ISO-8859-1">
<title>Root Login successful!</title>
<link rel="stylesheet" href="index.css">
</head>

<body>
	<h1>Logged in as Root!</h1>
	<br>
	<br>
	
	<!-- init database button for root user -->
	<form method='post' action='drop'>
		<input type='submit' id="submitbtn" value='Initialize Database'>
	</form>
	
	<br><br>
	
	<!-- sorting comedians button for root user -->
	<form action="showcomedians" method="post">
		<input type="submit" id="submitbtn" value="Find Comedians">
	</form>
	
	<br><br><h1>Normal User Functions:</h1>
	
	<form method="post" action="gotoinsert">
		<input type="submit" id="submitbtn" value="Insert Video">
	</form>
	
	<br>
	<br>
	<p>Search:</p>
	
	<form action="search" method="post">
		<input type="text" name="params">
		<input type="submit" id="submitbtn" value="Submit">
	</form>
	
	<br><br>
	
	<form action="showfavorites" method="post">
		<input type="submit" id="submitbtn" value="Go to favorites">
	</form>
	
	<br><br>
	
	
</body>
	