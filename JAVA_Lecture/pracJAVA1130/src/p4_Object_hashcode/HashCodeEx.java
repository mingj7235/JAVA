package p4_Object_hashcode;

import java.util.Objects;

public class HashCodeEx {
	public static void main(String[] args) {
		Student s1 = new Student (1,"홍길동");
		Student s2 = new Student (1,"홍길동");
		Student s3 = null;
		
		//hashCode 메소드를 student 클래스에서 override했다.
		//return을 Objects클래스의 hash메소드를 리턴하도록했음
		
		System.out.println(s1.hashCode()); //Object 클래스의 해쉬코드 함수
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());

		System.out.println(Objects.hashCode(s1));//Objects 클래스 사용
		System.out.println(Objects.hashCode(s2));
		System.out.println(Objects.hashCode(s3));// 0 리턴
	}
}
