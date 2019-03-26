package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {
	public static Connection getConnnect() {
		Connection conn = null;
		try {
			// driverManager 이용하여 연결(자바 콘솔용)
			  String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe"; 
			  conn = DriverManager.getConnection(jdbc_url, "hr", "hr");
			// datasource를 이용하여 connection 획득(톰캣용)
			/*
			 * Context initContext = new InitialContext(); DataSource ds = (DataSource)
			 * initContext.lookup("java:/comp/env/jdbc/oracle"); conn = ds.getConnection();
			 * // conn 을 할당받음
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 자원해제(연결객체)
	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 자원해제
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				if (!rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (pstmt != null) {
			try {
				if (!pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
