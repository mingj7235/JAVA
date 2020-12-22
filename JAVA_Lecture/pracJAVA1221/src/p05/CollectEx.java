package p05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectEx {
	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
				new Student ("ȫ�浿", 10, Student.Sex.MALE),
				new Student ("�����", 6, Student.Sex.FEMALE),
				new Student ("�ſ��", 10, Student.Sex.MALE),
				new Student ("�ڼ���", 6, Student.Sex.FEMALE)
				);
		
		//���л��鸸 ���list����
		
		List<Student> maleList = totalList.stream().filter(n-> n.getSex()==Student.Sex.MALE)
					.collect(Collectors.toList());
		
		
		System.out.println(maleList);
		
		int maleScoreSum = maleList.stream().mapToInt(Student::getScore).sum();
		System.out.println(maleScoreSum);
		
		List <Student> femaleList = totalList.stream().filter(n -> n.getSex() == Student.Sex.FEMALE)
					.collect(Collectors.toList());
		
		List <Student> Seoul =totalList.stream().filter(s -> s.getCity() == Student.City.SEOUL).collect(Collectors.toList());
	
		List <Student> scoreList =totalList.stream().filter(n -> n.getScore()>=8).collect(Collectors.toList());
		scoreList.stream().forEach(System.out :: println);
		
	}
}