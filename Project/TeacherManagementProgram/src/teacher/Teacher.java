package teacher;

public class Teacher implements Comparable<Teacher>{
	
	private String name;
	private String fire;
	private int career;
	private int studentNumber;
	private int score;
	private int bonus;
	
	public Teacher(String name, int career,int studentNumber, int score, int bonus, String fire) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.career = career;
		this.score = score;
		this.bonus = bonus;
		this.fire = fire;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getBonus() {
		return bonus;
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public String getFire() {
		return fire;
	}

	public void setFire(String fire) {
		this.fire = fire;
	}

	@Override
	public int compareTo(Teacher obj) {
		
		if(this.getScore() > obj.getScore()) {
			return 1;
		}else if(this.getScore() == obj.getScore()) {
			return 0;
		}else {
			return -1;
		}
	}
	
}
