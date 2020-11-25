package testPractice_Teacher;

import java.util.Scanner;

public class Business {
	WirelessClass[] wir = {new AGrade(),new BGrade(), new CGrade(), new DGrade()};
			
   Scanner sc = new Scanner(System.in);
   void start() {
	   menuDisplay();//메뉴 보이게 하기
   }
   void menuDisplay() {
	   
	   boolean flag = true;
	   int choice=1;
	   while(flag) {
		   System.out.println("-----------------------");
		   System.out.println("1. 입력    2. 출력   3. 종료  ");
		   System.out.println("-----------------------");
		   System.out.print("선택은 ? ");
		   choice = sc.nextInt();
		   switch(choice) {
		      case 1:input();
		             break;
		      case 2:output();
		              break;
		      case 3: flag = false; break;
		   }
	   }
   }//end menuDisplay()
   void input() {
	   System.out.println("고객명");
	   String custName=sc.next();
	   System.out.println("등급코드");
	   String grade=sc.next();
	   System.out.println("사용시간");
	   int useTime=sc.nextInt();
	   switch(grade) {
	   case "a":
	   case "A":  wir[0].input(custName,  useTime); break;
	   case "b":
	   case "B":  wir[1].input(custName, useTime); break;
	   case "c":
	   case "C":  wir[2].input(custName,  useTime); break;
	   case "d":
	   case "D":  wir[3].input(custName,  useTime); break;
	   default : break;
		         
	   }
   }//end input()
   void output() {
	   System.out.println("------------------------------------------------------");
	   System.out.println("고객명 등급코드 시간당단가 기본요금 사용시간 할인요금 이번달통신요금");
	   System.out.println("------------------------------------------------------");
	   wir[0].output();
	   wir[1].output();
	   wir[2].output();
	   wir[3].output();
	   
   }
}

