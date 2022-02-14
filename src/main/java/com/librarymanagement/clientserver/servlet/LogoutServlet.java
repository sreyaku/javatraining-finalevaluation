package com.librarymanagement.clientserver.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try (PrintWriter out = res.getWriter()) {
			if (req.getSession().getAttribute("name") != null) {
				req.getSession().removeAttribute("name");
				res.sendRedirect(getServletInfo());
			}

		}
	}

}
