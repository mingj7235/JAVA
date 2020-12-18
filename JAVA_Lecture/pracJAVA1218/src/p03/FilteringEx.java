package p03;

import java.util.Arrays;
import java.util.List;

public class FilteringEx {
	public static void main(String[] args) {
		List <String>names = Arrays.asList("홍길동", "홍길동", "신용권", "김자바", "신용권", "두자");
		
		names.stream().distinct().forEach(n ->System.out.println(n));
		names.stream().filter(n->n.startsWith("신")).forEach(System.out::println);
		names.stream().filter(n->n.endsWith("동")).forEach(System.out::println);
		names.stream().filter(n->n.length() !=3).forEach(System.out::println);
		names.stream().filter(n->n.charAt(1) =='용').forEach(System.out::println);
		names.stream().filter(n->n.contains("바")).forEach(System.out::println);
	
				
	}
}
