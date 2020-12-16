package sec05.exam04_bufferedreader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderEx {
	public static void main(String[] args) throws Exception{
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);
		//inputstream에 연결된 보조스트림이 2개다 문자변환, 성능향상
		
		System.out.print("입력 : ");
		String lineString = br.readLine(); // 한 줄 전체를 읽어줌
		System.out.println("출력 : " + lineString);
		
		
		//스트림 3개 모두 클로즈
		br.close();
		reader.close();
		is.close();
		
	}
}
