package day25Prac;

public class ObjectTest {
	public static void main(String[] args) {
		//constant pool (상수들이 보관되어있는 pool)
		//사실은 str1과 str2 가 constant pool에 있는 하나의data를 공유하는 것.  
		String str1 = "data";
		String str2 = "data";
		String str3 = new String("data");		
		String str4 = new String("data");		
		
		System.out.println(str1 == str2);
		System.out.println(str3.intern() == str4.intern());
		System.out.println(str1 == str3); //false
		System.out.println(str1 == str3.intern()); //true
		// intern()
		// constant pool에 같은 '값'을 검색하여 그 값이 constant pool에 있다면 그 주소값을 반환해 준다.
		// 고로, 그 값을 4개의 str들이 공유하고 있는 것이다. 
		
		System.out.println(str1.equals(str3)); //true
		//String 클래스의 equals()는 값을 비교하기때문에 true가 나온다. 
		System.out.println("____________________________________________________");
		
		String [] arStr ={
			new String ("data1"),
			new String ("data2"),
			new String ("data3")
		};
		
		System.out.println(arStr); // 배열의 시작주소가 나옴 즉, "data1" 을 담고있는 주소임.
		
		System.out.println(arStr[0] =="data1");	//== 은 주소값을 비교하므로 false다. 주소값이 다르다. 
		System.out.println(arStr[0].intern() =="data1");	
		System.out.println(arStr[0].equals("data1")); // String 클래스안의 equals()는 값을 비교하니까. 
		
		
	}
}
