package day17;

import java.util.Random;

class Person {
	String name;
	int age;
	String gender;
	int money;
	
	public Person() {}

	public Person(String name, int age, String gender, int money) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.money = money;
	}
}

class Teacher extends Person {
	String subject;
	String position;
	int cnt = 0;
	private int income = 10_000_000;
	
	public Teacher(String name, int age, String gender, int money, String position) {
		super(name, age, gender, money);
		this.position = position;
	}
	
	void teach (String subject) {
		cnt ++;
		if (cnt % 10 == 0) income *= 1.1;
		
		this.subject = subject;
		
		money += income;
		System.out.println(name + " " + this.position + "이(가)" + this.subject+ " 을(를) 강의중");
		System.out.println("통장잔고 : " + money + "원");
	}
	
}

public class Job {
	public static void main(String[] args) {
		Teacher 한동석 = new Teacher("한동석", 20, "남자", 0, "강사");
		String [] arSub = {"JAVA", "C언어", "파이썬"};
		Random r = new Random();
		
		int index = 0;
		index = r.nextInt(3); //0~2까지의 랜덤한 수
		//random은 시간을 상수로 넣어서 
		
		for (int i = 0; i < 100; i++) {
			한동석.teach(arSub[index]);
//			Thread.sleep(1000);
			//sleep은 잠시 컴파일러를 재우는 것. 1000은 1초다. 
		}
	}
}












