package db_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.UsertDTO;

public class KakaoDAO {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	public boolean signCheck(String phoneNum) { //중복회원 전화번호로 확인
		boolean exist = false;
		try {
			conn = DBConn.getConnection();
			String sql = "SELECT * FROM usert WHERE phonenum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phoneNum);
			rs = pstmt.executeQuery();
			exist = rs.next(); //존재하면 true 존재하지 않으면 false
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.dbClose(rs, pstmt, conn);
		}
		return exist;

	}
	public void signIn(String phoneNum, String name, String password) { //회원가입
		try {
			conn = DBConn.getConnection();
			String sql = "INSERT INTO usert values (user_seq.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phoneNum);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			int num = pstmt.executeUpdate();
			System.out.println(num);
			System.out.println("insert완료");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConn.dbClose(rs, pstmt, conn);
		}
	}
	public int login(String phoneNum, String password) { //전화번호와 비밀번호가 일치하는지 확인
		//해당 전화번호가 없으면 -1, 일치하지 않다면 -2, 일치하면 회원고유번호 리턴
		boolean match = false;
		String getPhoneNum;
		String getPassword;
		int getUserNum;
		int result = -1;
		try {
			conn = DBConn.getConnection();
			String sql = "SELECT * FROM usert WHERE phonenum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phoneNum);
			rs = pstmt.executeQuery();
			if(match = rs.next()){ //해당번호정보가 있다면, 애초에 중복번호 가입을 막았기 때문에 while문 안씀
				// DB에 존재하는 정보 가져오기
				getPhoneNum = rs.getString("phonenum"); //전화번호 
				getPassword = rs.getString("password"); //비밀번호
				getUserNum = rs.getInt("user_num"); //고객번호
				if(getPassword.equals(password)) { //비밀번호가 일치할 때
					result = getUserNum; //리턴값을 userNum으로
					UsertDTO.nowUser.setUser_num(rs.getInt("user_num"));
					UsertDTO.nowUser.setPhonenum(rs.getString("phonenum"));
					UsertDTO.nowUser.setName(rs.getString("name"));
					UsertDTO.nowUser.setPassword(rs.getString("password"));
				}else { //비밀번호가 일치하지 않을 때
					result = -2; //비밀번호가 일치하지 않을 때
				}
			}else {
				result = -1; //DB에 해당 전화번호가 없을 때
			}
			if(result > 0) {
				//이외의 사용자들 arraylist에 담기
				sql = "SELECT * FROM usert WHERE phonenum != ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, phoneNum);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					UsertDTO dto = new UsertDTO();
					dto.setName(rs.getString("name"));
					dto.setPassword(rs.getString("password"));
					dto.setPhonenum(rs.getString("phonenum"));
					dto.setUser_num(rs.getInt("user_num"));
					UsertDTO.friends.add(dto);
				}
				System.out.println("친구목록추가 완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.dbClose(rs, pstmt, conn);
		}
		return result;
	}
}
