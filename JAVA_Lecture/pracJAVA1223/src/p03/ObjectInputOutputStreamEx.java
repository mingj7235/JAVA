package p03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamEx {
	public static void main(String[] args) throws Exception{
		//직렬화
		FileOutputStream fos = new FileOutputStream("c:/temp/obj1.txt");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(10);
		oos.writeObject(3.14);
		oos.writeObject(new int [] {1,2,3,4});
		oos.writeObject(new String ("홍길동"));
		
		oos.flush();oos.close();fos.close();
		//역질렬화//
		
		FileInputStream fis = new FileInputStream("c:/temp/obj1.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Integer obj1 = (Integer) ois.readObject();
		Double obj2 = (Double) ois.readObject();
		int[] obj3 = (int[]) ois.readObject();
		String obj4 = (String) ois.readObject();
		
		ois.close();fis.close();
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		System.out.println(obj4);
		
		
	}
}
