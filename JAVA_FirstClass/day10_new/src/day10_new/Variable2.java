package day10_new;

public class Variable2 {
	public static void main(String[] args) {
		Variable1 v1 = new Variable1();
		Variable1 v2 = new Variable1();

		v1.data_s = 400;
		System.out.println(v1.data_s);
		System.out.println(v2.data_s);
		Variable1.data_s =600;
		System.out.println(Variable1.data_s);
		System.out.println(v1.data_s);
		System.out.println(v2.data_s);

		//v1에서 접근해서 data_s를 변화 시켰는데
		//v2에서 접근해도 변하여있다. 
		//이말은 static변수는 객체상관없이
		//값을 동일하게 공유한다는 것이다.
		
		
		//그러므로 v1으로 접근하지 않고
		//이렇게 클래스명으로 직접 static변수에 접근한다
		//그래서 static변수를 클래스변수라고도한다. 

		++Variable1.data_s;
		++Variable1.data_s;
		++Variable1.data_s;
		++Variable1.data_s;
		System.out.println(Variable1.data_s);
		
		v1.increase();
		v1.increase();
		v1.increase();
		v1.increase();
		System.out.println(v1.data);
		v1 = new Variable1();
		//new를 만나면 전역변수는 초기화가 된다. 
		v1.increase();
		v1.increase();
		v1.increase();
		v1.increase();
		System.out.println(v1.data);
		
	}
}