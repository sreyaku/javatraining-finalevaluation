<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BOOKRENEWAL</title>
<link rel="stylesheet" href="css/formstyle.css">
</head>
<body>
	<a href="userHome.jsp">Home</a>
	<center>
		<form action="BookRenewalServlet">
			<input type="text" name="uid" placeholder="user id"><br>
			<input type="text" name="bid" placeholder="book id"><br>
			<input type="text" name="issuedate" placeholder="issuedate"><br>
			<input type="text" name="returndate" placeholder="returndate"><br>
			<input type="submit" name="submit" placeholder="submit"><br>
		</form>

	</center>
</body>
</html>