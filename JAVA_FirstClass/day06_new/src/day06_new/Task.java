package day06_new;

import java.util.Random;
import java.util.Scanner;

public class Task {
	public static void main(String[] args) {

		//[초급]
		//100~1까지 배열에 담고 출력하기
		//1~100까지 중 짝수만 배열에 담고 출력하기
		//1~10까지 배열에 담고 총 합 구하기
		//1~n 까지 매열에 담고 총 합 구하기
		//A~F 까지 배열에 담고 출력하기 (아스키)
		//A~F 까지 중 C제외하고 배열에 담은 후 출력하기
		
		//[중급]
//		aBcDeF....Z 배열에 담고 출력하기
//		int [] arData = new int [26];
//		String result = "";
//		for (int i = 0; i < arData.length; i++) {
//			if ( !(i % 2 == 0)) {
//				arData[i] = (65+ i);
//			}else {
//				arData[i] = (97+ i);
//			}
//			result += (char)arData[i];
//		}
//		System.out.println(result);
		
		//5개의 정수를 입력받고 최대값과 최소값 출력하기
		
//		Scanner sc = new Scanner(System.in);
//		int [] arData = new int [5];
//		int max = 0;
//		int min = 0;
//		String result = "";		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.print(i +1 + "번째 의 정수를 입력하세요 : ");
//			arData[i] = sc.nextInt();
//			result += " " + arData[i];
//		}
//		max = arData [0];
//		min = arData [0];
//		for (int i = 0; i < arData.length; i++) {
//			if (arData[i] > max)
//				max = arData[i];
//			if (arData[i] < min)
//				min = arData[i];
//		}
//		System.out.println("사용자가 입력한 값 : " + result + "중에서"
//				+ "\n최대값은 : " + max + 
//				"\n최소값은 : " + min + 
//				"\n 입니다.");
		
		
//		//문자열을 입력받고 소문자만 대문자로 바꾸기
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("영어만 입력해주세요. (대소문자무관)");
//		String inputData = sc.next();
//		String resultData = "";
//		int data = 0;
//		for (int i = 0; i < inputData.length(); i++) {
//			data = (int)(inputData.charAt(i));
//			if (data > 96 && data < 123) {
//				 data -= 32;
//				 resultData += (char)data;
//			}else {
//				resultData += (char)data;
//			}
//		}
//		System.out.println(resultData);
//		
		//사용자가 입력한 값 만큼 정수를 입력받고 배열에 넣은 후 3의 배수만 출력하기
//		Scanner sc = new Scanner(System.in);
//		String mainMsg = "1. 값 입력하기\n2. 입력한 값 중 3의 배수만 출력하기\n3. 지금까지 입력한 수 보기\n4. 나가기";
//		String errMsg = "오류입니다. 다시 확인해주세요";
//		String inputNum = "";
//		int choice = 0;
//		String result = "";
//		while (true) {
//			System.out.println(mainMsg);
//			choice = sc.nextInt();
//			switch(choice) {
//			case 1 :
//				//정수입력
//				System.out.print("정수를 입력해주세요 : ");
//				int num = sc.nextInt();
//				inputNum += num + ", ";			
//				break;
//			case 2 :
//				//입력한 값 중 3의 배수만 출력하기
//				if (inputNum.equals("")) {
//					System.out.println(errMsg);
//					break;
//				}
//				for (int i = 0; i < inputNum.split(", ").length; i++) {
//					if (Integer.parseInt(inputNum.split(", ")[i]) % 3 == 0) {
//						result += Integer.parseInt(inputNum.split(", ")[i]);
//					}else {
//						result += "";
//					}
//					System.out.print(result);
//				}
//				System.out.print("입력한 값 중 3의 배수 : ");
//				if (result.equals("")) {
//					System.out.println("3의 배수가 없습니다.");
//				}else {
//					System.out.println(result);
//				}
//				break;
//			case 3 :
//				//지금까지 입력한 수 보기
//				if (inputNum.equals("")) {
//					System.out.println(errMsg);
//					break;
//				}else {
//					System.out.print("당신이 입력한 수 : ");
//					System.out.println(inputNum);
//					break;
//				}
//			default :
//				break;
//			}
//		}
		
		
		//[고급]
		//90%확률로 꽝을 출력하고 10%확률로 당첨을 출력하기 (랜덤 활용?)
		
//		String lucky ="당첨";
//		String sorry ="꽝";
//		Random r = new Random();
//		int data = r.nextInt(10);
//		System.out.println(data);
//		if (data == 0) {
//			System.out.println(lucky);
//		}else {
//			System.out.println(sorry);
//			}
//		}

		
		//정수를 한글로 변경하기 1024 -> 일공이사
		
		Scanner sc = new Scanner(System.in);
		String kor = "공일이삼사오육칠팔구";
		System.out.println("정수를 한글로 변경해드립니다. \n"
				+ "정수를 입력해주세요.");
		String inPutData = sc.next();
		int data = Integer.parseInt(inPutData);
		String result = "";
		
		for (int i = 0; i < inPutData.length(); i++) {
			result += kor.charAt(data % 10);
			data /= 10;
		}
		
		for (int i = inPutData.length()-1; i >= 0; i--) {
			System.out.print(result.charAt(i));
		}
		
		//한글을 정수로 변경하기 일공이사 -> 1024
		
//		Scanner sc = new Scanner(System.in);
//		
//		String kor = "공일이삼사오육칠팔구";
//		String num = "0123456789";
//		
//		System.out.println("한글을 정수로 변경해드립니다. \n"
//				+ "한글을 입력해주세요. (0은 공으로. 영이라고 쓰면 오류)");
//		String inPutData = sc.next();
//		
//		//일공사오
//		
//		for (int i = 0; i < inPutData.length(); i++) {
//			
//			
//		}
//		
		
		
		
		
		
		
		
	}	

}








	
