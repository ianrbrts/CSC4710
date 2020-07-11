<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Insert Video</title>
    </head>
    <body>
        <form action='insert' method="POST">
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