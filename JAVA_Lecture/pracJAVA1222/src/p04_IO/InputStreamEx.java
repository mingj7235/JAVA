package p04_IO;

import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamEx {
	public static void main(String[] args) throws Exception{
		InputStream is = new FileInputStream("C:/Temp/test1.txt");
		int readByte;
		
		while (true) {
			readByte = is.read(); //1바이트를 읽어온다. 한글이나 특수문자등 unicode자료는 깨진다. 
			if (readByte == -1) break;
			System.out.print((char)readByte); //아스키코드로 불러오기때문에 char로 변환하여 뽑아야한다. 
			//한글을 깨지기때문에 (2바이트씩이라서) 그래서 배열로 출력해줘야한다. 
			
		}
		is.close();
	}
}
