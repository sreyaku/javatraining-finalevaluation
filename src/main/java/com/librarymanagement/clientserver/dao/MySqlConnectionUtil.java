
package com.librarymanagement.clientserver.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.librarymanagement.clientserver.servlet.LoginServlet;

@SuppressWarnings("unused")
public class MySqlConnectionUtil {

	@SuppressWarnings("deprecation")
	public static Connection getMySqlConnection() throws ClassNotFoundException, SQLException {

		String hostName = "localhost";
		String dbName = "e-library";
		String userName = "root";
		String password = "root1234@";
		/* DriverManager.registerDriver(new com.mysql.jdbc.Driver()); */
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

		Connection con = DriverManager.getConnection(connectionURL, userName, password);
		return con;
	}

}