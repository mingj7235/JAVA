package p5_tostring;

import java.util.Date;

public class CardToString {
	public static void main(String[] args) {
		Card card = new Card();
		System.out.println(card.toString());
		Date date = new Date();
		System.out.println(date.toString());
		String name = "이순신";
		String name1 = new String("이순명");
		System.out.println(name.toString());
		System.out.println(name1.toString());
	}
}
