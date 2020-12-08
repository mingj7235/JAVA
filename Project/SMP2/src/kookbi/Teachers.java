package kookbi;

public class Teachers {
	//선생님 관리 프로그램
	private String teachName;
	private int age;
	private int teachNum;
	private static int FTNUM = 1000;
	private String teachSubject;
	
	public Teachers(String teachName, int age, String teachSubject) {
		this.teachName = teachName;
		this.age = age;
		this.teachSubject = teachSubject;
		this.teachNum = FTNUM++;
	}

	public String getTeachName() {
		return teachName;
	}
	public void setTeachName(String teachName) {
		this.teachName = teachName;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getTeachSubject() {
		return teachSubject;
	}
	public void setTeachSubject(String teachSubject) {
		this.teachSubject = teachSubject;
	}
	
	public int getTeachNum() {
		return teachNum;
	}
	public void setTeachNum(int teachNum) {
		this.teachNum = teachNum;
	}

	public String show () {
		return "| 강사 이름 :  " + teachName + "  | 강사 나이 :  " + age + "  | 담당 과목 :  " + teachSubject;
	}
	
	public String showNum () {
		return "| 강사 이름 : " + teachName + "  | 강사 사번 : " + teachNum;
	}
	
	
}
