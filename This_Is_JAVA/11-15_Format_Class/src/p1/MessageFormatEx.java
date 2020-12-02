package p1;

import java.text.MessageFormat;

public class MessageFormatEx {
	public static void main(String[] args) {
		//데이터를 파일에 저장하거나, 네트워크로 전송할 때, 데이터베이스 SQL 문 작성시 일정한 형식 문자열 사용
		//MessageFormat 클래스 사용으로 문자열에 데이터가들어갈 자리를 표시! 해두고, 
		//프로그램이 실행하면서 동적으로 데이터를 삽입해 문자열을 완성시킬 수 있다. 
		String id = "joshuara7235";
		String name = "김민재";
		String tel = "010-6470-7235";
		
		String text = "회원 ID : {0} \n회원 이름 : {1} \n회원 핸드폰 번호 : {2}";
		String result1 = MessageFormat.format(text, id, name, tel);
		System.out.println(result1+ "\n");
		
		String sql = "insert into member values ({0}, {1}, {2})";
		Object [] arInformation = {id, name, tel};
//		String [] arInformation = {id, name, tel};
		String result2 = MessageFormat.format(sql, arInformation);
		System.out.println(result2);
	
	}
}
