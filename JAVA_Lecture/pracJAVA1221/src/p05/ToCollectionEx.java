package p05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToCollectionEx {
	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
				new Student ("홍길동", 10, Student.Sex.MALE),
				new Student ("김수애", 6, Student.Sex.FEMALE),
				new Student ("신용권", 10, Student.Sex.MALE),
				new Student ("박수미", 6, Student.Sex.FEMALE)
				);
		
		//남학생들만 묶어서list생성
		
		List<Student> maleList = totalList.stream().filter(n-> n.getSex()==Student.Sex.MALE)
					.collect(Collectors.toList());
		System.out.println(maleList);
		
		//여학생만 묶어서 set 생성
		Set <Student> femaleSet = totalList.stream().filter(s -> s.getSex() == Student.Sex.FEMALE)
								.collect(Collectors.toCollection(HashSet::new));
		//forEach로 찍기
		femaleSet.stream().forEach(s -> System.out.println(s));
		//iterator로 찍기
		Iterator<Student> iter = femaleSet.iterator();
		while(iter.hasNext()) {
			Student st = iter.next();
			System.out.println(st.getSex());
		}
			
		
	}
}
