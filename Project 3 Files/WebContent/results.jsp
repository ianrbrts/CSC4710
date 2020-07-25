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
	#submitbtnfavandcom {
	display: inline-block;
	 width: 85px;
	height: auto;
	font-size: 15px;
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
<meta "charset=UTF-8">
        <title>Search Results</title>
    </head>
    <body>
    
    
                  
                  
     <div align="center">
        <table border="1" cellpadding="5">
            <caption><h1>List of Videos</h1></caption>
            <tr>
                
                <th>URL</th>
                <th>Title</th>
                <th>Comedian</th>
                <th>Favorite</th>
                <th>Comment</th>
            </tr>
            <c:forEach var="video" items="${listResults}">
                <tr>
                    <td><a href="<c:out value="${video.URL}" default="n/a" />">YouTube Link</td>
                    <td><c:out value="${video.title}" /></td>
                    <td><c:out value="${video.comedian}" /></td>
                    
                    <td>
	                    <form action="favorite" method="post">
	                    	<input type="hidden" name="URL" value="${video.URL}" >
	                    	<input type="hidden" name="comedian" value="${video.comedian}">
	                    	<input type="submit" id="submitbtnfavandcom" value="Favorite">
	                 	</form>  
                    </td>
                    
                    <td>
	                    <form action="comment" method="post">
	                    	<input type="hidden" name="URL" value="${video.URL}" >
	                    	<input type="hidden"  name="comedian" value="${video.comedian}">
	                    	<input type="submit" id="submitbtnfavandcom" value="Comment">
	                    </form>
                   </td>
                   
                   
                </tr>
            </c:forEach>
        </table>
        <br>
        <br>
       <button id="submitbtnback" onclick="goBack()">Go Back</button>
    </div>
     
	</body>
</html>
