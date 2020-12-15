package sec02.exam02_outputstream_write;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteEx02 {
	public static void main(String[] args) throws Exception{
		OutputStream os = new FileOutputStream("C:/Temp/Text.txt");
		byte [] data = "ABCDEFEfdf".getBytes();
		os.write(data);
		os.flush();
		os.close();
	}
}
