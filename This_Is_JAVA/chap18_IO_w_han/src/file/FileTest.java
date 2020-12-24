package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
//																					//true를 주면 append 즉, 덧붙이기가 된다. 
//		
		
		//줄바꿈은 \n을 작성한다.
		//bw.newLine() 도 줄바꿈하는 메소드이다. 
		
		
//		//write메소드는 덮어쓰기 메소드다. 
		bw.newLine();
		bw.write("굳굳 \n");
		bw.write(" 짱");
		bw.close();
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("test.txt"));
			String line = null;
			int cnt = 0;
			while (true) {
				//readLine()은 줄바꿈은 가져오지 않는다. 
				line = br.readLine();
				cnt ++;
				//메모장을 기준으로 한 줄을 읽어오는 친구다. 
				//readLine 메소드는 줄을 다 읽으면 null을 리턴한다. 
				if (line == null) {break;}
				System.out.println(line);
				System.out.println(cnt);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("경로에 파일이 존재하지 않습니다.");
		} finally {//외부 문서에서 가져올때 finally를 사용한다. 
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {
				//예외를 발생시켜주는 것 일부러. 
				//throw를 통해 예외를 메모리에 할당시키는 것임.
				//그러면 왜 발생 시켰는가? 문제가 생기면 예외를 발생시켜서 프로그램을 종료시키기 위해서
				//닫는 부분에서 예외 발생시 닫히지 않은 상태로 유지될 수 있다.
				//메모리 누수가 생겨서 메모리에 타격이 가기 때문에 강제 종료 하기 위해 예외를 발생해 준다.
				//생성자에 문자열값을 넘겨주면 콘솔창에 출력된다. 
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}



















