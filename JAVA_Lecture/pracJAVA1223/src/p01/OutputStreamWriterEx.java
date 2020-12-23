package p01;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriterEx {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("c:/tmep/fileoutput.txt");
		Writer writer = new OutputStreamWriter(fos);
		
		String data = "데이터 출력 스트림을 문자 출력 스트림으로 변환";
		writer.write(data);
		
		writer.flush();
		writer.close();
		fos.close();
		
	}
}
