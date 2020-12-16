package sec05.exam08_objectinputstream_objectoutputstream;

import java.io.Serializable;

public class ClassC implements Serializable {
	private static final long serialVersionUID = -1265691405514514962L;
	//UID를 저장해놓으면 필드를 계속 수정해도, 직렬화, 역직렬화가 가능하다. 
	int field1;
	int field2;
}
