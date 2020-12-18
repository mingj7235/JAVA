package p02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileEx {
	public static void main(String[] args) throws Exception{
		Path path = Paths.get("c:/Temp/file.txt");
		Stream <String> stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(System.out::println);
		stream.close();
		
		//BufferedReader.lines()를 이용해서 파일 스트림 얻기
		File file = path.toFile();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader (fileReader);
		Stream <String> stream2 = br.lines();
		stream2.forEach(m ->System.out.println(m));
		
	}
}
