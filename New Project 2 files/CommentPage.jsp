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
	
	width: 300px;
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
<meta "charset=UTF-8">
<title>Comment Page</title>

</head>

<body>
	
	<h1>Comment Page</h1>
	<br>
	<br>
	<form onSubmit="return CheckPasswordEqual(this)" method="post" action="postcomment">
		
			<label for="URL"><prompts><b></label></b></prompts> <input type="hidden"
				id="URL" name="URL" value="${URL}"><br>
				
		
			<br> <label for="rating"><prompts><b>Rating:</label></b> <select id ="rating" name="rating">
			<option value ="poor">Poor</option>
			<option value ="fair">Fair</option>
			<option value ="good">Good</option>
			<option value ="excellent">Excellent</option>
		
			</select><br>
			

<br>
 <textarea name="Comments" placeholder = "Comments" style="font-size: 12pt; height: 100px; width:400px;" rows="5" required></textarea>
			<br> <input type="submit" id="submitbtn" value="Submit">
		
		<br>
	</form>
	
	<table>
		<c:forEach var="review" items="${listComments}">
	                <tr>
	                    <td><c:out value="${review.email}"/></td>
	                    <td><c:out value="${review.rating}"/></td>
	                    <td><c:out value="${review.comment}"/></td>
	                       
	                </tr>
	    </c:forEach>
	</table>
		
	
</body>
</html>