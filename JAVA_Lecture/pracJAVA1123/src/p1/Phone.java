package p1;
//추상클래스 : 일반클래스와 똑같으나, 추상메소드를 가질 수 있다. 
//추상 클래스 = 일반 클래스 + 추상메소드
//추상클래스는 일반 클래스처럼 사용해도 무방하다. 
//일반클래스 : 추상메소드를 가지고 있으면 안된다.
//즉, 추상메소드는 반드시 추상클래스에 있어야 한다. 
public abstract class Phone {
	//abstract 키워드 -> 추상클래스로 변환. 
	private String owner;
	private String telphone;
	private int price;
	
	public abstract void turnOn (); //추상 메소드 (바디가 없다.) abstract 키워드를 넣어야한다. 
	public abstract void trunOff ();
	
	public void aa () { } 
	
	public Phone() {
		System.out.println("기본생성자");
	}
	public Phone(String owner, String telphone, int price) {
		this.owner = owner;
		this.telphone = telphone;
		this.price = price;
		System.out.println("명시적 생성자");
	}
	
	//getter & setter
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
