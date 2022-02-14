<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADDING NEW BOOK</title>
<link rel="stylesheet" href="css/formstyle.css">
</head>

<body>
	<I>You can Add new books here!</I>
	<!-- </center> -->
	<Br>
	<font color="5" color="red"> </font>
	<center>
		<a href="adminHome.jsp">Home</a>
		<form action="AddingBookServlet" method="post">
			<input type="text" name="bookname" placeholder="bookname"><br>
			<input type="text" name="authorname" placeholder="authorname"><br>
			<input type="text" name="category" placeholder="category"><br>
			<input type="text" name="YEAROFPUBLICATION"
				placeholder="year of publication"><br> <input
				type="text" name="bookisbn" placeholder="book establishers"><br>
			<input type="submit" name="submit" placeholder="submit"><br>
		</form>
	</center>

</body>
</html>