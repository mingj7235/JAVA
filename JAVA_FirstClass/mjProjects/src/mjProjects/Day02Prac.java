package mjProjects;

import java.util.Scanner;

public class Day02Prac {
	public static void main(String[] args) {
		String qMsg = "다음 중 되고싶은 동물을 하나 고르세요.";
		String choiceMsg = "1. 어항에 갇힌 금붕어\n"
				+ "2. 나무에서 못 내려오는 원숭이\n"
				+ "3. 이빨이 아픈 악어\n"
				+ "4. 뿔 한 쪽이 없는 사슴";
		
		String answerMsg1 = "고민이 많군요!";
		String answerMsg2 = "겁이 많군요!";
		String answerMsg3 = "치통이 있군요!";
		String answerMsg4 = "외롭군요!";
		String errMsg = "다시 시도하세요";
		
		Scanner sc = new Scanner(System.in);
		
		int choice= 0;
		String result = "";
		System.out.println(qMsg + "\n" + choiceMsg);
		choice = sc.nextInt();
		
		result = choice == 1 ? answerMsg1 :
			choice == 2 ? answerMsg2 : 
				choice == 3 ?answerMsg3 :
					choice == 4 ? answerMsg4 : errMsg;
		
		System.out.println(result);
		
	}
}
