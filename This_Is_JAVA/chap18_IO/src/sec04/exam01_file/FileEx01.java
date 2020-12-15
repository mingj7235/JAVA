package sec04.exam01_file;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx01 {
	public static void main(String[] args) throws Exception{
		File dir = new File ("C:/Temp/Dir");
		File file1 = new File ("C:/Temp/file1.txt");
		File file2 = new File ("C:/Temp/file2.txt");
		File file3 = new File (new URI ("file:/C:/Temp/file3.txt"));
		
		if (dir.exists()==false) {
			dir.mkdirs();
		}
		if (file1.exists() ==false) {
			file1.createNewFile();
		}
		if (file2.exists() ==false) {
			file2.createNewFile();
		}
		if (file3.exists() ==false) {
			file3.createNewFile();
		}
		
		File temp = new File("C:/Temp");
		File [] contents = temp.listFiles();
		System.out.println("날짜				시간 	형태 	크기		이름");
		System.out.println("-------------------------------------------");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		for(File file : contents) {
			System.out.print(sdf.format(new Date(file.lastModified()))); //마지막 수정된 시간
			if (file.isDirectory()) { //파일이 디렉토리라면
				System.out.print("\t<DIR>\t\t" + file.getName());
			}else {
				System.out.print("\t\t\t" + file.length()+"\t" + file.getName());
			}
			System.out.println();
		}
	}
}
