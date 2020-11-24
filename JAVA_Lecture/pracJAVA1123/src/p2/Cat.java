package p2;

public class Cat extends Animal{

	@Override
	public void sound() {
		System.out.print("야옹야옹!");
	}
	public Cat() {
		super.kind = "포유류";
	}
	
	public void play () {
		System.out.println("털뭉치를 가지고 논다.");
	}
	
	@Override
	public String toString() {
		return "고양이";
	}
}
