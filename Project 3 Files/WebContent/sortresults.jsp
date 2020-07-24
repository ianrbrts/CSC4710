<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Find ${descriptor}!</title>

</head>
<body >
<br><br>
	<h1>Sort by ${descriptor}</h1>
	<h2>${descriptor2}</h2>
	
	<table border="0" cellpadding="5" style="margin-left:auto; margin-right:auto; ">

		<c:forEach var="video" items="${list}" >
					
                <tr>
                    <td>${video.comedian}</td>
                    <td><a href="${video.URL}">${video.URL}</a></td>
                    <td>${video.email}</td> <!-- email is a placeholder, can be other things but i keep using one class/constructor for all of these queries so that's what it is -->
                                        
                    <td>
	                    <form action="getcomediansvideos" method="post">
	                    	<input type="hidden" name="comedian" id="button" value="${video.comedian}"><!-- comedian is also a placeholder for the first value in constructor -->
	                    	<input type="submit" id="submitbtn" value="${buttonlabel}">
	                 	</form>  
                    </td>
                    
                    
                   <br>
                   
                </tr>
        </c:forEach>
	</table>
	<br>
	<button id="submitbtnback" onclick="goBack()">Go Back</button>

	<br>
	
	</body>
