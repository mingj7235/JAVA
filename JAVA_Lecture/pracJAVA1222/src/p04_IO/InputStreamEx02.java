package p04_IO;

import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamEx02 {
	public static void main(String[] args) throws Exception{
		InputStream is = new FileInputStream("C:/Temp/test1.txt");
		int readByteNo;
		byte [] readBytes = new byte [8];
		readByteNo = is.read(readBytes,2,3); 
		for (int i = 0; i < readBytes.length; i++) {
			System.out.println((char)readBytes[i]);
		}
		is.close();
	}
}
