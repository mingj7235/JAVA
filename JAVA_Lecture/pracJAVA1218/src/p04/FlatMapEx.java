package p04;

import java.util.Arrays;
import java.util.List;

public class FlatMapEx {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("java8 lambda", "stream mapping");
		list.stream().flatMap(data -> Arrays.stream(data.split(" "))).forEach(word -> System.out.println(word));
		
		List<String> days = Arrays.asList("2020/10/05", "1999/05/25");
		days.stream().flatMap(data -> Arrays.stream(data.split("/"))).forEach(word -> System.out.println(word));
		
		List <String> dlist = Arrays.asList("1.1, 2.2, 3.3", "2.2, 3.3, 4.4");
		dlist.stream().flatMapToDouble(data-> {
				String [] strArr = data.split(",");
				double [] doubleArr = new double [strArr.length];
				for (int i = 0; i < strArr.length; i++) {
					doubleArr [i] = Double.parseDouble(strArr[i].trim());
				}
				return Arrays.stream(doubleArr);
		})
		.forEach(n -> System.out.print(n + " "));
	}
}
				
