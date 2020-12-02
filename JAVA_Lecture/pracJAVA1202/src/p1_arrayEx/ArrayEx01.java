package p1_arrayEx;

import java.util.Arrays;

public class ArrayEx01 {
	public static void main(String[] args) {
		Members m1 = new Members(1, "홍길동", "123");
		Members m2 = new Members(2, "박길동", "234");
		Members m3 = new Members(3, "김길동", "567");
		Members m4= new Members(4, "조길동", "567");
		Members [] members = {m1,m2,m3,m4};
		Arrays.sort(members);
		
		for (Members m : members) {
			System.out.println(m);
		}
		
		
		
//		int [] scores = {99,98,87,100};
//		double [] avg = {4.5, 1.2, 100, -10.0};
//		String [] stringArr = {"김수진", "김미", "박수진", "황수연"};
//		for (int  s : scores) {
//			System.out.print(s + "  ");
//		}
//		System.out.println();
//		System.out.println("sort 후 ___");
//		Arrays.sort(scores);
//		for (int s : scores) {
//			System.out.print(s + "   ");
//		}
//		
//		Arrays.sort(avg);
//		Arrays.sort(avg);
//		System.out.println();
//		for (double s : avg) {
//			System.out.print(s + "   ");
//		}
//		System.out.println();
//		Arrays.sort(stringArr);
//		for (String s : stringArr) {
//			System.out.print(s + "  ");
//		}
		
	}
}
//개발 (프로그래머)가 정렬할 기준을 정해주는 프로그램 작성
class Members implements Comparable<Members> {
	int sno;//번호
	String sname;//회원이름
	String stel;//전화번호
	
	@Override
	public String toString() {
		return sno + "  " + sname + "   " + stel;
	}
	
	public Members() {

	}
	
	public Members(int sno, String sname, String stel) {
		this.sno = sno;
		this.sname = sname;
		this.stel = stel;
	}

	//이름 순서대로 정렬됨 즉, 기준을 정해주는 것임
//	@Override
//	public int compareTo(Member o) {
//		return sname.compareTo(o.sname);
//	}
	
	//전화번호 순서로 정렬
	@Override
	public int compareTo(Members o) {
		return stel.compareTo(o.stel);
	}
	
	
	
	
	
	
	
	
	
}
