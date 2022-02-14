<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserBookSearch</title>
<link rel="stylesheet" href="css/formstyle.css">
</head>
<body>
<body>
	<I>Come lets search and find books here!</I>
	</center>
	<Br>
	<font color="5" color="red"> </font>
	<a href="userHome.jsp">Home</a>
	<form action="BookSearchServlet">
		<input type="text" name="bookname" placeholder="book name"><br>
		<input type="text" name="category" placeholder="category"><br>
		<input type="submit" name="submit" placeholder="submit"><br>
	</form>
	</center>
</body>
</html>