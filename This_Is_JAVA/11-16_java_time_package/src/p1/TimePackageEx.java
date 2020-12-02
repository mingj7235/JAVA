package p1;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimePackageEx {
	public static void main(String[] args) {
		//Time Package는 자바 1.8버전 이후부터 API에서 지원해줌 
		
		//날짜 얻기
		
		LocalDate currDate = LocalDate.now(); 
		System.out.println("Local date : " + currDate);
		
		LocalDate targetDate = LocalDate.of(2024, 5, 12);
		System.out.println("2024년 5월 12일 : "+targetDate);
		
		//시간 얻기
		LocalTime currTime = LocalTime.now();
		System.err.println("현재시간 : " + currTime);
		
		LocalTime targetTime = LocalTime.of(6, 30);
		System.out.println(targetTime);
		
		//날짜와 시간 얻기
		
	}
}
