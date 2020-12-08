package sec05.exam03_comparable;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparableEx {
	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<>();
		
		treeSet.add(new Person("홍길동", 45));
		treeSet.add(new Person("감자바", 25));
		treeSet.add(new Person("박지원", 31));
		
		Iterator <Person> iterator = treeSet.iterator();
		
		while (iterator.hasNext()) { //저장을 한순서와, 실제로 저장한 순서가 다르다. 왜 ? compareTo() 메소드로 저장기준을 나눴으니까!
			Person person = iterator.next();
			System.out.println(person.name + " : " +person.age);
		}
		
	}
}
