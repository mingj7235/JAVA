package p4_hashCode;

public class HashCodeEx {
	public static void main(String[] args) {
		String str1 = new String ("abc");
		String str2 = new String ("abc");
		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		//얘네는 System 클래스에 있는 놈임. 원래 object에서 말하는 hashcode값을 알려준다.
		//즉, 위의 hashCode는 String에서 오버라이드 한 것인데,
		//identityHashCode는 오버라이드 되지 않은 hashCode값을 보여준다. 
		// 오버라이드를 하지 못하게 만들었기때문에 바로 찍을 수 있다. 
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
		
	}
}
