package com.librarymanagement.clientserver.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.librarymanagement.clientserver.dao.LibraryManagementDBUtil;
import com.librarymanagement.clientserver.dao.MySqlConnectionUtil;
import com.librarymanagement.clientserver.dto.Login;
import com.librarymanagement.clientserver.utils.Constants;


@SuppressWarnings("unused")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		HttpSession session = request.getSession();

		Login login = null;
		try {

			login = LibraryManagementDBUtil.getUser(username, password);
		} catch (SQLException e) {
			e.printStackTrace();

		}
		if (login == null) {
			response.sendRedirect("loginerror.jsp");

		}
		// logging in as admin
		else if (Constants.USER_TYPE_ADMIN.equals(login.getUserType())) {
			session.setAttribute("name", login.getUsername());
			response.sendRedirect("adminHome.jsp");

		}
		// as reader

		else if (Constants.USER_TYPE_READER.equals(login.getUserType())) {
			//request.setAttribute("id", login.getUser().getPersonId());
			request.setAttribute("name", login.getUsername());

			response.sendRedirect("userHome.jsp");
		}

		response.getWriter().close();
	}

}