package p2_TireEx_Polymorphism;

public class NexenTire extends Tire {
	public NexenTire() { }
	public NexenTire (String location, int maxRotation) {
		super (location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accuamulatedRotation;
		if (accuamulatedRotation < maxRotation) {
			System.out.println(location + "³Ø¼¾Å¸ÀÌ¾î ¼ö¸í : " +
					(maxRotation - accuamulatedRotation));
			return true;
		}else {
			System.out.println("***" + location + "³Ø¼¾Å¸ÀÌ¾î ÆãÅ© ***");
			return false;
		}
	}
}
