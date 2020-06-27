<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
    <head>
        <title>Your Favorites</title>
    </head>
    <body>
    	   	
    	<table border="1" cellpadding="5">
            <caption><h2>Your saved Favorites</h2></caption>
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