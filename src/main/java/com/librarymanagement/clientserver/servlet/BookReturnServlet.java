package com.librarymanagement.clientserver.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarymanagement.clientserver.dao.LibraryManagementDBUtil;
import com.librarymanagement.clientserver.dto.bookIssual;

public class BookReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		final String uid = req.getParameter("uid");
		final String bid = req.getParameter("bid");
		bookIssual bookissual = new bookIssual();
		bookissual.setUid(uid);
		bookissual.setBid(bid);
		int rowCount = LibraryManagementDBUtil.returnBook(bookissual);
		if (rowCount > 0) {
			res.sendRedirect("adminHome.jsp");
		} else {
			res.sendRedirect("error.jsp");
		}

	}
}
