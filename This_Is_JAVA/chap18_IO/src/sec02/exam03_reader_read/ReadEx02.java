package sec02.exam03_reader_read;

import java.io.FileReader;
import java.io.Reader;

public class ReadEx02 {
	public static void main(String[] args) throws Exception{
		Reader reader = new FileReader ("C:/Temp/test.txt");
		int readCharNo;
		char [] cbuf = new char[3];
		String data = "";
		while ( (readCharNo = reader.read(cbuf)) != -1 ) {
			data += new String (cbuf, 0, readCharNo);
		}
		System.out.println(data);
		
		reader.close();
		
	}
}
