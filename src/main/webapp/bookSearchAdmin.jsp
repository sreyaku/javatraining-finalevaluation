<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.librarymanagement.clientserver.dao.*"%>
<%@ page import="com.librarymanagement.clientserver.dto.*"%>
<%@ page import="com.librarymanagement.clientserver.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminBookSearch</title>
<link rel="stylesheet" href="css/formstyle.css">
</head>
<body>
	<center>
		<I>Have a happy reading</I>
		<h5>Search book</h5>
		<a href="adminHome.jsp">Home</a>
		</h5>
		<form action="BookSearchServlet">
			<input type="text" name="bookname" placeholder="bookname"> <input
				type="text" name="category" placeholder="category"> <input
				type="submit" name="submit" value="submit">
		</form>
	</center>
	<!-----current session--->
	<%
	List<Books> books = (List<Books>) request.getAttribute("books");
	%>
	<%
	if (session.getAttribute("name") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<%
	if (books != null) {
	%>
	<table>
		<tr>
			<th>Book Name</th>
			<th>Author Name</th>
			<th>Category</th>
			<th>Published year</th>
		</tr>
		<%
		for (Books b : books) {
		%>
		<tr>
			<td><%=b.getBook_name()%></td>
			<td><%=b.getAuthor_name()%></td>
			<td><%=b.getCategory()%></td>
			<td><%=b.getYEAR_OF_PUBLICATION()%></td>
			<%
			}
			}
			%>
		
</body>
</html>