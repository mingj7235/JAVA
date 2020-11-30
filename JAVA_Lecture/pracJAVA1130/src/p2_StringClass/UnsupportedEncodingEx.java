package p2_StringClass;

import java.io.UnsupportedEncodingException;

public class UnsupportedEncodingEx {
	public static void main(String[] args) {
		String str = "안녕하세요.";
		//기본문자셋
		//2진수 배열로 바꾼것은 시스템 파일로 만들거나 네트워크로 보낼 때 사용함
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
		
	}
}
