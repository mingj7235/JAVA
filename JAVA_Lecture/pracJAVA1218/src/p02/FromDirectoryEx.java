package p02;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromDirectoryEx {
	public static void main(String[] args) throws Exception{
		Path path = Paths.get("C:/java/jdk1.8.0_201");
		Stream<Path>stream;
		
		stream = Files.list(path);
		stream.forEach(p->System.out.println(p.getFileName()));
	}
}
