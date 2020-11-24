package review;

//강아지, 고양이, 돼지 객체화
//생성자를 사용해서 초기화 하기
public class Animal {
	int age;
	String sounds;
	String color;
	String name;
	double weight;
	Animal () {
		
	}
	
	public Animal(int age, String sounds, String 색깔, String name) {
		this.age = age;
		this.sounds = sounds;
		this.color = 색깔;
		this.name = name;
	}
	
	public Animal(String sounds, String color, String name, double weight) {
		this.sounds = sounds;
		this.color = color;
		this.name = name;
		this.weight = weight;
	}

	void showInfo () {
		System.out.println("우리 " + name + "은(는) " + color + "이고 나이는" + age + "살 입니다.\n"
				+ "우리 " + name + "은(는)"+ sounds + "하고 웁니다.");
	}
	
	
	
	
	public static void main(String[] args) {
		Animal dog = new Animal(3, "\"월월\"", "검은색", "뽀삐");
		Animal cat = new Animal();
		Animal pig = new Animal();
		
		dog.showInfo();
		
	}
	
	
	
}
