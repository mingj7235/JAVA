package sec02.exam04_writer_write;

import java.io.FileWriter;
import java.io.Writer;

public class WriterEx02 {
	public static void main(String[] args) throws Exception{
		Writer writer = new FileWriter("C:/Temp/test.txt");
		char [] data = "홍길동헤이호오오".toCharArray();
		writer.write(data);
		
		writer.flush();
		writer.close();
	}
}
