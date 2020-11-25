package p2_TireEx_Polymorphism;

public class KumhoTire extends Tire{
	public KumhoTire() { }
	public KumhoTire (String location, int maxRotation) {
		super (location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accuamulatedRotation;
		if (accuamulatedRotation < maxRotation) {
			System.out.println(location + "금호타이어 수명 : " +
					(maxRotation - accuamulatedRotation));
			return true;
		}else {
			System.out.println("***" + location + "금호타이어 펑크 ***");
			return false;
		}
	}
}
