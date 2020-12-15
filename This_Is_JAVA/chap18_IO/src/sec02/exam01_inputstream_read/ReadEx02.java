package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadEx02 {
	public static void main(String[] args) throws Exception{
		InputStream is = new FileInputStream("C:/Temp/test.txt");
		int readByteNo; //read메소드가 읽은 바이트 수를 저장
		byte [] readBytes = new byte [3]; //read 메소드가 읽은 데이터를 저장
		String data = "";
		while ( (readByteNo = is.read(readBytes)) != -1 ) {
			data += new String (readBytes, 0, readByteNo); //String 클래스의 생성자 이용. (자료있는곳, 읽을 자료 인덱스, 읽을 인덱스부터 자료의 수)
		}
		System.out.println(data);
		is.close();
	}
}
