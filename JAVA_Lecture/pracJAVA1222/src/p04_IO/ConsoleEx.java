package p04_IO;

import java.io.InputStream;

public class ConsoleEx {
	public static void main(String[] args) throws Exception{
		System.out.println("입력하세요 ==>");
		InputStream is = System.in;
		byte [] datas = new byte [100];
		System.out.print("이름 : ");
		int nameBytes = is.read(datas);
		System.out.println(nameBytes); //이름 '홍길동' 을 넣으면 8이 나옴 왜?  엔터가 들어가서그렇다. 원래 6이어야한다
		String name = new String (datas, 0, nameBytes-2); //2를 빼줘야함 
		System.out.println("입력한 이름 : " + name);
		
		
	}
}
