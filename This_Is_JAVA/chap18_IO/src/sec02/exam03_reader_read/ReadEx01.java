package sec02.exam03_reader_read;

import java.io.FileReader;
import java.io.Reader;

public class ReadEx01 {
	public static void main(String[] args) throws Exception{
		Reader reader = new FileReader ("C:/Temp/test.txt");
		int readData;
		while ( (readData = reader.read()) !=-1 ) {
			System.out.print((char)readData);
		}
		
		reader.close();
		
	}
}
