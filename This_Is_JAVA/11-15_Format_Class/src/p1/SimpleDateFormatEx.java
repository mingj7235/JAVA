package p1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatEx {
	/*Date 클래스의 toString () 메소드는 영문으로된 날짜를 리턴한다.
	 * 만약 특정 문자열 포맷으로 얻고 싶다면 ajva.text.SimpleDateFormat클래스를 이용하면 된다. 
	 * SimpleDateFormat 클래스도 날짜를 원하는 형식으로 표현하기 위해 패턴을 사용한다.
	 * 
	 * 
	 */
	public static void main(String[] args) {
//		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy년 MM월 dd일");
//		String strDate = sdf.format(new Date());
//		System.out.println(new Date());
//		System.out.println(strDate);
		
		Date now = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(sdf.format(now));
		
		sdf = new SimpleDateFormat("오늘은 E요일");
		System.out.println(sdf.format(now));
	}
	
	
	
	
}
