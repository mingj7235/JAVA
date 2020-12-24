package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	//throws : 예외 던지기
	//하나의 메소드 내에서 동일한 예외가 자주 발생한다면
	//예외가 메소드에 들어올 수 없도록 다시 발생된 쪽으로 던져준다. 
	//
	public static void main(String[] args) throws IOException  {
		//1. 절대 경로 : 애초에 처음부터 시작부터 쓰는 경로 
		//			어디에있든 찾아 갈 수 있는 경로
						// 현재 위치에 상관없이 찾아 갈 수 있는 경로
		//2. 상대 경로 : 상대적은 결론. 내가 어디에 있는지에 따라 달라진다.
						// 현재 위치에 따라서 결과가 변하는 경로 
		
		//입출력을 하게 되면 외부 저장소를 사용하기 때문에 IOException (입출력 예외) 가 발생한다.
		//따라서 반드시 예외 처리를 해주어야 사용이 가능하다.
		
		//덮어쓰기
//		BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));
		
		//이어쓰기
		BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt", true));
																					//true를 주면 append 즉, 덧붙이기가 된다. 
		
		//write메소드는 덮어쓰기 메소드다. 
		bw.write("한동석");
		bw.close();
	}
}
