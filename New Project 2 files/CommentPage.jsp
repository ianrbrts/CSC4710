
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
	<form onSubmit="return CheckPasswordEqual(this)" method="post" action="comment">
		
			<label for="URL"><prompts><b>Video URL:</label></b></prompts> <input type="text"
				id="URL" name="URL"><br>
				
		
			<br> <label for="reviewer"><prompts><b>Reviewer:</label></b></prompts> <input type="text"
				id="reviewer" name="reviewer"><br>

<br>
	<br> <label for="rating"><prompts><b>Rating:</label></b> <select id ="rating" name="rating">
			<option value ="poor">Poor</option>
			<option value ="fair">Fair</option>
			<option value ="good">Good</option>
			<option value ="excellent">Excellent</option>
		
			</select><br>
			
 <textarea name="Comments" placeholder = "Comments" style="font-size: 12pt; height: 100px; width:400px;" rows="5" required></textarea>
			<br> <input type="submit" id="submitbtn" value="Submit">
		
		<br>
	</form>
	
</body>
</html>