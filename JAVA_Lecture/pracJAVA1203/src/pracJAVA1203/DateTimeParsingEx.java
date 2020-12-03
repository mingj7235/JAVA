package pracJAVA1203;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeParsingEx {
	public static void main(String[] args) {
		DateTimeFormatter formatter;
		LocalDate localDate;
		
		localDate = LocalDate.parse("2024-05-21");
		System.out.println(localDate);
	}
}
