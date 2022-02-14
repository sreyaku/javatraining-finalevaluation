package com.librarymanagement.clientserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;

import com.librarymanagement.clientserver.dto.User;
import com.librarymanagement.clientserver.dto.Login;
import com.librarymanagement.clientserver.dao.MySqlConnectionUtil;
import com.librarymanagement.clientserver.dao.ConnectionUtil;
import com.librarymanagement.clientserver.dto.bookIssual;
import com.librarymanagement.clientserver.dto.Books;

@SuppressWarnings("unused")
public class LibraryManagementDBUtil {
	static int rowCount;
	// login details

	public static Login getUser(String userName, String password) throws SQLException {
		String sql = "Select username, password, displayname, usertype, person_person_id  from login_detail" //
				+ " where username = ? and password= ?";
		Connection con = null;
		try {
			con = MySqlConnectionUtil.getMySqlConnection();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, userName);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			Login loginUser;
			if (rs.next()) {
				String displayName = rs.getString("displayname");
				String userType = rs.getString("usertype");
				loginUser = new Login();
				loginUser.setUsername(userName);
				loginUser.setPassword(password);
				loginUser.setDisplayName(displayName);
				loginUser.setUserType(userType);
				return loginUser;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con);
		}
		return null;
	}

	// to add new books
	public static int addBook(Books books) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into books(bookname,authorname,category,YEAROFPUBLICATION) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, books.getBookname());
			ps.setString(2, books.getAuthorname());
			ps.setString(3, books.getCategory());
			ps.setString(4, books.getYEAROFPUBLICATION());
			rowCount = ps.executeUpdate();
			ConnectionUtil.close(con);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con);
		}
		return rowCount;
	}

//book search-using book name , category or both
	public static List<Books> getAllBooks(String book_name, String category) {
		List<Books> books = new ArrayList<Books>();
		try {
			Connection con = ConnectionUtil.getConnection();
			String query = "select * from books where bookname=? or category=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, book_name);
			ps.setString(2, category);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Books row = new Books();
				row.setBid(rs.getInt("bid"));
				row.setBookname(rs.getString("bookname"));
				row.setAuthorname(rs.getString("authorname"));
				row.setCategory(rs.getString("category"));
				row.setYEAROFPUBLICATION(rs.getString("YEAROFPUBLICATION"));
				books.add(row);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

//  obtaining the book details
	public static List<Books> showBook() {
		List<Books> books = new ArrayList<Books>();
		try {
			Connection con = ConnectionUtil.getConnection();
			String query = "select * from books ";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Books row = new Books();
				row.setBid(rs.getInt("bid"));
				row.setBookname(rs.getString("bookname"));
				row.setAuthorname(rs.getString("authorname"));
				row.setCategory(rs.getString("category"));
				row.setYEAROFPUBLICATION(rs.getString("YEAROFPUBLICATION"));
				books.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

//fetching user details
	public static List<User> showUser() {
		List<User> books = new ArrayList<User>();

		try {
			Connection con = ConnectionUtil.getConnection();
			String query = "select * from persons ";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User row = new User();
				row.setPersonId(rs.getInt("person_id"));
				row.setFirstName(rs.getString("firstname"));
				row.setLastName(rs.getString("lastname"));
				books.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

//ADMIN BOOKISSUAL
	public int bookIssual(bookIssual bookissual) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "insert into issued_books(UID,BID,ISSUEDDATE,RETURNDATE,BOOKSTATUS,PERIOD) values(?,?,?,?,'no','30')";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, bookissual.getUid());
			ps.setString(2, bookissual.getBid());
			ps.setString(3, bookissual.getIssueddate());
			ps.setString(4, bookissual.getReturndate());
			rowCount = ps.executeUpdate();
			ConnectionUtil.close(con);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.print(e);
		} finally {
			ConnectionUtil.close(con);
		}
		return rowCount;
	}

// bookissued by a reader
	public static List<com.librarymanagement.clientserver.dto.bookIssual> showIssuedBooksUser(int id) {
		List<com.librarymanagement.clientserver.dto.bookIssual> bookissual = new ArrayList<com.librarymanagement.clientserver.dto.bookIssual>();

		try {

			Connection con = ConnectionUtil.getConnection();
			String query = "select * from issued_books where uid=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				com.librarymanagement.clientserver.dto.bookIssual row = new com.librarymanagement.clientserver.dto.bookIssual();
				row.setIid(rs.getString("iid"));
				row.setUid(rs.getString("uid"));
				row.setIssueddate(rs.getString("issueddate"));
				row.setReturndate(rs.getString("returndate"));
				row.setIid(rs.getString("issueid"));
				row.setBookstatus(rs.getString("status"));
				row.setFine(rs.getInt("fine"));
				bookissual.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookissual;
	}

//return of issued books

	public static List<com.librarymanagement.clientserver.dto.bookIssual> showBookIssualAdmin() {
		List<com.librarymanagement.clientserver.dto.bookIssual> bookissual = new ArrayList<bookIssual>();
		try {
			Connection con = ConnectionUtil.getConnection();
			String query = "select * from issued_books";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bookIssual row = new bookIssual();
				row.setIid(rs.getString("iid"));
				row.setUid(rs.getString("uid"));
				row.setBid(rs.getString("bid"));
				row.setIssueddate(rs.getString("issueddate"));
				row.setFine(rs.getInt("fine"));
				row.setReturndate(rs.getString("returndate"));
				bookissual.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookissual;
	}

//admin book return

	public static int returnBook(bookIssual bookissual) {
		Connection con = null;
		try { 
			con = ConnectionUtil.getConnection();
			String sql = "update issued_books set bookstatus='yes',fine=?,returndate=?  where bid=? and uid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bookissual.getReturndate());
			ps.setString(2, bookissual.getBid());
			ps.setString(3, bookissual.getUid());
			rowCount = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con);
		}
		return rowCount;
	}

	public static int renewBook(com.librarymanagement.clientserver.dto.bookIssual bookissual) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "update issued_books set bookstatus='no',fine=?,returndate=?  where bid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bookissual.getReturndate());
			ps.setString(1, bookissual.getBid());
			rowCount = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(con);
		}
		return rowCount;
	}
}
