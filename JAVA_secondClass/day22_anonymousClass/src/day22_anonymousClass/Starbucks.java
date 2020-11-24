package day22_anonymousClass;

public class Starbucks {
	private String [] menu = {"아메리카노", "레몬티", "카푸치노"};
	private int[] arPrice = {5000, 8000, 9000};
	private int income;
	String choice = "카푸치노";

	public String[] getMenu() {
		return menu;
	}

	public void setMenu(String[] menu) {
		this.menu = menu;
	}

	public int[] getArPrice() {
		return arPrice;
	}

	public void setArPrice(int[] arPrice) {
		this.arPrice = arPrice;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public void registCafe (Cafe c, String choice) {
		c.setMenu(menu);
		System.out.println("카페 등록 완료");
		System.out.println("----Menu----");
		for (int i = 0; i < c.getMenu().length; i++) {
			System.out.println(i+1+c.getMenu()[i]);
		}
		c.sell(choice);
	}
	public static void main(String[] args) {
		Starbucks gangnam = new Starbucks();
		gangnam.registCafe(new Cafe() {

			@Override
			public void setMenu(String[] menu) {
				gangnam.menu = menu;
			}

			@Override
			public String[] getMenu() {
				return gangnam.menu;
			}

			@Override
			public void sell(String choice) {
				for (int i = 0; i < gangnam.menu.length; i++) {
					if(gangnam.menu[i].equals(choice)) {
						gangnam.income += gangnam.arPrice[i];
					}else {
						
					}
				}
			}
			
		}, "없음");
		
		System.out.println("카푸치노 주문 완료");
		System.out.println("현재 수익 : " + gangnam.getIncome());
			// new Cafe를 해서 주소값을 넘겨주는것이다. 
			// Cafe 타입의 new를 시켜줘서 넘겨주는 것이다. 
			//new Cafe는 값이다. 얘는 이름이 없다. 익명클래스
			//매번 재정의해야하는 것들이기 때문에 익명클래스. 
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			@Override
//			public void setMenu(String[] menu) {
//				gangnam.menu =menu;
//			}
//			@Override
//			public void sell(String choice) {
//				for (int i = 0; i < gangnam.getMenu().length; i++) {
//					if(gangnam.getMenu()[i].equals(choice)) {
//						gangnam.income += gangnam.arPrice[i];
//					}
//				}
//			}
//			@Override
//			public String[] getMenu() {
//				return gangnam.menu;
//			}
//		}, "카푸치노");
	}
	
	
	
	
	
	
	
	
	
	
	
}
