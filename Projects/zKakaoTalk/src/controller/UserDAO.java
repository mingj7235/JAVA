package controller;

import java.sql.*;

import db.DBConn;
import exception.MyException;
import model.UserDTO;

public class UserDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 회원가입
	public int signUp(UserDTO dto) throws MyException {
		int result = 0;
		conn = DBConn.getConnection();
//		String sql = "INSERT INTO kakaoUser"
//				+ "VALUES (user_seq.nextval, ?, ?, ?)";
		String sql = "INSERT INTO kakaoUser values (user_seq.nextval, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getPhonenum());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPassword());

			result = pstmt.executeUpdate();
			System.out.println(result + "명 회원가입 완료");
		} catch (SQLIntegrityConstraintViolationException e1) {
			throw new MyException("이미 있는 번호입니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.dbClose(rs, pstmt, conn);
		}

		return result;
	} // signUp()

	// 로그인
	public boolean login(String phonenum, String pw) throws MyException {
		boolean result = false;
		conn = DBConn.getConnection();
		String sql = "SELECT * FROM kakaoUser WHERE phonenum = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phonenum);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				if(pw.equals(rs.getString("password"))) {
					result = true;
					UserDTO.nowUser.setUser_num(rs.getInt("user_num"));
					UserDTO.nowUser.setPhonenum(rs.getString("phonenum"));
					UserDTO.nowUser.setName(rs.getString("name"));
					UserDTO.nowUser.setPassword(rs.getString("password"));

					// 친구 목록
					sql = "SELECT * FROM kakaoUser WHERE phonenum != ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, phonenum);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						UserDTO dto = new UserDTO();
						dto.setName(rs.getString("name"));
						dto.setPassword(rs.getString("password"));
						dto.setPhonenum(rs.getString("phonenum"));
						dto.setUser_num(rs.getInt("user_num"));
						UserDTO.friends.add(dto);
					}
					System.out.println("친구목록추가 완료");


				} else {
					throw new MyException("비밀번호가 틀렸습니다.");
				}
			} else {
				throw new MyException("존재하지 않는 번호입니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConn.dbClose(rs, pstmt, conn);
		}
		return result;
	}





} // UserDAO
