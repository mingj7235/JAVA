package testPractice_mine;

public class GradesManage implements WirelessInterface{
	String customer;
	String grade;
	int pricePerTime;
	int basicPrice;
	int usingTime;
	
	//기본생성자

	public GradesManage(String customer, String grade, int pricePerTime, int basicPrice, int usingTime) {
		this.customer = customer;
		this.grade = grade;
		this.pricePerTime = pricePerTime;
		this.basicPrice = basicPrice;
		this.usingTime = usingTime;
	}

	@Override
	public int discountPrice() {
		return (int)(this.basicPrice *0.1);
	}

	@Override
	public int totalPrice() {
		return (this.pricePerTime * this.usingTime) + this.basicPrice - discountPrice();
	}
	
	
}
