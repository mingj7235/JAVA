package Q13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateprintEx {
	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분");
		System.out.println(sdf.format(now));
	}
}
