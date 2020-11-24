package day25Prac;

public class ObjectTest2 {
	
	int data1 = 10;
	int data2 = 20;
	int data3 = 30;
	
	public ObjectTest2(int data1, int data2) {
		this.data1 = data1;
		this.data2 = data2;
	}
	
	@Override
	public String toString() {
		String result =""+ (data1 + data2 + data3);
		return result;
	}
	
	public static void main(String[] args) {
		ObjectTest2 o = new ObjectTest2(90, 80);
		System.out.println(o);
//		System.out.println(o.toString());
		//객체명을 출력할 때 항상 뒤에 toString ()이 생략된다. 
		char [] arWord = {'안', '녕'};
		System.out.println(arWord);
		System.out.println(arWord.toString());
		int [] arNum = {1,2,3};
		System.out.println(arNum);
		System.out.println(arNum.toString());
		//배열명을 출력하면 원래는 시작주소가 나온다. 
		//왜냐하면 배열은 heap 메모리에 저장되기 때문이다. 
		//그런데 어떻게 arWord을 출력했는데 '안녕' 이 나오는가? 
		//원래 String이라는 타입은 없다. 단지 char의 열로 만든 타입이다. 
		//그래서 선배개발자들이 char 타입의 배열을 출력하면 바로 문자열이 출력하도록 한것이다. 
		//주소값을 보려면 .toString을 써야한다. char 배열만 유일하게 가진다. 왜? 값을 출력할때를 더 많이 사용했으니까!
		//그러므로 arWord는 toString을 붙여줘야 주소를 뽑을 수 있다. 
		
		String data = "1.2.3.4.5.6.";
		System.out.println(data.substring(3));
		//자르는 String 안에있는 메서드
		
		
	}
}
