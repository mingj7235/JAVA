package p04;

import java.io.Serializable;
//직렬화 하려는 클래스 구현하기 -> Serializable을 implements해야한다.  
public class ClassA implements Serializable{
	int field1;
	ClassB field2 = new ClassB();
	static int field3;
	transient int field4; 
}
