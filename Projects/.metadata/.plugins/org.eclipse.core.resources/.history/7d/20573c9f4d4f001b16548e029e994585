package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	private static Connection dbconn;
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String id = "team";
	private static final String pw = "team1";
	
	public static Connection getConnection()  {
		if(dbconn == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				dbconn = DriverManager.getConnection(url, id, pw);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			System.out.println(dbconn.isClosed() ? "접속종료" : "접속중");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbconn;
	}
	
	public static void dbClose() {
		if(dbconn != null) {
			try {
				if(!dbconn.isClosed()) {
					dbconn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dbconn = null;
	}
	public static void dbClose(ResultSet rs, PreparedStatement ps, Connection conn) {
		if(dbconn != null) {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dbconn = null;
		ps = null;
		rs = null;
	}
}
