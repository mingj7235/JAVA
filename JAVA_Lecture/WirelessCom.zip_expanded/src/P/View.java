package P;

public class View {
	public static void main(String[] args) {
		Business business = new Business();
		boolean flag = true;
		while(flag) {
			switch (business.mainMenu()) {
			case 1:
				business.input();
				break;
			case 2:
				business.output();
				break;
			case 3:
				business.addRank();
				break;
			case 4:
				System.out.println("종료합니다.");
				flag = false;
				break;
			default:
				System.out.println("재입력해주세요.");
				break;
			}
		}
	}
}
