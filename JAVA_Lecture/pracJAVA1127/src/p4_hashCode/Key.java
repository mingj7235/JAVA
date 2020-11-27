package p4_hashCode;
//예제4) Key클래스는 equals( )메소드를 재정의해서 number필드값이 같으면 true를 리턴하도록 했다. 
//그러나 hashCode 메소드를 재정의하지 않았기 때문에 null로 인식된다.
//--> 해결방법 hashCode를 재정의한다
public class Key {
	public int number ;
	public Key(int number) {
		this.number = number;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof Key) {
//			Key compareKey = (Key) obj;
//			if (this.number == compareKey.number) {
//				return true;
//			}
//		}
//		return false;
//	}//end overrided equals method
//	
//	@Override
//	public int hashCode() {
//		return number;
//	}
	//keyExample 클래스에서 key생성자의 매개값이 number. 이것이 같을 때, equals로 가서 true가 리턴되므로 동등한 값이 된다. 
	
	
}
