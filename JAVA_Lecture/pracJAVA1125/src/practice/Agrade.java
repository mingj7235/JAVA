package practice;

public class Agrade extends Customers{
	String grade = "A"; //등급
	int pricePerTime = 86; //시간당 단가
	int basicPrice = 10000; // 기본요금 
	
	@Override
	public int FareCal() {
		return (pricePerTime * useTime) + basicPrice - (basicPrice/10);
	}
	
}
