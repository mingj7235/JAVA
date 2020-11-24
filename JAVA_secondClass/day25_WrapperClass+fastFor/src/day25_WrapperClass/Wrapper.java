package day25_WrapperClass;

public class Wrapper {
	
	public void add (Object a, Object b) {
		//문자열로 바꿔준 후 연결해주는 메서드
		System.out.println(""+a+b);
	}
	
	public static void main(String[] args) {
		String str = "1";
		//클래스인데 어떻게 바로 주소값이 아니라 값을 넣는가? 이걸 궁금해해야한다. 
		//String str = new String("1"); //원래는 이렇게 썼어야한다. jdk 1.5버전 이후부터는 오토박싱, 오토언박싱이 가능하다. 
		
		
		String str2 = "1"; //오토 박싱(Boxing)
		String str3 = new String("1"); //박싱
		
		Integer data = 10; //오토 박싱 wrapper클래스로 값을 넣으면 박싱
		int data2 = data; //오토 언박싱 기본형타입을 wrapper 클래스 (data는 Integer타입이니까) 로 넣으면 언박싱. 
		//앞이 기준이다. 
		
		/*
		 * 그러면 이 wrapper 클래스를 왜쓰는가? 
		 * 1. 기본형 타입을 객체로 다뤄야 할 때
		 * 2. 매개변수를 객체로 넘길 때
		 * 3. 기본형 타입이 아닌 객체로 저장해야 할 때 
		 * 4. 객체간의 비교가 필요할 때
		 * 
		 */
		// 기본형 타입을 객체로 다뤄야할 때
		Object [] arData = {
			new Integer(10),
			new Double(24.9),
			new String("하이")
		};
		//타입이 다른 객체를 Object 타입의 배열로 담으면 편하다. 이때 알아야하는게 wrapper 클래스.
		
		//매개변수를 객체로 넘길때. 
		new Wrapper().add(new String("사랑해"), new Double(2.5));
		
		
		
		
	}
}
