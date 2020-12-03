package pracJAVA1203;

import java.time.LocalDateTime;

public class DateTimeOperEx02 {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("ÇöÀç : " + now);
		
		LocalDateTime tarDateTime = null;
		tarDateTime = now.withYear(2024);
		
		System.out.println(tarDateTime);
	}
}
