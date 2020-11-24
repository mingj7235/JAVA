package day35_Date_Calendar;

import java.util.Calendar;
import java.util.Scanner;

public class Calendarr {
	//년 월 입력받고 달력 출력
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calendar c = Calendar.getInstance();
		int year = 0;
		int month = 0;
		
		do {
			System.out.println("보고싶은 달력의 년, 월을 입력하세요.");
			year = sc.nextInt();
			month = sc.nextInt();
			if (year > 0 && month > 0 && month < 13) { //잘 입력했을 때 break;
				break;
			} else {
				System.out.println("다시 입력하셈");
			}
		}while (true);
		
		c.set(year, month-1, 1);
		//년, 월, 일
		
		int lastDay = c.getActualMaximum(c.DAY_OF_MONTH);
								//달의 마지막 날을 구해주는 메서드임.
		int weekDay = c.get(Calendar.DAY_OF_WEEK);
		
		System.out.println("                 " + year + "년 " + month + "월");
		System.out.println("============================");
		System.out.println(" 일     월     화     수     목     금     토 ");
		
		
		for (int i = 0; i < weekDay-1; i++) {
			//day_of_week이 1부터 시작하기때문에 (weekDay) -1 해준것임. 
			if(i==0) { 
				System.out.print("                 ");
			}else {
				System.out.print("    ");
			}
		}
		for (int i = 1; i < lastDay+1; i++) {
			System.out.printf("  %02d ", i);
						//%02d : 앞에 0이 붙고 2자리의 정수로 출력해줌
			if (weekDay % 7 == 0) {
				System.out.println();
			}
			weekDay++;
			//weekday가 상수기때문에 ++를 해서 증가시켜야한다. 
		}
		System.out.println("\n============================");
		
	}
}
