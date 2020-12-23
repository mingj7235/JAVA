package p05;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Child extends Parent implements Serializable{
	public String field2;
	
	//자식객체를 직렬화 할 때 자동호출됨 
	private void writeObject (ObjectOutputStream out) throws Exception {
		out.writeUTF(field1);//부모 객체의 필드값을 출력함
		out.defaultWriteObject(); //자식 객체의 필드값을 직렬화
	}
	//자동호출됨
	private void readObject(ObjectInputStream in ) throws Exception {
		field1 = in.readUTF();
		in.defaultReadObject();
	}
}
