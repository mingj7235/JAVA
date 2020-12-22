package p04_IO;

import java.io.FileWriter;
import java.io.Writer;

public class WriterEx {
	public static void main(String[] args) throws Exception{
		Writer writer = new FileWriter ("c:/Temp/fWriter.txt");
		char [] data = "ȫ�浿".toCharArray();
		for (int i = 0; i < data.length; i++) {
			writer.write(data);
		}
		writer.flush();
		writer.close();
	}
}
