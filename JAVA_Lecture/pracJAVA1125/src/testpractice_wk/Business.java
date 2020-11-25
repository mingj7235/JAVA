package testpractice_wk;

import java.util.Scanner;

public class Business {


    WirelessClass[] wc = new WirelessClass[10];
    Scanner sc = new Scanner(System.in);
    void start(){
        menuDisplay();

    }//end start

    void menuDisplay(){

        boolean flag = true;
        int choice = 0;
        while(flag){
            System.out.println("-------------------");
            System.out.println("1.입력 2.출력 3.종료");
            System.out.println("-------------------");
            System.out.print("선택은? ");
            choice = sc.nextInt();

            switch(choice){
                case 1: input(); break;
                case 2: output(wc); break;
                case 3: flag = false; break;
            }//end switch
        }//end while
    }//end menuDisplay

    int i = 0;

    void input(){
        while(true) {
            System.out.print("고객명은");
            String custName = sc.next();

            System.out.print("등급은");
            String grade = sc.next();

            System.out.print("사용시간은");
            int useTime = sc.nextInt();

            switch (grade) {
                case "A":
                case "a":
                    wc[i++] = new AGrade(grade, custName, 86, 10000, useTime);
                    break;
                case "B":
                case "b":
                    wc[i++] = new BGrade(grade, custName, 81, 12000, useTime);
                    break;
                case "C":
                case "c":
                    wc[i++] = new CGrade(grade, custName, 104, 15000, useTime);
                    break;
                case "D":
                case "d":
                    wc[i++] = new DGrade(grade, custName, 52, 20000, useTime);
                    break;
            }//end switch

            System.out.println("계속 입력하시겠습니까?");
            String ans = sc.next();
            if(ans.equals("n")){
                break;
            }
        }//end while
    }//end input

    void output(WirelessClass[] wc){
        System.out.println("고객명 등급코드 시간당단가 기본요금 사용시간 할인요금 이번달 통신요금");
        for(int i = 0; i < wc.length; i++){
            if(wc[i] == null){
                break;
            }
            System.out.println(wc[i].custName + "  " + wc[i].gradeCode + "  " + wc[i].timeFee + "  " + wc[i].basePrice + "  " + wc[i].useTime + "  " + wc[i].discountRate() + "  " + wc[i].communicationFee());
        }//end for
    }//end output

}
