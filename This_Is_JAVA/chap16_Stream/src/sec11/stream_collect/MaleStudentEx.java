package sec11.stream_collect;

import java.util.Arrays;
import java.util.List;

public class MaleStudentEx {
	public static void main(String[] args) {
		List <Student> totalList = Arrays.asList(
				new Student ("홍길동", 10, Student.Sex.MALE),
				new Student ("김수애", 6, Student.Sex.FEMALE),
				new Student ("신용권", 10, Student.Sex.MALE),
				new Student ("박수미", 6, Student.Sex.FEMALE)
		);
		
		MaleStudent maleStudent = totalList.stream()
			.filter(s -> s.getSex() == Student.Sex.MALE)
			.collect(
					() -> new MaleStudent(), //사용자 정의 컨테이너를 생성함. 람다식으로
					(r, t) -> r.accumulate(t), //r : 사용자 정의 컨테이너 / t : 필터링된 요소들. 즉, r에 t를 누적시키는 것임
															//accumulate는 r이가지고 있는 메소드. 누적 하는 것임. 
					(r1, r2) -> r1.combine(r2)); //컨테이너를 합치는 것이기때문에 r1, r2가 매개임. 하지만 싱글에서는 필요없음. 그러나 만들어야함.
																//병렬처리를 위해서 꼭필요함. 싱글에서는 필요없으나, 지정하지 않으면 안댐
		
		//collect는 MaleStudent 타입을 리턴함
		
		maleStudent.getList().stream()
			.forEach(s ->System.out.println(s.getName()));
		
	}
}
