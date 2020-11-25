package p2_TireEx_Polymorphism;

public class HankookTire extends Tire{
	public HankookTire() { }
	public HankookTire (String location, int maxRotation) {
		super (location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accuamulatedRotation;
		if (accuamulatedRotation < maxRotation) {
			System.out.println(location + "한국타이어 수명 : " +
					(maxRotation - accuamulatedRotation));
			return true;
		}else {
			System.out.println("***" + location + "한국타이어 펑크 ***");
			return false;
		}
	}
}
