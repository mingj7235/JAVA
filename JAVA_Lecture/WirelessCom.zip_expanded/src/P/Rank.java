package P;

public class Rank { //등급코드 클래스
	String rankName;
	int timePrice; //시간당 단가
	int price; //기본요금
	
	Rank(String rankName, int timePrice, int price){
		this.rankName = rankName;
		this.timePrice = timePrice;
		this.price = price;
	}
}