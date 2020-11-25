package p2_TireEx_Polymorphism;

public class Tire {
	//필드
	public int maxRotation;
	public int accuamulatedRotation;
	public String location;
	
	public Tire () {
		
	}

	public Tire(String location, int maxRotation) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	//메소드
	public boolean roll () {
		++accuamulatedRotation;
		if (accuamulatedRotation < maxRotation) {
			System.out.println(location + "Tire 수명 : " + 
		(maxRotation - accuamulatedRotation)	+ "회");
			return true;
		} else {
			System.out.println("***" + location + "Tire 펑크 ***");
			return false;
		}
	}
	
	
}
