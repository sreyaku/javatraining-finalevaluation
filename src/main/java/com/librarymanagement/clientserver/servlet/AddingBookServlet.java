package com.librarymanagement.clientserver.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarymanagement.clientserver.dao.LibraryManagementDBUtil;
import com.librarymanagement.clientserver.dto.Books;


public class AddingBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		final String bookName = req.getParameter("bookname");
		final String author = req.getParameter("authorname");
		final String category = req.getParameter("category");
		final String YEAROFPUBLICATION = req.getParameter("YEAROFPUBLICATION");

		Books books = new Books();
		books.setBookname(bookName);
		books.setAuthorname(author);
		books.setCategory(category);
		books.setYEAROFPUBLICATION(YEAROFPUBLICATION);

		int rowCount = LibraryManagementDBUtil.addBook(books);
		if (rowCount > 0) {
			res.sendRedirect("adminHome.jsp");
		} else {
			res.sendRedirect("error.jsp");
		}

	}
}
