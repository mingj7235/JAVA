package p6_Calendar;

import java.util.Calendar;

public class CalendarEx {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		//getInstance () -> 싱글톤패턴 
		System.out.println(now);
		int year = now.get(Calendar.YEAR); //year는 1의 상수값을 가짐
		int yearNum = now.get(1); 
		System.out.println(year);
		System.out.println(yearNum);
		int month = now.get(Calendar.MONTH); // month 는 2의 상수값이 나옴
		int monthNum = now.get(2);
		System.out.println(month+1);
		System.out.println(monthNum+1);
		
		int week = now.get(Calendar.DAY_OF_WEEK);
		System.out.println(week); //수요일은 4
		System.out.println(Calendar.MONDAY); //월요일은 2 //일요일은 1 숫자를 리턴함. 그래서 비교가능
		if (week==Calendar.MONDAY) {
			System.out.println("월요일");
		}else {
			System.out.println("월요일 아님");
		}
		
		int am_pm = now.get(Calendar.AM_PM);
		System.out.println(am_pm);
		System.out.println(Calendar.AM_PM);
		System.out.println(Calendar.AM);
		System.out.println(Calendar.PM);
		
		//오전인지 오후인지 나타내는 프로그램
		if (Calendar.AM == now.get (Calendar.AM_PM))
			System.out.println("오전입니다.");
		else 
			System.out.println("오후입니다.");
		
		System.out.println(now.get(Calendar.HOUR) + "시" + now.get(Calendar.MINUTE) + "분" 
								+ now.get(Calendar.SECOND) + "초");
		System.out.println(now.get(10) + " 시" + now.get(12) + " 분" + now.get(13) +" 초"); 
		
	}
}
