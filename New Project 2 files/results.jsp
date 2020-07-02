<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
    <head>
        <title>Search Results</title>
    </head>
    <body>
    
    
                  
                  
     <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of People</h2></caption>
            <tr>
                
                <th>URL</th>
                <th>Title</th>
                <th>Description</th>
                <th>Tags</th>
            </tr>
            <c:forEach var="video" items="${listResults}">
                <tr>
                    <td><a href="<c:out value="${video.URL}" default="n/a" />">YouTube Link</td>
                    <td><c:out value="${video.title}" /></td>
                    
                    <td>
	                    <form action="favorite" method="post">
	                    	<input type="hidden" name="URL" value="${video.URL}" >
	                    	<input type="submit" value="Favorite">
	                 	</form>  
                    </td>
                    
                    
                    <form action="comment" method="post">
                    	<td><input type="hidden" name="URL" value="${video.URL}" >
                    	<td><input type="submit" value="Comment"></td>
                    </form>
                   
                </tr>
            </c:forEach>
        </table>
        <br>
        <br>
        <a href="loggedin.jsp">Back to Home</a>
    </div>
     
     
     
     
     
      