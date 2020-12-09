package sec02.stream_kind;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileContentEx {
	public static void main(String[] args) throws IOException{
		//문자파일안에 있는 라인별로 처리하는 스트림
		Path path = Paths.get("src/sec02/stream_kind/linedata.txt");
		Stream <String> stream; //문자열이므로 String
		
		//1. Files.lines() 이용
		stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(System.out :: println); //메소드 참조법
//		stream.forEach(s -> System.out.println(s)); //람다식 이용법
		stream.close();
		System.out.println();
		
		//2. BufferedReader의 lines() 이용
		File file = path.toFile();
		FileReader fileReader = new FileReader(file);
		//문자를 읽을때 사용하는 스트림 : FileReader
		BufferedReader br = new BufferedReader(fileReader); //속도향상을 위해 bufferedreader사용
		stream = br.lines();
		stream.forEach(System.out :: println);
		stream.close();
	}
}
