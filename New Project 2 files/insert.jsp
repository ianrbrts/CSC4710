<!DOCTYPE html>
<html lang="en">

<script>
		function alertOnSubmit(form){
			alert("Video submitted successfully!"); 
			
			var form = document.getElementById("input");
			form.reset();
		}
	</script>
	
    <head>
        <title>Insert Video</title>
    </head>
    <body>
        <form onSubmit="return alertOnSubmit(this)" action='insert' method="POST">
            <h1>Insert a video</h1>
            <br>
            <br>
            <label>URL:</label>
            <input type="url" name="url"><br><br>

            <label>Title:</label> 
            <input type="text" name="title"><br><br>

            <label>Description:</label> 
            <input type="text" name="description"><br><br>

            <label>Tags:</label> 
            <input type="text" name="tags"><br><br>

            <input type="submit" value="Insert">
        </form>
        
        <br>
        
        <a href="loggedin.jsp">Back to home</a>
        
        
        
        
        
      </body>