package kookbi;

public class Students {
	
	private String name;
	private int age;
	private int number;
	private static int Fnum;

	public Students() {
	}
	public Students(String name, int age) {
		this.name = name;
		this.age = age;
		this.number = ++Fnum;
	}
		public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	void show () {
		System.out.println("번호 : "+ this.number + " 이름 : " + this.name + " 나이 : " + age + "살");
	}	
}
