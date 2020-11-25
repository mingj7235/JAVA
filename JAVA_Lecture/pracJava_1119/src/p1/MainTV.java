package p1;

public class MainTV {
	public static void main(String[] args) {
		//CaptionTV 인스턴스화 하기
//		CaptionTV captionTV = new CaptionTV();
//		captionTV.channelUp();
//		System.out.println(captionTV.channel);
//		captionTV.channelDown();
//		System.out.println(captionTV.channel);
//		
//		//AI TV 인스턴스화하기
//		AItv aitv = new AItv();
//		aitv.channelUp();
//		System.out.println(aitv.channel);
//		aitv.channelDown();
//		System.out.println(aitv.channel);
//		
//		//TV 클래스
//		TV tv = new TV();
//		tv.channelUp();
//		System.out.println(tv.channel);
		
		//자신을 인스턴스화 한것을 자신의 클래스로 받았다면,
		TV tv1 = new CaptionTV(); //upcasting 자동형변환
		TV tv2 = new AItv();
		//다형성을 활용하면, 자식의 인스턴스화를 부모의 클래스로 담는다.
		//이것이 다형성이다. 
		//자손이 new에 올라가는데, 부모의 참조변수로 감.
		//자식이 heap에 올라가기 전에 부모먼저 올린다. !!
		//그러므로 heap에 부모의 정보도 같이 있으므로,
		//부모타입 클래스의 변수에 담을 수 있다. 
		
//		CaptionTV tv3 = new TV();
//		AItv tv4 = new TV();
		//반대의 경우는 가능하지 않다. 
		//new 하여 부모클래스가 heap 에 올라가면, 자식은 같이 올라가지
		//않으므로, 자식 클래스 타입의 변수에 담을 수 없다.
		//heap 메모리에는 TV() 부모클래스만 있는데, 
		//참조변수는 자식 클래스를 가르켜야하므로 불가능 ! 
		
		//부모 필드 사용하기
		tv1.power = true;
		tv2.channel = 7;
		tv2.channelUp();
		tv2.channelDown();
		
		//부모의 메소드가 아니라 자식의 메소드가 실행되고 싶을 때
		/*
		 * 1. 오버라이딩 된 것은 자식의 메소드가 수행된다. 
		 */
		tv1.channelUp();
		tv1.channelDown();
		
		/*
		 * 2. 자식의 순수한 메소드를 수행하기
		 */
//		tv1.text = "홍길동"; 
		//순수 자식 클래스의 필드에 접근 불가
//		tv1.captionTVMethod (); 
		//순수 자식 클래스의 메소드에 접근 불가
		CaptionTV ct = (CaptionTV) tv1;
		//자식 클래스 타입의 변수에 부모타입의 참조변수를 넣는다. 
		//그런데, 타입이 맞지 않으므로, 형변환을 시켜준다. 
		ct.text = "홍길동";
		ct.captionTVMethod();
		
		//접근 부분에 있어서, 기능적인 부분에있어서는 다형성과 상속과 차이가 없다.
		//비지니스 로직부분에서 다형성의 목적이 나온다. 
		TV tv3 = new CaptionTV();
//		TV tv3 = new TV(); // 문법상에서는 오류가 없으나, 런타임할때 메모리에 올라갈때 오류가 남
		CaptionTV ct2 = (CaptionTV) tv3;
		ct2.text = "이순신";
		ct2.captionTVMethod();
		// 71~74 라인 : 오류가 난다. 왜? 71번째 줄에서 heap에는 TV()만 갔기때문이다.
		//그러므로 71번 대신 70번 처럼 new Caption()을 해줘야한다.
		
		
		CaptionTV ct3 = new CaptionTV();
		ct3.text = "홍길동";
		ct3.captionTVMethod();
		
		//상속하여 접근한 것과 70~74와 기능적으로 다른 점은 없다. 
		//하지만, 다형성을 사용하는 이유는 따로 있다. 
		//필드의 다형성, 매개변수의 다형성을 위한것이다.
		
		
	}
}