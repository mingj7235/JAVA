package access;

import day13.Access;

public class Access3 {
	void function() {
		Access a = new Access();
		//다른 패키지에 있는 클래스를 불러오니까 import가 생김
		
		System.out.println(a.data2);
		//public인 data2만 패키지가 달라도 접근이 가능함. 
		
		System.out.println(a.getData4());
		int data4 = 0;
		a.setData4(50);
		System.out.println(a.getData4());
		
	}
	
	public static void main(String[] args) {
		Access3 a = new Access3();
		a.function();
	}
}
