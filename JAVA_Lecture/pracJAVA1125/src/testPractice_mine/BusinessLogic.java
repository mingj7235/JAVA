package testPractice_mine;

import java.util.Scanner;

public class BusinessLogic {
	Scanner sc = new Scanner(System.in);
	int choice; 
	int cnt = 0;
	GradesManage arData [] = new GradesManage [10]; 
	//view
	public void view () {
		boolean flag = false;
		while (!flag) {
			System.out.print("통신요금 계산기"
					+ "\n1. 입력  2. 출력  3. 종료"
					+ "\n 번호 입력 : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1 : 
				insert();
				break;
			case 2 : 
				print(arData);
				break;
			case 3 : 
				
				break;
			}
			
		}
	}
	
	public void insert () {
		boolean check = false;
		String yesOrno = "";
		while (!check) {
			System.out.print("고객의 정보를 입력합니다. "
					+ "\n고객의 성함 : ");
			String customer = sc.next();
			
			System.out.print("고객의 등급 : ");
			String grade = sc.next();
			
			System.out.println("고객의 사용시간 : ");
			int usingTime = sc.nextInt();
			
			if (grade.equals("A") || grade.equals("a")) {
				arData[cnt] = new Agrade(customer, grade, 86, 10000, usingTime);
				cnt++;
			}
			if (grade.equals("B") || grade.equals("b")) {
				arData[cnt] = new Bgrade(customer, grade, 81, 12000, usingTime);
				cnt++;
			}
			if (grade.equals("C") || grade.equals("c")) {
				arData[cnt] = new Cgrade(customer, grade, 104, 15000, usingTime);
				cnt++;
			}
			if (grade.equals("D") || grade.equals("d")) {
				arData[cnt] = new Dgrade(customer, grade, 52, 20000, usingTime);
				cnt++;
			}
			System.out.println("입력을 그만하시겠습니까 ? ( y/n )");
			yesOrno = sc.next();
			if(yesOrno.equals("Y") || yesOrno.equals("y")) {
				System.out.println("입력을 그만합니다.");
				check = true;
			}
		}
	}//end insert()
	
	public void print (GradesManage [] arData) {
		System.out.println("고객명     등급코드     시간당단가     기본요금     사용요금     사용시간     할인요금     당월통신요금");
		for (int i = 0; i < arData.length; i++) {
			if (arData.length == 0) {
				System.out.println("데이터가 없습니다.");
				break;
			}else {
				System.out.println(arData[i].customer + "   " + arData[i].grade + "   " + arData[i].pricePerTime + "   " + arData[i].basicPrice +
						"   " + arData[i].usingTime + "    " + arData[i].discountPrice() + "    " + arData[i].totalPrice());
			}
		}
	}

}
