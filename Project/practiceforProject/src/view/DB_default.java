package view;

import java.sql.DriverManager;
import java.sql.SQLException;

//연결 성공 완료 확인
public class DB_default {
	
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid="system";
		String passwd ="1234";
		
		try {

		     Class.forName(driver);
		     System.out.println("드라이브 연결 성공함");//2단계
		     DriverManager.getConnection(url, userid, passwd);
		     System.out.println("오라클 연결 성공함");//3단계

		    } catch (ClassNotFoundException e) {

		     System.out.println("드라이브 연결 실패함");
		     e.printStackTrace();
		    } catch (SQLException e) {

		     System.out.println("오라클 연결 실패함");

		     e.printStackTrace();

		    }//3단계

		   }
	
	
}
