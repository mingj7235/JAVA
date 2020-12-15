package sec02.exam01_inputstream_read;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadEx01 {
	public static void main(String[] args) throws Exception{
		InputStream is = new FileInputStream("C:/Temp/test.txt");
		
		int readByte;
		
//		while( (readByte=is.read()) != -1 ) {
//			System.out.print((char)readByte);
//		}
		
		while(true) {
			readByte = is.read();
			if(readByte ==-1) {
				break;
			}
			System.out.println((char)readByte);
		}
		is.close();
		
	}
}
