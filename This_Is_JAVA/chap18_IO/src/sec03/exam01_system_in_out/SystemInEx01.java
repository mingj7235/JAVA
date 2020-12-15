package sec03.exam01_system_in_out;

import java.io.InputStream;

public class SystemInEx01 {
	public static void main(String[] args) throws Exception{
		System.out.println("==메뉴=="
				+ "\n1. 예금조회"
				+ "\n2. 예금출금"
				+ "\n3. 예금입금"
				+ "\n4. 종료하기");
		System.out.print("메뉴를 선택하세요 :");
		
		InputStream is = System.in;
		char inputChar = (char) is.read();
		switch(inputChar) {
		
		case '1' :
			System.out.println("예금조회");
			break;
		case '2' :
			System.out.println("예금출금");
			break;
		case '3' :
			System.out.println("예금입금");
			break;
		case '4' :
			System.out.println("종료하기");
			break;
		
		}
	}
}
