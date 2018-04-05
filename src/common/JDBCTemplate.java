package common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	public JDBCTemplate() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnect() {
		Connection conn = null;
		Properties prop = new Properties();
		{
			try {
				prop.load(new BufferedReader(new FileReader("resource/driver.properties")));
				Class.forName(prop.getProperty("driver"));
				conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
						prop.getProperty("pw"));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static void close(Connection conn) {
		try {
			if(conn!=null&&! conn.isClosed()){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt!=null&&! stmt.isClosed()){
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs,Statement stmt) {
		try {
			if(rs!=null&&! rs.isClosed()){
				rs.close();
			}
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
