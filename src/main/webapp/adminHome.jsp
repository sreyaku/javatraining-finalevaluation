
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to AdminPage</title>
</head>
<body>
	<font size="30" color="blue"> <I>Welcome to AdminPage</I>

		
	</font>
	<%
	if (session.getAttribute("name") == null) {
		response.sendRedirect("login.jsp");
	}
	%>



	<div class="topnav">
		<a href="#">Home</a> <a href="addBook.jsp">Add Book></a> <a
			href="bookSearchAdmin.jsp">Book search></a> <a href="bookIssual.jsp">Book
			Issue></a> <a href="returnBook.jsp">Book Return></a>



	</div>




</body>
</html>