package sec02.exam02_outputstream_write;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteEx03 {
	public static void main(String[] args) throws Exception{
		OutputStream os = new FileOutputStream("C:/Temp/Text3.txt");
		byte [] data = "ABCDEFEfdf".getBytes();
		os.write(data, 3, 5);
		os.flush();
		os.close();
	}
}
