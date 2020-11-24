package day17;

import java.util.Scanner;

class Animal{
	String name;
	int age;
	String feed;
	
	public Animal() {}
	
	public Animal(String name, int age, String feed) {
		this.name = name;
		this.age = age;
		this.feed = feed;
	}
	

	@Override
	public String toString() {
		return "이름 : " + name + "\n나이 : " + age + "\n먹이 : " + feed;
	}
}


public class ArInstance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Animal [] arAni = new Animal[3];
		
		for (int i = 0; i < arAni.length; i++) {
			arAni [i] = new Animal();
			//매번 이렇게 초기화를 시켜줘야한다. heap 메모리에 넣어야함
			//초기화를 시켜줘야 이제 값을 넣을 수 있는 저장공간이 만들어지는 것이다. 
			
			System.out.println(i+1+ "번 동물 이름 : ");
			arAni[i].name = sc.next();
			System.out.println(arAni[i].name + " 나이 : " );
			arAni[i].age = sc.nextInt();
			System.out.println(arAni[i].name + " 먹이 : ");
			arAni[i].feed = sc.next();
		}
		
		for (int i = 0; i < arAni.length; i++) {
			System.out.println(arAni[i]);
		}
		
		
		
	}
}
