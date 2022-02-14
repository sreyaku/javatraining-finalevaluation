package com.librarymanagement.clientserver.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.librarymanagement.clientserver.dao.LibraryManagementDBUtil;
import com.librarymanagement.clientserver.dto.bookIssual;

@SuppressWarnings("unused")

public class BookRenewalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String issueid=request.getParameter("iid");
		
		bookIssual bookissual=new bookIssual();
		bookissual.setIid(issueid);
		
		int rowCount=LibraryManagementDBUtil.renewBook(bookissual);
		
		if(rowCount>0) {
			response.sendRedirect("renewBook.jsp");
		}
		else {
			response.sendRedirect("error.jsp");;
		}

	

}
}
