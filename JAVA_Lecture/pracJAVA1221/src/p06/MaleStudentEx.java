package p06;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import p05.Student;

public class MaleStudentEx {
	public static void main(String[] args) {
		List<Student> totalList=Arrays.asList(
				new Student("홍길동", 10, Student.Sex.MALE,Student.City.PUSAN),
				new Student("김수애", 6, Student.Sex.FEMALE,Student.City.SEOUL),
				new Student("신용권", 10, Student.Sex.MALE,Student.City.PUSAN),
				new Student("박수미", 6, Student.Sex.FEMALE,Student.City.SEOUL), 
				new Student("박수호", 6, Student.Sex.MALE,Student.City.SEOUL) 
				
				);
//		Stream <Student> totalStream = totalList.stream(); //오리지날 스트림
//		Stream <Student> totalStream = totalList.parallelStream(); //병렬 스트림
//		Stream <Student> maleStream =totalStream.filter(s->s.getSex() == Student.Sex.MALE);
//		Supplier <MaleStudent> supplier = () -> new MaleStudent();
//		BiConsumer<MaleStudent, Student> accumulator = (m,s) ->m.accumulate(s);
//		BiConsumer<MaleStudent, MaleStudent> combine = (ms1, ms2) -> ms1.combine(ms2);
//		
//		MaleStudent maleStudent = maleStream.collect(supplier, accumulator, combine);
//		System.out.println(maleStudent + " ~~~");
		
		//2. 람다식 표현
//		MaleStudent maleStudent = totalList.parallelStream()
//				.filter(s ->s.getSex() == Student.Sex.MALE)
//				.collect(() -> new MaleStudent(),
//						(m,s)->m.accumulate(s),
//						(ms1,ms2) ->ms1.combine(ms2)
//						);
//		
//		System.out.println(maleStudent.getList());
		
		//3. 메소드 참조로 표현
		MaleStudent maleStudent = totalList.parallelStream()
				.filter(s->s.getSex() ==Student.Sex.MALE)
				.collect(MaleStudent :: new, MaleStudent :: accumulate, MaleStudent :: combine);
		
		
		
		
	} 
}
