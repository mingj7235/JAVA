package practice;

public class Dgrade extends Customers{
	String grade = "D"; //등급
	int pricePerTime = 52; //시간당 단가
	int basicPrice = 20000; // 기본요금 
	
	@Override
	public int FareCal() {
		return (pricePerTime * useTime) + basicPrice - (basicPrice/10);
	}
}
