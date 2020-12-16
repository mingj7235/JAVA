package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.Serializable;

public class ClassA implements Serializable{ //직렬화가 가능하게끔 함
	int field1 ;
	ClassB field2 = new ClassB ();
	static int field3;
	transient int field4; 	//byte로 변환하지 않음. 
}
