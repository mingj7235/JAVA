package P;

public class Customer extends  WirelessClass{
	
	public Customer(String name, Rank code, int time) {
		this.custName = name;
		this.gradeCode = code.rankName;
		this.unitPrice = code.timePrice;
		this.basePrice = code.price;
		this.useTime = time;
	}

	@Override
	public int communicationFee() { //통신요금
		return this.unitPrice * this.useTime + this.basePrice - this.discountRate();
	}
	@Override
	public int discountRate() { //할인요금
		return this.basePrice/10;
	}
}
