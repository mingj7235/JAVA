package p04_IO;

import java.io.OutputStream;

public class ConsoleOut {
	public static void main(String[] args) throws Exception{
		OutputStream os = System.out;
		
		for(byte b = 48; b <58 ; b++) {
			os.write(b);
		}
		
		os.write(10);
		for (Byte b = 97; b<123; b++) {
			os.write(b);
		}
		
		String hangul = "가나다라마";
		byte [] hangulByte = hangul.getBytes();
		os.write(hangulByte);
		os.flush();
		os.close();
	}
}
