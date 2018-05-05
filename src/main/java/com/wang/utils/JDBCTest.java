package com.wang.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest {

	private Connection connection;

	public void getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wang", "root", "12345");
			connection.setAutoCommit(false);
		}
	}

	public int doUpdate() throws SQLException {
		if (connection == null) {
			this.getConnection();
		}
		PreparedStatement ps = connection
				.prepareStatement("insert into userinfo(password,username)values('20180503','10:08')");
		PreparedStatement ps1 = connection
				.prepareStatement("insert into userinfo(password,username1)values('20180503','10:14')");
		// ps.setBigDecimal(parameterIndex, x);
		ps.execute();
		ps1.execute();
		connection.commit();
		connection.close();
		return 0;
	}

	public int close() throws SQLException {
		if (connection == null) {
			connection.close();
		}
		return 0;
	}

	public static void main(String[] args) {
		try {
			new JDBCTest().doUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
