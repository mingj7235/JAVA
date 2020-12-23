package p02;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamEx {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("c:/temp/test2.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("홍길동");
		dos.writeDouble(95.5);
		dos.writeInt(1);
		
		dos.writeUTF("감자바");
		
		dos.flush();
		dos.close();
		fos.close();
		
		
		
	}
}
