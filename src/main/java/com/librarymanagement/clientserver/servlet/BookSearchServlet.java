package com.librarymanagement.clientserver.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.librarymanagement.clientserver.dao.LibraryManagementDBUtil;
import com.librarymanagement.clientserver.dto.Books;

public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		@SuppressWarnings("unused")
		HttpSession session = req.getSession();
		final String name = req.getParameter("bookname");
		final String category = req.getParameter("category");
		List<Books> books = new ArrayList<Books>();
		Books book = new Books();
		book.setBookname(name);
		book.setCategory(category);
		books = LibraryManagementDBUtil.getAllBooks(name, category);
		if (books != null) {
			req.setAttribute("books", books);
			RequestDispatcher rd = req.getRequestDispatcher("bookSearchAdmin.jsp");
			rd.forward(req, res);
		} else {
			res.sendRedirect("adminHome.jsp");
		}

	}

}
