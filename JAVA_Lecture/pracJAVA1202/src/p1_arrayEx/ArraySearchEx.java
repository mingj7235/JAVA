package p1_arrayEx;

import java.util.Arrays;

public class ArraySearchEx {
	public static void main(String[] args) {
		//기본 타입값 검색
		int [] scores = {99,97,98};
		Arrays.sort(scores);
		int index = Arrays.binarySearch(scores, 99);
//		System.out.println("찾은 인덱스 : " + index); //2 정렬하면 99가 맨뒤로감
//		System.out.println(scores[index]); //값 도출
		
		int indexError = Arrays.binarySearch(scores, 100);
//		System.out.println("에러 인덱스 : " + indexError);
//		System.out.println(scores[indexError]);
		//찾는 인덱스가 없으면 음수가 나온다.
		
		//문자열 검색
		String [] names = {"홍길동", "박동수", "김민수"};
		Arrays.sort(names);
		index = Arrays.binarySearch(names, "홍길동");
//		System.out.println("찾은 인덱스 : " + index);
		
		//객체검색
		Member m1 = new Member("홍길동", "123456");
		Member m2 = new Member("박동수", "324241");
		Member m3 = new Member("김민수", "235352");
		Member [] members = {m1,m2,m3};
		Arrays.sort(members);
		index = Arrays.binarySearch(members, m1);
		System.out.println("찾은 인덱스 : " + index);
		System.out.println(members[index].name + "  " + members[index].num);
	}
}
class Member implements Comparable<Member>{
	String name;
	String num;
	public Member(String name, String num) {
		this.name = name;
		this.num = num;
	}
	@Override
	public int compareTo(Member o) {
		return name.compareTo(o.name);
	}

	
}
