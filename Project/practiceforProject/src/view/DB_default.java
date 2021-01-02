package view;

import java.sql.DriverManager;
import java.sql.SQLException;

//연결 성공 완료 확인
public class DB_default {
	
	public DB_default() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid="system";
		String passwd ="1234";
		
		try {
			Class.forName(driver);
			DriverManager.getConnection(url, userid, passwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
