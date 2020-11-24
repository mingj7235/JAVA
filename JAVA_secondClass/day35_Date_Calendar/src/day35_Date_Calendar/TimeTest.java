package day35_Date_Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TimeTest {
	public static void main(String[] args) {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E) HH:mm:ss.SSS");
		String dOfWeek [] = {"일", "월", "화", "수", "목", "금", "토"};
		//simpledateformat 생성자에는 원하는 양식을 넘겨주면된다
		
		
		//싱글턴패턴 Calendar의 객체는 하나뿐이다. 
		//date는 new가 된다. 말이안된다. 그래서 구식이다. 하지만 옛날 회사에서 쓰기때문에 알아야한다. 
		//추새는 date에서 calendar로 바뀌는 추세다
		
		//Calendar 클래스는 singleton 패턴으로 설계된 클래스로 객체를 만들어 사용할 수 없다.
		//객체를 만들어서 사용할 수 없는 클래스는 내부에 자신의 클래스로 만든 객체를 포함하고 있기 때문에
		//클래스 내부에 가지고 있는 자신의 객체를 얻어오는 메소드로(getInstance()) 자신의 객체를
		//얻어와서 사용한다. 
		
		//singleton 패턴으로 설계하는 클래스는 프로그램에서 딱 1개만 필요한 객체를
		//singleton 패턴으로 설계한다. 
		//Calendar의 DAY_OF_WEEK는 일요일 (1), 월요일(2),,....,토요일(7) 이다.
		//Calendar에서 지정되어 있는 함수로 월을 구할 때에는 1을 더해줘야한다. 
		// => 요일은 1부터 시작하고(일요일은 1), 월은 0부터 시작한다 (1월은 0)
		System.out.println(d);
		System.out.println(c);
		System.out.println(sdf.format(c.getTime()));
		System.out.println("년 : "+ c.get(Calendar.YEAR));
		//Calendar 클래스로 직접 접근해야한다 (싱글턴)
		System.out.println("월 :" +(c.get(Calendar.MONDAY)+1));
		// 월은 1을 더해줘야한다. (27번째 줄 설명)
		System.out.println("일 : "+c.get(Calendar.DATE));
		System.out.println("일 : " + c.get(Calendar.DAY_OF_MONTH));
		System.out.println("요일 : "+ c.get(Calendar.DAY_OF_WEEK));
		
		System.out.println(dOfWeek[c.get(Calendar.DAY_OF_WEEK)-1] + "요일");
		//-1을 해줘야한다. 인덱스는 0부터 시작하고, day of week 은 1부터 시작하니깐.
		System.out.println("시 : " + c.get(Calendar.HOUR));
		System.out.println("시 : " + c.get(Calendar.HOUR_OF_DAY)); //24시간 기준
		System.out.println("분 : " + c.get(Calendar.MINUTE));
		System.out.println("초 : " + c.get(Calendar.SECOND));
		System.out.println("밀리초 : " + c.get(Calendar.MILLISECOND));
		
		//Date 클래스는 1900년을 기준으로 날짜를 처리한다.
		//년을 얻어 오려면 1900년을 더해서 얻어와야하고, 넣어주려면 1900을 빼서 넣어줘야한다.
		//월을 얻어오려면 1을 더해서 얻어와야하고, 넣어주려면 1을 빼서 넣어야 한다. 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("년 월 일 : ");
		int year = sc.nextInt()-1900;
		//년도는 1900을 빼줘야한다.
		int month = sc. nextInt()-1;
		//월을 입력받을 때는 1을 빼줘야한다. 
		int day = sc.nextInt();
		
		Date date = new Date(year, month, day);
		//date를 쓰지말라고 밑줄이 그어져있다. 하지만 이미 회사에서 많이 쓰고있어서 알고는있어야한다.
		//calendar 쓰라고 이렇게 밑줄 그어놓은거임. new를 쓴다는거 자체가 말이안되는 것임
		System.out.println(date);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd(E)");
		System.out.println(sdf2.format(date));
		
		
		
		
	}
	
}
