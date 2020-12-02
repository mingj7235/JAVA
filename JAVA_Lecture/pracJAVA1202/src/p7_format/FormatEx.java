package p7_format;

import java.text.MessageFormat;

public class FormatEx {
	public static void main(String[] args) {
		//MessageFormat
		String id = "java";
		String name = "신용권";
		String tel = "010-123-5678";
		
		String text = "회원 ID : {0} \n회원 이름 : {1} \n회원 전화 : {2}";
		Object[] arguments = {id, name, tel};
		String result = MessageFormat.format(text, arguments);
		System.out.println(result);
	}
}
