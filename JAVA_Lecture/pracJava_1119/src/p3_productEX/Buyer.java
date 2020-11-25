package p3_productEX;
//비지니스 로직
public class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	Product [] item = new Product[10]; //구입한 제품 저장 배열
	int i = 0;
	
	void buy (Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족함");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p;
		System.out.println(p + "을/를 구입했습니다.");
		System.out.println("현재 남은 금액 : " + money + "만 원");
	}
	
	void summary () {
		int sum = 0;
		String itemList = "";
		
		for (int i = 0; i < item.length; i++) {
			if (item[i] == null) break;
			sum += item[i].price;
			bonusPoint += item[i].bonusPoint;
			if (item[i+1] == null) {
				itemList += item[i] + " ";
			} else {
				itemList += item[i] + ", ";
			}
		}
		System.out.println("\n구입하신 제품은" + itemList + "입니다.");
		System.out.println("구입하신 물품의 총 금액은" + sum + "만원입니다.");
		System.out.println("현재 잔액 : "  + money + "만 원입니다.");
		System.out.println("포인트 : " + bonusPoint + "점 입니다.");
	}
	
}
