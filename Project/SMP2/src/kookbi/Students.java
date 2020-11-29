package kookbi;

import java.util.Random;

public class Students {
	Random r = new Random();
	private String name;
	private int age;
	private int number;
	private String libraryCode;
	private static int Fnum = 20201000;
	private static int Nnum = 64;
	private static int N2num = 64;

	public Students() {
	}
	public Students(String name, int age) {
		this.name = name;
		this.age = age;
		this.libraryCode = "" +((char)(Nnum+r.nextInt(24))) + ((char)(N2num + r.nextInt(24))) ;
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
	String show () {
		return "학번 : "+ this.number + " | 이름 : " + this.name + " | 나이 : " + age + "살";
	}
	String libraryShow () {
		return "학번 : " + this.number + " | 이름 : " + this.name + " | 도서 대여 코드 : "  + this.libraryCode;
	}
}
