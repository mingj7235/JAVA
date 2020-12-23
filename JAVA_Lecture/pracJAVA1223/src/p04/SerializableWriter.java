package p04;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

//직렬화 하는 코드
public class SerializableWriter {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("c:/temp/Obj2.dat");//바이트 기반 스트림 파일로 읽을 수 없다.
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		ClassA classA = new ClassA ();
		classA.field1 = 1;
		classA.field2.field1 =2; //ClassB의 필드에 값 넣기
		ClassA.field3 = 3;
		classA.field4 = 4;
		
		ClassC classC = new ClassC();
		classC.fieldC1 =100;
		classC.fieldC2 =200;
		
		oos.writeObject(classA);
		oos.flush();oos.close();fos.close();
		
	}
}
