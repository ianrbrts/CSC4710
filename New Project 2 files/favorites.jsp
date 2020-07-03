<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
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
        <title>Your Favorites</title>
    </head>
    <body>
    	   	
    	<table border="1" cellpadding="5">
            <caption><h1>Your saved Favorites</h1></caption>
            <tr>
                
                <th>URL</th>
                <th>Title</th>
                
                
            </tr>
            <c:forEach var="video" items="${listResults}">
                <tr>
                    <td><a href="<c:out value="${video.URL}" default="n/a" />">YouTube Link</td>
                    <td><c:out value="${video.title}" /></td>
                    
                    
                    <td>
	                    <form action="delete" method="post">
	                    	<input type="hidden" name="URL" value="${video.URL}" >
	                    	<input type="submit" value="delete">
	                 	</form>  
                    </td>
                    
                    
                    
                   
                </tr>
            </c:forEach>
        </table>
    	
    	<br>
        <br>
        <a href="loggedin.jsp">Back to Home</a>
    	
    	
    </body>
</html>
