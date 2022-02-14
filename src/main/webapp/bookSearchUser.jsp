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
<title>Hi User,You can search books here!</title>
<link rel="stylesheet" href="css/formstyle.css">
</head>
<body>
	<center>
		<I>Hey User,Have a happy reading</I> <a href="userHome.jsp">Home</a>
		<form action="BookSearchServlet">
			<input type="text" name="bookname" placeholder="book name"><br>
			<input type="text" name="category" placeholder="category"><br>
			<input type="submit" name="submit" placeholder="submit"><br>
		</form>
	</center>
	<%
	List<Books> books = (List<Books>) request.getAttribute("books");
	%>
	<%
	if (session.getAttribute("bookname") == null) {
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
			<th>Year of publication</th>
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

</body>
</html>