package in_outputFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite {
	public static void main(String[] args) throws IOException{
//		FileOutputStream output = new FileOutputStream("c:/out.txt");
//		for (int i = 1; i < 11; i++) {
//			String data = i+"번째 줄입니다.\r\n";
//			output.write(data.getBytes());
//		}
//		output.close();
//		FileWriter fw = new FileWriter("c:/out.txt");
//		for (int i = 0; i < 10; i++) {
//			String data = i+1+ "번째 줄입니다. \r\n";
//			fw.write(data);
//		}
//		fw.close();
		
		PrintWriter pw = new PrintWriter("C:\\Users\\joshua\\Desktop\\JAVA/out.txt");
		for (int i = 0; i < 10; i++) {
			String data = i+1+ "번째 줄입니다.";
			pw.println(data);
		}
		pw.close();
		
		PrintWriter pw2 = new PrintWriter(new FileWriter("C:\\Users\\joshua\\Desktop\\JAVA/out.txt", true));
		for (int i = 10; i < 20; i++) {
			String data = i+1 + "번째 줄입니다.";
			pw2.println(data);
		}
		pw2.close();
	}
}
