package sec05.exam01_inpustreamreader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderEx {
	public static void main(String[] args) throws Exception{
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		//얘는 reader를 상속 받은거라 Reader 타입으로 선언 가능
		
		int readCharNo;
		char [] cbuf = new char [100];
		
		while ( (readCharNo = reader.read(cbuf)) != -1 ) {
			String data = new String (cbuf, 0, readCharNo);
			System.out.println(data);
		}
		
		is.close();
		reader.close();
		
	}
}
