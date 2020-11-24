package day22_innerClass;

public class OutClass {
	//외부클래스 필드
	int outData;
	
	public OutClass() {
		System.out.println("외부 클래스 생성자 호출 됨.");
	}
	public void showOuter() {
		System.out.println("외부 클래스의 메서드 호출 됨.");
	}
	public class InnerClass{
		//public class로 선언해준다. 
		//얘도 OuterClass의 필드 중 하나로 인식하면 된다.
		int inData;
		public InnerClass() {
			System.out.println("내부 클래스 생성자 호출 됨.");
		}
		public void showInner() {
			outData = 20;
			//외부클래스 변수를 사용가능
			System.out.println("내부 클래스의 메서드 호출 됨.");
			System.out.println("outData : " + outData);
			showOuter();
			//외부클래스 메소드도 사용가능
			//내부에서 외부의 필드들에 접근. 굉장히 용이함. 
		}
	}
//	InnerClass inner = new InnerClass();
	
	public static void main(String[] args) {
		//외부클래스부터 객체화한다.
		OutClass out = new OutClass();
		//out 객체를 사용하여 내부클래스의 생성자를 호출한다. 
		OutClass.InnerClass in = out.new InnerClass();
		in.showInner();
		
		
		//출력내역. !!
//		외부 클래스 생성자 호출 됨.
//		내부 클래스 생성자 호출 됨.
//		내부 클래스의 메서드 호출 됨.
//		outData : 20
//		외부 클래스의 메서드 호출 됨.
		
		//workspace 에 bin 폴더를 가면 OutClass$InnerClass.class 파일이있다.
		//이게 내부클래스다. 
		
		
		
		
		
		
		
		
		
	}
	
}
