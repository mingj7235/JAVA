package practice;

public class Bgrade extends Customers{
	String grade = "B"; //등급
	int pricePerTime = 81; //시간당 단가
	int basicPrice = 12000; // 기본요금 
	
	@Override
	public int FareCal() {
		return (pricePerTime * useTime) + basicPrice - (basicPrice/10);
	}
}
