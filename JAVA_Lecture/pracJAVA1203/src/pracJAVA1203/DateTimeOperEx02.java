package pracJAVA1203;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateTimeOperEx02 {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("현재 : " + now);
		
		LocalDateTime tarDateTime = null;
		tarDateTime = now.withYear(2024);
		System.out.println(tarDateTime);
		//with ~ 는 직접변경임
		tarDateTime = now.with(TemporalAdjusters.firstDayOfNextYear());
		System.out.println(tarDateTime);
		tarDateTime = now.with(TemporalAdjusters.lastDayOfYear());
		System.out.println(tarDateTime);
		tarDateTime = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY));
		System.out.println(tarDateTime);
		
		System.out.println(); 
		
		LocalDate nowDate = LocalDate.now();
		LocalDate tarDate = null;
		tarDate = nowDate.with(TemporalAdjusters.firstDayOfNextYear());
		System.out.println(tarDate);
		tarDate = nowDate.with(TemporalAdjusters.lastDayOfYear());
		System.out.println(tarDate);
	}
}
