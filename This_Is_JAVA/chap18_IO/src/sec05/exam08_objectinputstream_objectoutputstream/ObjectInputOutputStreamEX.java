package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamEX {
	public static void main(String[] args) throws Exception{
		//파일 내보내기 (출력)
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(new Integer (10));
		oos.writeObject(new Double(13.0));
		oos.writeObject(new int [] {1,2,3});
		oos.writeObject(new String ("홍길동"));
		//모든 객체를 다 출력가능함
		
		oos.flush();
		oos.close();
		fos.close();
		
		//파일 읽어오기
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//읽어올 파일의 순서는 출력한 파일의 순서와 같아야함
		
		Integer obj1 = (Integer) ois.readObject();
		Double obj2 = (Double) ois.readObject();
		int [] obj3 = (int []) ois.readObject();
		String obj4 = (String) ois.readObject();
		
		ois.close();
		fis.close();
		
		System.out.println(obj1 + " " + obj2 + " " + obj3[0] + obj3[1] + obj3[2] + " " + obj4 + " ");
		
		
	}
}
