package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SerializableEx {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ClassA classA = new ClassA();
		
		classA.field1 = 1;
		classA.field2.field1 = 2;
		classA.field3 =3;
		classA.field4 = 4;
		
		oos.writeObject(classA);
		
		oos.flush();
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ClassA v = (ClassA) ois.readObject();
		System.out.println(v.field1 + " " + v.field2.field1 + " " + v.field3 + " " + v.field4);
		//field4 는 transient로 선언된것이므로 직렬화가 되지 않아서 객체로 나오지 않는다!
		
	}
}
