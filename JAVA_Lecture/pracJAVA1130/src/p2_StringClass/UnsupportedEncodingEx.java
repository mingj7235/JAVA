package p2_StringClass;

import java.io.UnsupportedEncodingException;

public class UnsupportedEncodingEx {
	public static void main(String[] args) {
		String str = "안녕하세요요.";
		//기본문자셋
		//2진수 배열로 바꾼것은 시스템 파일로 만들거나 네트워크로 보낼 때 사용함
		int i = str.indexOf("요");
		//indexOf() 메소드는 매개변수의 글자가 문자열에 있는지 판단하여 있으면 해당 문자열의 인덱스번호를 리턴한다.
		//문자가 중복된 경우는 가장 앞의 index를 리턴한다. 
		//해당하는 문자가 없으면 -1을 리턴한다.
		System.out.println(i);
		
		byte [] bytes1 = str.getBytes();//인코딩 10진수 --> 2진수 byte[]
		System.out.println(bytes1.length);
		for (byte b : bytes1) {
			System.out.print(b+ " ");
		}
		String str1 = new String(bytes1);//2진수 배열 --> 10진수
		System.out.println("\n" +str1);
		
		//한글 완성형으로 인코딩 디코딩
		
		try {
			byte [] bytes2 = str.getBytes("UTF-8");
			System.out.println(bytes2.length);
			for (byte b : bytes2) {
				System.out.print(b+ " ");
			}
			String str2 = new String(bytes2, "UTF-8");//2진수 배열 --> 10진수
			System.out.println("\n" +str2);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String rstr = str.replace('안', '감');
		//안 -> 감 으로 변경함. 문자를 변경하는 것임
		System.out.println(rstr);
	
		String rstra = str.replaceAll("안녕", "수고수고");
		//String으로 받고, 변경함 ex) 안녕하세요 -> 수고하세요
		System.out.println(rstra);
		
		String subs = str.substring(3);
		//해당하는 인덱스부터(포함) 끝까지를 출력함
		System.out.println(subs);
		
		String subs2 = str.substring(0, 2);
		//두번째 매개변수는 포함되지 않는다. 즉 0,1 번 인덱스까지만 출력됨
		//substring(0,2) 이면, 0~1번 인덱스의 값만 출력됨
		System.out.println(subs2);
		
		//trim 메소드는 이해못함 놓쳤음 ㅠ
		
		String strr = "          띄어 쓰기            ";
		System.out.println(strr.length());
		
		int ii = 10;
		double dd =10.24;
		
		
		String sii = String.valueOf(ii); // 인트형 10 이 문자형 "10"이 된것임
		String sdd = String.valueOf(dd); //더블형 10.24가 문자형 10.24가 된것임
		
		System.out.println(ii + dd); //숫자니까 연산
		System.out.println(sii + sdd); //문자니까 연결 
		
		//어떤 자료든 문자열로 고쳐서 처리하고싶으면 valueOf 메소드 쓰면됨 개쩌네;
		
		Car c = new Car ();
		String sc= String.valueOf(c); //이것도 쌉가능 왜? api에 매개변수가 Object obj 가 있기 때문임
		System.out.println(sc);
		
	}
}

class Car {
	
}
