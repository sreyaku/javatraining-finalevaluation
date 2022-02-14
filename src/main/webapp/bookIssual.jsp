
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BOOK ISSUAL</title>
<link rel="stylesheet" href="css/formstyle.css">
</head>
<body>
	<center>
		<h3>
			Book Issual Form<a href="adminHome.jsp">Home</a>
		</h3>
		<br>
		<br>
		<form action="BookIssualServlet" method="post">
			<label>Issue Date:</label> <input type="date" name="issue_date">
			<label>Return Date:</label> <input type="date" name="return_date"><br>
			<input type="text" name="uid" placeholder="user id"><br>
			<input type="text" name="bid" placeholder="book id"><br>
			<input type="submit" name="submit" value="Issue Book">
		</form>
	</center>

</body>
</html>