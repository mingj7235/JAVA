package pracJAVA1203;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateTimeinfoEX {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("현재 날짜 : " + now);
		
		String strDateTime = now.getYear() + "년";// 누적하는것임
		strDateTime += now.getMonth() + "월";
		strDateTime += now.getDayOfMonth() + "일";
		strDateTime += now.getDayOfWeek() + " ";
		strDateTime += now.getHour () + "시";
		strDateTime += now.getMinute() + "분";
		strDateTime += now.getSecond() + "초";
		strDateTime += now.getNano() + "나노쵸";
		
		System.out.println(strDateTime);
		
		LocalDate nowDate = now.toLocalDate(); 
		//now 변수가 날,시간 모두 포함하는 클래스인데 이걸 날만 포함하는 걸로 ㄱ변환시킴
		if (nowDate.isLeapYear()) {
			System.out.println("올해는 윤년 : 2월은 29일까지 있습니다.\n");
		}else {
			System.out.println("올해는 평년 : 2월은 28일까지만 있음");
		}
		
		//협정 세계시와 존 오프셋
		ZonedDateTime utcDateTime = ZonedDateTime.now (ZoneId.of("UTC"));
		System.out.println("협정 세계시 : " + utcDateTime);
		ZonedDateTime seoulDateTime = ZonedDateTime.now (ZoneId.of("Asia/Seoul"));
		System.out.println("서울 타임존 : " + seoulDateTime);
		ZoneId seoulZonedID = seoulDateTime.getZone();
		System.out.println("서울 존 아이디 : " + seoulZonedID);
		ZoneOffset seoulZoneOffset = seoulDateTime.getOffset();
		System.out.println("서울 존 오프셋 :" + seoulZoneOffset + "\n");
		
		
		
				
		
		
		
	}
}	
