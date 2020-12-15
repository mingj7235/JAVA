
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/MemberDB?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
//		String url = "jdbc:mysql://localhost:3306/MemberDB";
		String username = "root";
		String password = "0008";
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		try {
		Class.forName(DRIVER).newInstance(); //드라이버 로딩
		conn = DriverManager.getConnection(url,username,password);
		
		System.out.println("연결 성공 !!");
	} catch (Exception e) {
		System.out.println("연결 실패  ");
	} finally {
		try {
			if ( conn!=null ) {
				conn.close();
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
		

	}

}