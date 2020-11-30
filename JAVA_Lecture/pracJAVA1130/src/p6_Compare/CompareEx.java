package p6_Compare;

import java.util.Comparator;
import java.util.Objects;

public class CompareEx {
	//객체 비교하기
	public static void main(String[] args) {
		
		//김명수, 홍지연
		
		Student s1 = new Student(3, "홍지연");
		Student s2 = new Student(5, "김명수");
		Student s3 = new Student(2, "최수진");
		
		int result = Objects.compare(s1, s2, new StudentComparator());
		if (result == 0) System.out.println("s1과 s2가 같은번호");
		else if (result <0) System.out.println("s1과 s2의 앞번호");
		else System.out.println("s1과 s2의 뒷번호");
		
	}
	static class Student {
		int sno;
		String name;
//		public Student(int sno) {
//			this.sno = sno;
//		}
		public Student(int sno, String name) {
			this.sno = sno;
			this.name = name;
		}
	}
	static class StudentComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			return o1.name.compareTo(o2.name);// 문자열 자료비교
		}
		
		
		
//		@Override
//		public int compare(Student o1, Student o2) {
//			if (o1.sno < o2.sno) return -1;
//			else if (o1.sno == o2.sno) return 0;
//			else return 1;
//		}
		
//		@Override
//		public int compare(Student o1, Student o2) {
//
//			return Integer.compare(o1.sno, o2.sno);
//		}
		
	}
}//end CompareExample



