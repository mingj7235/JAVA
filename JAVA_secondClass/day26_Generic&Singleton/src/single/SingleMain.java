package single;
/*
 * 패키지 명에 .(하위연산자)를 사용하면 폴더가 하나 더 만들어진다.
 * a.b.c.d
 * a.폴더 안에 b폴더안에 c폴더안에 d
 * 
 */
public class SingleMain {
	public static void main(String[] args) {
//		day26.Single s = new day26.Single();
		singleton.Single s = singleton.Single.getInstance();
		//이렇게 쓰는것이다. 새로 heap에 할당하지않고 new 해놓은 하나의 객체를 사용하는 것. 
		s.sayHello();
		
		
	}
}
