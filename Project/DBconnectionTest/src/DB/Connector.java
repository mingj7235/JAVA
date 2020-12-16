package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Connector {
	public static void main(String[] args) {
		createTable();
		createCustomer("Danny","01064707235","Male","24","Random");
		ArrayList <String> list = getCustomers();
		for (String item : list) {
			System.out.println(item);
		}
		createCustomer("David","01012342412","Female","24","Important Customer");
	}
	
	public static ArrayList<String> getCustomers ( ) {
		//데이터를 list에 return시켜서 불러옴
		try {
			Connection con  = getConnection();
			PreparedStatement statement = con.prepareStatement("Select name, phone, gender FROM customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String> list = new ArrayList <String> ();
			while (results.next()) { //데이터가 끝날때까지 whlie 루프롤통해 list에 저장
				list.add("Name : " + results.getString("name") + 
						"Phone :" + results.getString("phone") + 
						"Gender : " + results.getString("gender"));
				
			}
			System.out.println("The data has been fetched");
			return list;
		}catch (Exception e) {
			return null;
		}
	}
	
	public static void createCustomer (String name, String phone, String gender,
			String age, String note) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO customer"
					+ "(name, phone, gender, age, note)"
					+ "VALUE "
					+ "('" +name + "','" + phone +"','" + gender+ "','" + age+"','" + note +"')");
			//('name','phone','gender','age','note')
			insert.executeUpdate();
			System.out.println("The data has been saved!");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void createTable () {
		try {
			Connection con = getConnection();
			PreparedStatement createTable = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+ "customer (id int NOT NULL AUTO_INCREMENT,"
					+ "name varChar(255),"
					+ "phone varChar(255),"
					+ "gender varChar(255),"
					+ "age varChar(255),"
					+ "note varChar(255),"
					+ "PRIMARY KEY (id))");
			//sql에게 이 table을 만들어라 라고 명령하는 것임
			createTable.execute();
			System.out.println("Table successfully created");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Table successfully created");
		}
	}
	
	public static Connection getConnection () {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/customer?serverTimezone=UTC";
			String user = "root";
			String pw = "4tkfkdwlrl@";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pw);
			System.out.println("The connection Successful!");
			return con;
		}catch (Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
}
