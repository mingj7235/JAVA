package singleton;



public class Single {
	//생성자를 private으로 하면 접근못하게한다.
	private Single() {} //밖에서 new하지마! 라는 의미
	
	//instance 라는 객체만 사용할수있도록 만들도록
	private static Single instance = new Single();

	public static Single getInstance() {		//접근 할 수 있도록 만들어준다. 
		return instance;
	}

	//setter는 없애준다. 왜냐하면 수정할 수 없도록 만드는게 목적이므로!
//	public static void setInstance(Single instance) {
//		Single.instance = instance;
//	}

	
	public void sayHello() {
		System.out.println("안녕");
	}
}



