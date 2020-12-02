package p5_date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {
	public static void main(String[] args) {
		
		Date now = new Date ();
		String strNow1 = now.toString();
		System.out.println(strNow1);
		System.out.println(now);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strNow2 = sdf1.format(now);
		System.out.println(strNow2);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("EEE요일 MMM d, ''yy"); 
		String strNow3 = sdf2.format(now);
		System.out.println(strNow3);
		
		//365일중에서 오늘이 몇일째?
		SimpleDateFormat todaycnt = new SimpleDateFormat("365일중에서 오늘은 D일째 입니다.");
		String strNow4 = todaycnt.format(now);
		System.out.println(strNow4);
	}
}
