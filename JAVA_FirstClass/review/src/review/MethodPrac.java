package review;


public class MethodPrac {

	 int add (int num1, int num2) {
		 System.out.println("덧셈 메소드");
		 return num1 + num2;
	 }
	 
	public static void main(String[] args) {
		MethodPrac math = new MethodPrac();
		int result = math.add(3, 10);
		System.out.println(result);
		//리턴값이 있는 메서드는 통째로를 return 값을 볼줄 알아야 한다! 
		//리턴값이 없는 매서드는 값으로 보면 안된다. 
		//메서드는 재사용. 기능을 부여. 특정성을 부여시키면 안된다. 
		
		
		
		
	}
}
