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
#searchSubmitBtn {
	float: right;
	padding: 6px;
	margin-top:8px;
	margin-right: 16px;
	background-color: #80600;
	font-size: 20px;
	border: 5px solid #07594D;
	cursor: pointer;

}
h1 {
	color: #99ccff;
	margin-block-start: 5px;
	margin-block-end: 5px;
}
h2 {
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
	<h1>Root User Functions:</h1>

	
	<!-- init database button for root user -->
	<form method='post' action='drop'>
		<input type='submit' id="submitbtn" value='Initialize Database'>
	</form>
	
	<!-- sorting comedians button for root user -->
	<form action="showcomedians" method="post">
		<input type="submit" id="submitbtn" value="Find Comedians">
	</form>
	
	<br><br><h1>Normal User Functions:</h1>
	
	<form method="post" action="gotoinsert">
		<input type="submit" id="submitbtn" value="Insert Video">
	</form>
		<form action="showfavorites" method="post">
		<input type="submit" id="submitbtn" value="Go to favorites">
	</form>
	
	<br>
	<br>
	<h2><center>Looking for a video?</center></h2>
	<div class="searchSubmitBtn">
	<form action="search" method="post">
		<input type="text" name="params" placeholder="Search...">
		<br>
		<input type="submit" id="submitbtn" value="Submit">
	</form>
	</div>
	<br><br>
	
	<br><br>
	<br><br>

</body>
