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
#submitbtnback {
	display: inline-block;
	 width: 100px;
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
function goBack() {
	window.history.go(-1);
}
</script>
<meta charset="ISO-8859-1">
<title>Find Comedians!</title>

</head>
<body>
<br><br>
	<h1>Find Comedians</h1>
	<table style="margin-left:auto; margin-right:auto;">
		<tr>
			<td>
				<form action="cool" method="post">
					<input type="submit" id="submitbtn" value="Who's Cool?">
				</form>
			</td>
				
			<td>				
				<form action="new" method="post">
					<input type="submit" id="submitbtn" value="Who's New?">
				</form>
			</td>	
				
			<td>
				<form action="hot" method="post">
					<input type="submit" id="submitbtn" value="Who's Hot?">
				</form>
				
			</td>
			<td>
				
				<form action="top" method="post">
					<input type="submit" id="submitbtn" value="Who's Top?">
				</form>
				
			</td>
			<td>
				
				<form action="popular" method="post">
					<input type="submit" id="submitbtn" value="Popular Tags">
				</form>
			</td>
		</tr>
	
	
	
	
		<tr>
				
			<td>
				<form action="commonfav" method="post">
					<input type="submit" id="submitbtn" value="Common favorite comedian">
				</form>
				
			</td>
			<td>
				
				<form action="productive" method="post">
					<input type="submit" id="submitbtn" value="Most Productive Users">
				</form>
				
			</td>
			<td>
				
				<form action="positive" method="post">
					<input type="submit" id="submitbtn" value="Positive Reviewers">
				</form>
				
			</td>
			<td>
				
				<form action="poor" method="post">
					<input type="submit" id="submitbtn" value="Poor YouTube Videos">
				</form>
				
			</td>
			<td>
				<form action="twin" method="post">
					<input type="submit" id="submitbtn" value="Twin Users">
				</form>
				
			</td>
		</tr>
	</table>
	
	<br>
	
	<button id="submitbtnback" onclick="goBack()">Go Back</button>
</body>
