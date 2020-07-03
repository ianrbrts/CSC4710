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
        <title>Insert Video</title>
    </head>
    <body>
        <form onSubmit="return alertOnSubmit(this)" action='insert' method="POST">
            <h1>Insert a video</h1>
            <br>
            <br>
		<label><prompts>URL:</prompts></label>
            <input type="url" name="url"><br><br>

		<label><prompts>Title:</prompts></label> 
            <input type="text" name="title"><br><br>

		<label><prompts>Description:</prompts></label> 
            <input type="text" name="description"><br><br>

		<label><prompts>Tags:</prompts></label> 
            <input type="text" name="tags"><br><br>

            <input type="submit" id="submitbtn" value="Insert">
        </form>
        
        <br>
        
        <a href="loggedin.jsp">Back to home</a>
        
        
        
        
        
      </body>
</html>
