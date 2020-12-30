package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//데이터 베이스 연결하는 클래스
public class MemberDAO {
	//1. 오라클 데이터베이스 연동을 위한 4가지 정보를 문자열에 저장
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String userid="system";
	String passwd= "1234";
	
	public MemberDAO() {
		try {
			//2.드라이버 로딩 OracleDriver 클래스를 자바에서 이용하기위해 JVM에 올려줌
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//end 생성자
	
	//회원 정보 생성 insert() - 데이터 베이스 안으로 새로운 자료 넣기
	public void insert(String name, String age, String height, String weight, String sex) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			//query문 작성
			String sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			//? 안에 실제 데이터 넣기
			pstmt.setString(1, name); //1번 물음표에 name(insert()의 매개변수)을 넣어주셈 이라는 의미임
			pstmt.setInt(2, Integer.parseInt(age)); //데이터베이스에 넣을때는 int타입으로 넣어야하므로 ! 
			pstmt.setInt(3, Integer.parseInt(height));
			pstmt.setInt(4, Integer.parseInt(weight));
			pstmt.setString(5, sex);
			
			int n = pstmt.executeUpdate(); //n행이 들어갔습니다. 라는 것임
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if( pstmt!=null  )
				try {
					pstmt.close ();
					if (con!= null) con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	
	}
	
		
	
	//회원 정보 보기 (select)
	public ArrayList<MemberDTO> select () {
		ArrayList list = new ArrayList<MemberDTO>();
		Connection con = null;
		PreparedStatement pstmt = null; //쿼리문에서 insert into member values (? ,? ,? ,?, ?); 와 같이 물음표인경우 사용
		ResultSet rs = null; //조회된 결과를 가져오는 것임
		
		//3.Connection 맺기
		try {
			con = DriverManager.getConnection(url, userid, passwd);
			//4. sql문 작성.sql문을 쓸 수 있음 
			String query = "SELECT * FROM member";
			//5. preparedStatement 생성. 요청할 sql문을 담는 것임 statement생성
			pstmt = con.prepareStatement(query);
			
			//6.sql문 실행 ->ResultSet으로 담기. 결과물이 담김 sql문을 전송하고 실행하는 클래스임.
				//즉, 전송 한 후 DB에서 sql문이 실행되고 그 결과를 rs에 담아줌
			rs = pstmt.executeQuery();
			
			while (rs.next() ) {
				MemberDTO dto = new MemberDTO ();
													
				dto.setName(rs.getString(1));
												//DB의 컬럼 인덱스를 넣는거나 컬럼레이블(테이블 column의 이름을써줘도됨) 지금은 column label을 씀
				dto.setAge(rs.getInt(2));
				dto.setWeight(rs.getInt(3));
				dto.setHeight(rs.getInt(4));
				dto.setSex(rs.getString(5).charAt(0));
				list.add(dto); //컬렉션의 리스트에다 데이터베이스의 레코드를 가져와서 모두 넣어줌
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//7. 자원 반납
			try {
				if(rs != null) rs.close();
				if( pstmt != null) pstmt.close();
				if( con != null) con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}//end select
	
	
	
	
	
}
