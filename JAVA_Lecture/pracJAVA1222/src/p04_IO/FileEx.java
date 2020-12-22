package p04_IO;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx {
	public static void main(String[] args) {
		File dir = new File("c:/temp/dir");
		File file1 = new File ("c:/temp/file1.txt");
		
		
		File temp = new File ("c:/temp");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
		File [] contents = temp.listFiles();
		System.out.println("날짜 시간 형태 크기 이름 ");
		System.out.println("=============");
		for (File file : contents) {
			System.out.print(sdf.format(new Date (file.lastModified())));
			if(file.isDirectory()) {
				System.out.print("\t <dir>\t\t" +file.getName());
			}else {
				System.out.print("\t\t\t"+file.length() + "\t" + file.getName());
			}
			System.out.println();
		}
	}
}
