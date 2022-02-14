<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to HomePage</title>
</head>
<body>
	<I>Welcome to HomePage</I>
	</center>
	<Br>
	<font color="5" color="blue"> </font>
	<%
	if (session.getAttribute("name") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<!-- ---top navigation -->
	<div class="sidenav">
		<a href="#">Home</a> <a href="userSearchBook.jsp">Book search></a> <a
			href="renewBook.jsp">Book Renew></a>
	</div>
</body>
</html>