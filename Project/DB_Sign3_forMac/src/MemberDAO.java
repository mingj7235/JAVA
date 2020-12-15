

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MemberDAO {
	Connection conn = null;
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/MemberDB?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
	String USER = "root"; // DB ID
	String PASS = "0008"; // DB pwd

	Member_Main mMain;

	public MemberDAO() {	}
	public MemberDAO(Member_Main mMain) {
		this.mMain=mMain;
		System.out.println("DAO =>"+mMain);
	}
	/* DB연결 메소드 */
	public Connection getConn() {
		Connection con = null;

		try {
			Class.forName(DRIVER).newInstance(); //드라이버 로딩
			con = DriverManager.getConnection(URL, USER, PASS);// 드라이버 연결!
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	// -----------------------------------------
	/*			 Inbody			*/
	// 신체 정보를 불러올 함수
		public MemberDTO getInbodyDTO(String id) {
			MemberDTO dto = new MemberDTO();

			Connection con = null; // 연결
			PreparedStatement ps = null; // 명령
			ResultSet rs = null; 	// 결과

			try {
				con = getConn();
				String sql = "select * from MenuDAO where id = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();

				if(rs.next()) {
					dto.setId(rs.getString("id"));
					dto.setPwd(rs.getString("pwd"));
					dto.setHeight(rs.getString("height"));
					dto.setWeight(rs.getString("weight"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dto;
		}
		// 신체 정보 저장 함수
		public boolean insertInbody(MemberDTO dto) {
			boolean ok = false;

			Connection con = null; // 배열
			PreparedStatement ps = null; //명령
			try {
				con = getConn();
				String sql = "insert into MenuDAO(id,pwd,name,height,weight) values(?,?,?,?,?)";

				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getId());
				ps.setString(2, dto.getPwd());
				ps.setString(3, dto.getName());
				ps.setString(4, dto.getHeight());
				ps.setString(5, dto.getWeight());
				int r = ps.executeUpdate(); // 실행한걸 저장!
				if ( r > 0 ) {
					System.out.println("신체 기록 저장 성공");
					ok = true;
				} else {
					System.out.println("신체 기록 저장 실패");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return ok;
		}
		// 출력
		public Vector getInbodyMain() {
			Vector data = new Vector(); // table
			Connection con = null; // 연결
			PreparedStatement ps = null; // 명령
			ResultSet rs = null; // 결 과
			try {
				con = getConn();
				String sql = "select * from MenuDAO order by name asc ";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					String id = rs.getString("id");
					String pwd = rs.getString("pwd");
					String name = rs.getString("name");
					String height = rs.getString("height");
					String weight = rs.getString("weight");

					Vector row = new Vector();
					row.add(id);
					row.add(pwd);
					row.add(name);
					row.add(height);
					row.add(weight);

					data.add(row);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return data;
		}
	//  회원 신체기록 삭제
		public boolean deleteInbody(String id,String pwd) {
			boolean ok = false;
			Connection con = null;
			PreparedStatement ps = null;

			try {
				con = getConn();
				String sql = "delete from MenuDAO where id = ? and pwd = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, pwd);
				int r = ps.executeUpdate();

				if ( r > 0 ) ok = true;

			}catch (Exception e) {
				System.out.println(e + "-> 오류 발생 ");
			}
			return ok;
		}
		// Inbody 수정
		public boolean updateInbody(MemberDTO vMem) {
			System.out.println("dto="+vMem.toString());
			boolean ok = false;
			Connection con = null;
			PreparedStatement ps = null;
			try {

				con = getConn();
				String sql = "update MenuDAO set name=?, height=?, weight=? "+"where id=? and pwd=?";

				ps = con.prepareStatement(sql);
				ps.setString(1, vMem.getName());
				ps.setString(2, vMem.getHeight());
				ps.setString(3, vMem.getWeight());
				ps.setString(10, vMem.getId());
				ps.setString(11, vMem.getPwd());

				int r = ps.executeUpdate(); // 실행후 수정

				if(r>0) ok = true; // 수정이 성공되면 ok 값을 true

			}catch (Exception e) {
				e.printStackTrace();
			}
			return ok;
		}

		// DB데이터 불러오기
		public void inbodySelectAll(DefaultTableModel model) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				con = getConn();
				String sql = "select * from MenuDAO order by name asc"; // order by 이름 오름차순
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
			// tableModel에 있는 데이터 지우기
			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}
			while(rs.next()) {
				Object data[] = {rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),};
					model.addRow(data);
				}
			}catch (SQLException e) {
				System.out.println(e +"=> 실패");
			} finally {
				if (rs != null )
					try {
						rs.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				if (ps != null )
					try {
						ps.close();
					}catch (SQLException e1) {
						e1.printStackTrace();
					}
				if (con != null )
					try {
						con.close();
					}catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}


/*				Inbody end						*/
		// ------------------------------
	// 회원 정보를 불러올 메소드
	public MemberDTO getMemberDTO(String id) {
		MemberDTO dto = new MemberDTO();

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; 	// 결과

		try {
			con = getConn();
			String sql = "select * from MemberDAO where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setAddr(rs.getString("Addr"));
				dto.setBirth(rs.getString("Birth"));
				dto.setJob(rs.getString("Job"));
				dto.setGender(rs.getString("Gender"));
				dto.setEmail(rs.getString("Email"));
				dto.setDate(rs.getString("Date"));
				dto.setDateCheck(rs.getString("DateCheck"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	// 출력
	public Vector getMember_Main() {
		Vector data = new Vector(); // table
		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결 과
		try {
			con = getConn();
			String sql = "select * from MemberDAO order by name asc ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				String birth = rs.getString("birth");
				String job = rs.getString("job");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String date = rs.getString("date");
				String dateCheck = rs.getString("dateCheck");

				Vector row = new Vector();
				row.add(id);
				row.add(pwd);
				row.add(name);
				row.add(tel);
				row.add(addr);
				row.add(birth);
				row.add(job);
				row.add(gender);
				row.add(email);
				row.add(date);
				row.add(dateCheck);

				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	// 회원가입
	public boolean insertMember(MemberDTO dto) {
		boolean ok = false;

		Connection con = null; // 배열
		PreparedStatement ps = null; //명령
		try {
			con = getConn();
			String sql = "insert into MemberDAO(id,pwd,name,tel,addr,birth,job,gender,email,date,dateCheck) values(?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getTel());
			ps.setString(5, dto.getAddr());
			ps.setString(6, dto.getBirth());
			ps.setString(7, dto.getJob());
			ps.setString(8, dto.getGender());
			ps.setString(9, dto.getEmail());
			ps.setString(10, dto.getDate());
			ps.setString(11, dto.getDateCheck());
			int r = ps.executeUpdate(); // 실행한걸 저장!
			if ( r > 0 ) {
				System.out.println("성공");
				ok = true;
			} else {
				System.out.println("가입 실패");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
	// 회원정보 삭제

	//  회원정보 삭제는,,database에서 Delete까지
	public boolean deleteMember(String id,String pwd) {
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConn();
			String sql = "delete from MemberDAO where id = ? and pwd = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			int r = ps.executeUpdate();

			if ( r > 0 ) ok = true;

		}catch (Exception e) {
			System.out.println(e + "-> 오류 발생 ");
		}
		return ok;
	}
	public boolean updateMember(MemberDTO vMem) {
		System.out.println("dto="+vMem.toString());
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {

			con = getConn();
			String sql = "update MemberDAO set name=?, tel=?, addr=?, birth=?, job=?, gender=?"+
			", email=?, date=?, dateCheck=?"+"where id=? and pwd=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, vMem.getName());
			ps.setString(2, vMem.getTel());
			ps.setString(3, vMem.getAddr());
			ps.setString(4, vMem.getBirth());
			ps.setString(5, vMem.getJob());
			ps.setString(6, vMem.getGender());
			ps.setString(7, vMem.getEmail());
			ps.setString(8, vMem.getDate());
			ps.setString(9, vMem.getDateCheck());
			ps.setString(10, vMem.getId());
			ps.setString(11, vMem.getPwd());

			int r = ps.executeUpdate(); // 실행후 수정

			if(r>0) ok = true; // 수정이 성공되면 ok 값을 true

		}catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}

	public void userSelectAll(DefaultTableModel model) { // DB데이터 불러오기
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConn();
			String sql = "select * from MemberDAO order by name asc"; // order by 이름 오름차순
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		// tableModel에 있는 데이터 지우기
		for (int i = 0; i < model.getRowCount();) {
			model.removeRow(0);
		}
		while(rs.next()) {
			Object data[] = {rs.getString(1),rs.getString(2),
					rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),
					rs.getString(7),rs.getString(8),
					rs.getString(9),rs.getString(10),
					rs.getString(11) };
				model.addRow(data);
			}
		}catch (SQLException e) {
			System.out.println(e +"=> 실패");
		} finally {
			if (rs != null )
				try {
					rs.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			if (ps != null )
				try {
					ps.close();
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
			if (con != null )
				try {
					con.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
