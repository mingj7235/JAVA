package practice;

public class Cgrade extends Customers{
	String grade = "C"; //등급
	int pricePerTime = 104; //시간당 단가
	int basicPrice = 15000; // 기본요금 
	
	@Override
	public int FareCal() {
		return (pricePerTime * useTime) + basicPrice - (basicPrice/10);
	}
}
