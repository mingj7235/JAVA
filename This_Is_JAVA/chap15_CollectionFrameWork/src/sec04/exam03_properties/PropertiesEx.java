package sec04.exam03_properties;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesEx {
	public static void main(String[] args) throws Exception{
		Properties properties = new Properties();
		
		//properties 파일 경로얻기
		String path = PropertiesEx.class.getResource("database.properties").getPath();
		
		//한글 복원
		path = URLDecoder.decode(path, "utf-8"); //예외 처리 필요함
		
		properties.load(new FileReader(path)); //FileReader는 제공된 path를 통해 파일을 읽음.
		//load를 통해 map을 만든다. 즉, 파일을 읽고, 그파일을 통해 map을 만드는것!
		
		String driver = properties.getProperty("driver"); //properties에있는 key 값을 던지면 value가 나온다.
		
		System.out.println(driver);
		
		
		
	}
}
