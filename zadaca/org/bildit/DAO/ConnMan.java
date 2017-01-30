
package org.bildit.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class ConnMan {
	private static final String NAME = "root";
	private static final String PASS = "pass1919";

	private static final String CONN = "jdbc:mysql://localhost?allowMultiQueries=true";
	
	private static ConnMan instance = null;
	private Connection conn = null;
	
	private ConnMan() {}
	public static ConnMan getInstance() {
		if (instance == null) {
			instance = new ConnMan();
		}
		return instance;
	}
	
	private boolean openConnection() {
		try {
			conn = DriverManager.getConnection(CONN, NAME, PASS);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	public Connection getConnection() {
		if (conn == null) {
			if (openConnection()) {
				System.out.println("Konekcija otvorena.");
				return conn;
			} else {
				return null;
			}
		}
		return conn;
	}

	public void close() {
		System.out.println("Konekcija zatvorena.");
		try {
			conn.close();
			conn = null;
		} catch (Exception e) {
		}
	}
	
}

