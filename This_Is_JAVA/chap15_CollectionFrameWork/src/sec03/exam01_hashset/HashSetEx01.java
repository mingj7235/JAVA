package sec03.exam01_hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx01 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String> ();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("iBATIS");
		
		System.out.println("총 객체수 : " + set.size()); //4임 왜? 중복된 것은 추가도안되므로  
		
		Iterator <String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		
		set.remove("JDBC");
		set.remove("iBATIS");
		System.out.println("총 객체수 : " + set.size());   
		
		for (String element : set) {
			System.out.println("\t" + element);
		}
		
		set.clear(); //set컬렉션의 모든 값 제거
		if(set.isEmpty()) {
			System.out.println("set 컬렉션은 비어 있음");
		}
		
	}
}
