package sec04.exam02_fileinputstream;

import java.io.FileInputStream;

public class FileInputStreamEx {
	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream("C:/Users/User/Desktop/GitHub/JAVA/This_Is_JAVA/chap18_IO/src/sec04/exam02_fileinputstream/FileInputStreamEx.java");
		int data;
		while ( (data = fis.read()) != -1 ) {
			System.out.write(data);	//system.outÀº Ãâ·Â
		}
		System.out.flush();
		fis.close();
	}
}
