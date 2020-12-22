package p03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {
	public static void main(String[] args) {
		Student [] strArr = {
				new Student("나자바", true, 1, 1, 300), 
				new Student("김지미", false, 1, 1, 250), 
				new Student("김자바", true, 1, 1, 200), 
				new Student("이지미", false, 1, 2, 150), 
				new Student("남자바", true, 1, 2, 100), 
				new Student("안지미", false, 1, 2, 50), 
				new Student("황지미", false, 1, 3, 100), 
				new Student("강지미", false, 1, 3, 150), 
				new Student("이자바", true, 1, 3, 200), 
				
				new Student("나자바", true, 2, 1, 300), 
				new Student("김지미", false, 2, 1, 250), 
				new Student("김자바", true, 2, 1, 200), 
				new Student("이지미", false, 2, 2, 150), 
				new Student("남자바", true, 2, 2, 100), 
				new Student("안지미", false, 2, 2, 50), 
				new Student("황지미", false, 2, 3, 100), 
				new Student("강지미", false, 2, 3, 150), 
				new Student("이자바", true, 2, 3, 200) 
		};
		
		System.out.println("1. 단순한 그룹화 (반별로 그룹화)");
		
		Map<Integer, List<Student>> stuByBan = Arrays.stream(strArr)
				.collect(Collectors.groupingBy(Student::getBan));
		
		for(List<Student> ban : stuByBan.values()) {
			for (Student s : ban) {
				System.out.println(s);
			}
		}
		
		System.out.println("2.성적별로 그룹화 - 조건 : 점수가 200이상이면 HIGH, 100점이상 MID, 이외 LOW");
		
		Map<Student.Level, List<Student>> stuByLevel = Stream.of(strArr)
				.collect(Collectors.groupingBy(s->{
					if(s.getScore() >=200) return Student.Level.HIGH;
					else if (s.getScore() >= 100 ) return Student.Level.MID;
					else return Student.Level.LOW;
				}));
		
		TreeSet <Student.Level> keySet = new TreeSet<> (stuByLevel.keySet());
	
		for(Student.Level key : keySet) {
			System.out.println("[ " + key + " ]");
			for (Student s : stuByLevel.get(key)) {
				System.out.println(s);
			}
		}
		
		System.out.println("3.단순한 그룹화 + 통계 (성적별 학생수)");
		Map<Student.Level, Long> stuCntByLevel = Stream.of(strArr)
				.collect(Collectors.groupingBy(s-> {
					if(s.getScore() >=200) return Student.Level.HIGH;
					else if (s.getScore () >= 100) return Student.Level.MID;
					else return Student.Level.LOW;
				}, Collectors.counting()
				));
		for(Student.Level key : stuCntByLevel.keySet()) {
			System.out.println(" " + key + " " + stuCntByLevel.get(key) + " 명");
		}
		
		System.out.println("4. 다중 그룹화 + 통계 (학년별, 반별)");
		Map<Integer, Map<Integer, List<Student>>> stuByHakAndBan =
				Stream.of(strArr)
				.collect(Collectors.groupingBy(Student::getHak,
							Collectors.groupingBy(Student::getBan)					
						));
		
		for (  Map<Integer, List<Student>> hak : stuByHakAndBan.values() ) {
			for ( List <Student> ban : hak.values() ) {
				System.out.println();
				for (Student s : ban) {
					System.out.println(s);
				}
			}
		}
		
		System.out.println("5. 다중 그룹화 + 통계 (학년별, 반별 1등");
		
		Map<Integer, Map<Integer, Student>> topStuByHakAndBan =
				Stream.of(strArr)
				.collect(Collectors.groupingBy(Student :: getHak,
						Collectors.groupingBy(Student :: getBan,
								Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Student :: getScore)), 
										Optional :: get))
						));
		for(Map<Integer, Student> ban : topStuByHakAndBan.values()) {
			for(Student s : ban.values()) {
				System.out.println(s);
			}
		}
		
		System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
		Map<String, Set<Student.Level>> stuByScoreGroup = 
				Stream.of(strArr)
				.collect(Collectors.groupingBy(s -> s.getHak()+"-"+s.getBan(),
						Collectors.mapping(s -> {
							if(s.getScore() >= 200) return Student.Level.HIGH;
							else if (s.getScore() >= 100) return Student.Level.MID;
							else return Student.Level.LOW;
						}, Collectors.toSet())
						));

		for(String key : stuByScoreGroup.keySet()) {
			System.out.println("["+key+"]"+stuByScoreGroup.get(key));
		}
		
		
		
	}
}
class Student {
	private String name;
	private boolean isMale;
	private int hak;
	private int ban;
	private int score;

	public Student(String name, boolean isMale, int hak, int ban, int score) {
		this.name = name;
		this.isMale = isMale;
		this.hak = hak;
		this.ban = ban;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public int getHak() {
		return hak;
	}

	public void setHak(int hak) {
		this.hak = hak;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.format("[ %s, %s %d학년 %d반, %3d점 ]", name, isMale ? "남" : "여", hak, ban, score);
	}
	
	enum Level{
		HIGH, MID, LOW
	}
}
