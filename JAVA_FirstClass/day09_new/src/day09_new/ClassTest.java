//this라는 변수가 가지고 있는 주소값이 접근한 객체의 주소가 넘어간다는 것을 보여주는 증명.
//this : 접근한 객체가 가지고 있는 주소값. 

//. 앞에는 무조건 주소값만 올 수 있으므로, this는 주소값이다. 
package day09_new;
class A {
	int data = 100;
	
	int getData ()	{
		System.out.println(this);
		return this.data;
	}
}

public class ClassTest {
	public static void main(String[] args) {
		A obj = new A ();
		A obj2 = new A();
		
		System.out.println(obj);
		System.out.println(obj2);
		
		obj2.data = 400;
		
		System.out.println(obj.getData());
		System.out.println(obj2.getData());
	}

}

//obj 에는 주소가 담겨있다
//obj 와 obj2가 주소가 다르다. new를 만나 새로 생성자를 호출할 때마다 주소가 새로 생긴다. 