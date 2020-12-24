package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.FileObject;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileManager.Location;

public class FirleTest2 {
	public static void main(String[] args) throws IOException{
//		BufferedWriter bw = new BufferedWriter (new FileWriter ("food.txt"));
//		
//		
//		bw.write("잡채\n");
//		bw.write("불고기\n");
//		bw.write("피자\n");
//		bw.write("파스타\n");
//		
//		bw.close();
		
		//CRUD 

		//수정
		
		//수정을 위해서는 검사를 먼저해야한다. 
//		BufferedReader br = null;
//		
//		try { //검사르 ㄹ하기 위해 읽어온것이다. 
//			br = new BufferedReader(new FileReader("food.txt"));
//			String line = null;
//			String temp = "";
//			boolean check = false;
//			
//			while (true) { //와일을 돌려서 파일 한줄을 담는다. 
//				line = br.readLine();
//				if (line == null) {break;	}
//				if(line.equals("잡채")) { //검사해서 수정할 곳을 찾는다. 
//					temp +="떡볶이\n";
//					check = true;
//					continue; //수정이되면 밑에부분 패스를 하기위해서  continue를 해준다. 
//				}
//				temp += line + "\n"; //잡채가 아닌경우 이부분으로 넘어온다. 
//			}
//			
//			if (check) { //수정이 됬을 때만 여기로 와라 
//				BufferedWriter bw = new BufferedWriter(new FileWriter("food.txt"));
//				bw.write(temp);
//				bw.close();
//			}
//			
//		} catch (Exception e) {
//			System.out.println("해당 경로에 파일이 존재하지 않습니다.");
//		}finally {
//			try {
//				if(br != null) {
//					br.close();
//				}
//			} catch (Exception e) {
//				throw new RuntimeException(e.getMessage());
//			}
//		}
		
		
		//삭제 (피자를 삭제해보자)
//		BufferedReader br = null;
//		
//		try { 
//			br = new BufferedReader(new FileReader("food.txt"));
//			String line = null;
//			String temp = "";
//			boolean check = false;
//			
//			while (true) { 
//				line = br.readLine();
//				if (line == null) {break;	}
//				if(line.equals("피자")) { 
//					check = true;
//					continue; 
//				}
//				temp += line + "\n"; 
//			}
//			
//			if (check) { 
//				BufferedWriter bw = new BufferedWriter(new FileWriter("food.txt"));
//				bw.write(temp);
//				bw.close();
//			}
//			
//		} catch (Exception e) {
//			System.out.println("해당 경로에 파일이 존재하지 않습니다.");
//		}finally {
//			try {
//				if(br != null) {
//					br.close();
//				}
//			} catch (Exception e) {
//				throw new RuntimeException(e.getMessage());
//			}
//		}
//		
		//검색
		BufferedReader br = null;
		
		try { 
			br = new BufferedReader(new FileReader("food.txt"));
			String line = null;
			boolean check = false;
			
			while (true) { 
				line = br.readLine();
				if (line == null) {break;	}
				if(line.contains("압")) { 
					check = true;
					System.out.println(line);
				}
			}
			if (!check) {
				System.out.println("검색 결과 없음");
			}
						
		} catch (Exception e) {
			System.out.println("해당 경로에 파일이 존재하지 않습니다.");
		}finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}
