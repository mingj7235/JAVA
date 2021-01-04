package Application.MemberDao;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Application.model.ChattingRoom;
import Application.model.Customer;
import Application.model.MessageFormat;



public class MemberDao {
	public MemberDao() {
		// TODO Auto-generated constructor stub
	}

	private static MemberDao instance = new MemberDao();


	public static MemberDao getInstance() {
		return instance;
	}


	// 컨넥션 풀 사용 안함.
	public Connection getConnection() throws Exception{

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "system";
		String pass = "1234";

		Connection conn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url,uid,pass);

		return conn;
	}

	public int userCheck(String userid, String pwd){
		int result = -1;
		String sql = "select pw from customer where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pw") != null && rs.getString("pw").equals(pwd)){
					result = 1;
				}else{
					result = 0;
				}
			}else {
				result = -1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

	//	create table member (
	//			  2    2  id varchar2(20),
	//			  3    3  pw varchar2(20),
	//			  4    4  name varchar2(10),
	//			  5    5  Image varchar2(40),
	//			  6    6  phoneNumber char(13),
	//			  7    7  talkName varchar2(20),
	//			  8    8  primary key(id)
	//			  9    8  primary key(id)
	//			 10  ;

	// 아이디로 회원 정보 가져오는 메서드
	public Customer getMember(String name, String hp){
		Customer cus = null;
		String sql ="select * from customer where name=? and hp=?";
		//		select * from customer where name='박덕환' and hp=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, hp);

			rs = pstmt.executeQuery();
			if(rs.next()){
				cus = new Customer();
				cus.setId(rs.getString("id"));
				cus.setPw(rs.getString("pw"));
				cus.setImage(rs.getString("img"));
				cus.setPhoneNumber(rs.getString("hp"));
				cus.setTalkName(rs.getString("talk"));
				cus.setName(rs.getString("name"));
			}else{
				return new Customer("#", "#");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		}

		return cus;
	}

	public Customer getMember(String userid){
		Customer cus = null;
		String sql ="select * from customer where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				cus = new Customer();
				cus.setId(rs.getString("id"));
				cus.setPw(rs.getString("pw"));
				cus.setImage(rs.getString("img"));
				cus.setPhoneNumber(rs.getString("hp"));
				cus.setTalkName(rs.getString("talk"));
				cus.setName(rs.getString("name"));
			}else{
				return new Customer("#","#");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		}

		return cus;
	}

	public ArrayList<Customer> ServerInit(){

		//친구 리스트 목록 가져옴

		ArrayList<Customer> custom = new ArrayList<>();

		Customer cus = null;

		String sql ="select * from customer";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			//			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				cus = new Customer();
				cus.setId(rs.getString("id"));
				cus.setPw(rs.getString("pw"));
				cus.setName(rs.getString("name"));
				cus.setImage(rs.getString("img"));
				cus.setPhoneNumber(rs.getString("hp"));
				cus.setTalkName(rs.getString("talk"));
				custom.add(cus);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		}

		return custom;

	}

	//친구 리스트 목록 가져옴
	public ArrayList<String> CusFriInit(String userid){
		ArrayList<String> list = new ArrayList<>();
		String sql ="select * from friendlist where id="+"\'"+userid+"\'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String id = rs.getString("id");
				String from_id = rs.getString("from_id");

				list.add(from_id);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		}

		return list;
	}
	public ArrayList<ChattingRoom> CusChatInit(String userid){

		ArrayList<ChattingRoom> list = new ArrayList<>();
		String sql ="select * from chattingroom where id=?"+
				"order by chattingroom.TIME";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next()){

				ChattingRoom chatRoom = new ChattingRoom();
				chatRoom.setChatName(rs.getString("chat_name"));
				chatRoom.setImage(rs.getString("img"));
				chatRoom.setCal(rs.getString("time"));
				chatRoom.setChatId(rs.getString("chatid") );
				list.add(chatRoom);

			}




		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		}

		return list;

	}
	public ArrayList<MessageFormat> CusMessageInit(String chatid){

		ArrayList<MessageFormat> list = new ArrayList<>();

		//		select * from messageformat where CHATID='1/2/3'
		//				order by messageformat.TIME;


		String sql ="select * from messageformat where CHATID=?"
				+"order by messageformat.TIME";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chatid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				MessageFormat message = new MessageFormat();
				message.setChatId(rs.getString("chatid"));
				message.setFrom(rs.getString("send_name"));
				message.setMessage(rs.getString("message"));
				message.setTime(rs.getString("time"));
				message.setType(rs.getInt("type"));
				list.add(message);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		}
		return list;
	}

	public void InputMessage(MessageFormat message){


		//		insert into messageformat (chatid,  send_name , time , message)
		//		values('1/2','1',to_char(sysdate, 'yyyymmdd day hh24 mi ss'), '하이');

		String sql ="Insert into messageformat (chatid, send_name, time, message) values ("
				+"\'"+ message.getChatId()+"\'" +","+"\'"+message.getFrom()+"\'"+",to_char(sysdate, 'yyyymmdd day hh24 mi ss'),"
				+ "\'"+message.getMessage()+"\'" +")";


		Connection conn = null;
		PreparedStatement pstmt = null;


		//		ResultSet rs = null;

		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			//			pstmt.setString(1, chatid);
			pstmt.executeQuery();


		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		}
	}
	public boolean IsChatId(String chatId){

		String sql ="select * from chattingroom where CHATID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chatId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				return true; // 방이 존재함
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		}
		return false;
	}

	public void InputChat(MessageFormat message) {
		// TODO Auto-generated method stub

		String id[] = message.getChatId().split("/");


		Connection conn = null;
		PreparedStatement pstmt = null;


		for (int i = 0; i < id.length; i++) {
			String sql ="Insert into chattingroom (chat_name, chatid, id, time) values ( "+"\'1\'"+", "
					+"\'"+ message.getChatId()+"\'" +","+"\'"+id[i]+"\'" +",to_char(sysdate, 'yyyymmdd day hh24 mi ss'))";
			try{
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);

				//				pstmt.setString(1, chatid);
				pstmt.executeQuery();


			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				}catch(Exception e ){
					e.printStackTrace();
				}
			}
		}



		//		ResultSet rs = null;


	}


	public void UpdateChatTime(MessageFormat message) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql ="update chattingroom set time ="+
				"to_char(sysdate,"+"\'"+"yyyymmdd day hh24 mi ss"+"\')"+
				"where chatid=?"; 

		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getChatId());

			pstmt.executeQuery();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		}
	}


	public boolean IsUserChk(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql ="select id from customer where id=?"; 
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeQuery();

			rs = pstmt.executeQuery();
			while(rs.next()){
				return true; // 사용자가 있음
			}
			return false;

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		}

		return false;
	}

	public boolean insertCustomer(Customer cus) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql =
				"insert into CUSTOMER " + "(ID, pw, name, hp )"
						+ " values ("+"\'"+cus.getId()+"\'"+","+"\'"+ cus.getPw()+"\'"+","
						+"\'"+cus.getName()+"\'"+","+"\'"+cus.getPhoneNumber()+"\'"+")";

		try{
			System.out.println(sql);
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			return true; // db 삽입 성공
		}catch(Exception e){
			e.printStackTrace();
			return false; // db 삽입 실패
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		}
	}


	public void updateFnd(String from, String to) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try{

			sql ="insert into FRIENDLIST(from_id, id)  values (\'"+from+"\'"+","+"\'"+
			to+"\'"+")";
			
			System.out.println(sql+" 1");
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			pstmt.close();
			
			sql ="insert into FRIENDLIST(from_id, id)  values (\'"+to+"\'"+","+"\'"+
					from+"\'"+")";
			
			System.out.println(sql+" 2");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
					

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e ){
				e.printStackTrace();
			}
		}

	}


	public void updateProfile(Customer cus) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

				Connection conn = null;
				PreparedStatement pstmt = null;
				

				String sql ="update customer set name ="+"\'"+
						cus.getName()+"\'"+" "+"where id="+"\'"+cus.getId()+"\'"; 
				

				try{
					conn = getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.executeQuery();
					
					pstmt.close();
					
					// 대화명 업데이트
					sql ="update customer set talk ="+"\'"+
							cus.getTalkName()+"\'"+" "+"where id="+"\'"+cus.getId()+"\'"; 
						pstmt = conn.prepareStatement(sql);
					pstmt.executeQuery();

				}catch(Exception e){
					e.printStackTrace();
				}finally{
					try{
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
					}catch(Exception e ){
						e.printStackTrace();
					}
				}
	}
}
