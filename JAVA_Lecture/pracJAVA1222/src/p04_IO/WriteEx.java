package p04_IO;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteEx {
	public static void main(String[] args) throws Exception{
		OutputStream os = new FileOutputStream("c:/Temp/output1.txt");
		
		byte[] data = "ABCDEF".getBytes();
		os.write(data);
//		for (int i = 0; i < data.length; i++) {
//			os.write(data[i]);
//		}
		os.flush();
		os.close();
	}
}
