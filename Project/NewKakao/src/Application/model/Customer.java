package Application.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	static Customer customer ;
	
	ArrayList<ChattingRoom> chattingRoom = new ArrayList<>() ; // 추가 되어 있는 채팅목록 
	ArrayList<Customer> friendList = new ArrayList<>(); //  추가되어 있는 친구
	
	String id="";  // 아이디 (필수) , 이메일 양식
	String pw=""; // 비밀번호 (필수)
	String name="";		// 이름 (필수)
	
	String Image = ""; // 자신의 이미지 (선택)
	String PhoneNumber=""; // 전화번호 (선택)
	String talkName = ""; // 대화명 (선택)
	
		
	public ArrayList<ChattingRoom> getChattingRoom() {
		return chattingRoom;
	}

	public void setChattingRoom(ArrayList<ChattingRoom> chattingRoom) {
		this.chattingRoom = chattingRoom;
	}

	public String getTalkName() {
		return talkName;
	}

	public void setTalkName(String talkName) {
		this.talkName = talkName;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String img) {
		this.Image = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public ArrayList<Customer> getFriendList() {
		return friendList;
	}
	public void setFriendList(ArrayList<Customer> friendList) {
		this.friendList = friendList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static void setCustomer(Customer customer1) {
		customer = customer1;
	}	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name, String id) {
		this.name = name;
		this.id = id;
	}
	public Customer(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name=name;
		this.PhoneNumber = "1234";
	}
	public Customer(String id, String pw, String name, String img, String talkName) {
		this.id = id;
		this.pw = pw;
		this.name=name;
		this.PhoneNumber = "1234";
		this.Image = img;
		this.talkName = talkName;
	}
	public Customer(String name , String id, String img, String talkName) {
		this.id = id;
		this.name=name;
		this.PhoneNumber = "1234";
		this.Image = img;
		this.talkName = talkName;
	}

	
	static public Customer getCustomer(){
		return customer;
	}
}
