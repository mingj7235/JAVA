package pracJAVA1203;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeOperEx {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		LocalDate nowDate = LocalDate.now();
		System.out.println("현재 날짜 시간 :" + now);
		System.out.println("내가이김ㅇㅇ");
		LocalDateTime targetDateTime = now.plusYears(1)
				.minusMonths(2)
				.plusDays(3)
				.plusHours(4)
				.minusMinutes(5)
				.plusSeconds(6);
		System.out.println("연산 후 : "  +targetDateTime);
		
		LocalDateTime targetDateTime1 = now.plusDays(3);
		System.out.println("유통기한이 끝나는 날"+ targetDateTime1);
		LocalDateTime returnBookDate = now.plusDays(3);
		System.out.println("책 반납기간 : " + returnBookDate + "일까지입니다.");
				
					
	}
}
