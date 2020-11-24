package arrTask;

import java.util.Scanner;

public class ArrTask {
	public static void main(String[] args) {
		//닥스 회장
		//강남점 홍대점 신촌점
		//일반
		//키즈
		//
		//각 지점별 총 매출액, 평균 매출액
		//각 연령별 총 매출액, 평균 매출액
		//닥스 총 매출액, 평균 매출액
		//
		//닥스 평균 매출액보다 높은 매출액 매장은 인센티브 매장으로 출력
			
		String[] arBranch = {"강남점", "홍대점", "신촌점"};
		String[] arAge = {"일반", "키즈"};
		
		int[][] arrIncome = new int[arBranch.length][arAge.length];
		int length = 0;
		
		int[] arBranchTotal = new int[3];
		int[] arAgeTotal = new int[2];
		
		double[] arBranchAvg = new double[3];
		double[] arAgeAvg = new double[2];
		
		int total = 0;
		double avg = 0.0;
		
		boolean bonusCheck = false;
		
		String bonusMsg = "";
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < arrIncome.length; i++) {
			length += arrIncome[i].length;
			for (int j = 0; j < arrIncome[i].length; j++) {
				System.out.println(arBranch[i] + " " + arAge[j] + "매장 매출액을 입력하세요(단위:만원)");
				arrIncome[i][j] = sc.nextInt();
				arBranchTotal[i] += arrIncome[i][j];
				arAgeTotal[j] += arrIncome[i][j];
				total += arrIncome[i][j];
			}
			arBranchAvg[i] = Double.parseDouble(
					String.format("%.2f", (double)arBranchTotal[i] / arrIncome[i].length));
		}
		
		for (int i = 0; i < arAgeAvg.length; i++) {
			arAgeAvg[i] = Double.parseDouble(
					String.format("%.2f", (double)arAgeTotal[i] / arrIncome.length));
		}
		
		avg = Double.parseDouble(
				String.format("%.2f", (double)total / length));
		
		System.out.println("=====================================");
		for (int i = 0; i < arBranchTotal.length; i++) {
			System.out.println(arBranch[i] + " 총 매출액 : " + arBranchTotal[i] + "만원");
			System.out.println(arBranch[i] + " 평균 매출액 : " + arBranchAvg[i] + "만원");
		}
		System.out.println("=====================================");
		for (int i = 0; i < arAgeTotal.length; i++) {
			System.out.println(arAge[i] + "매장 총 매출액 : " + arAgeTotal[i] + "만원");
			System.out.println(arAge[i] + "매장 평균 매출액 : " + arAgeAvg[i] + "만원");
		}
		System.out.println("=====================================");
		System.out.println("닥스 총 매출액 : " + total + "만원");
		System.out.println("닥스 평균 매출액 : " + avg + "만원");
		System.out.println("=====================================");
		
		bonusMsg = "★ 인센티브 매장 ★\n";
		
		for (int i = 0; i < arrIncome.length; i++) {
			for (int j = 0; j < arrIncome[i].length; j++) {
				if(arrIncome[i][j] > avg) {
					bonusMsg += arBranch[i] + " " + arAge[j] + "매장\n";
					bonusCheck = true;
				}
			}
		}
		
		if(!bonusCheck) {
			bonusMsg = "인센티브 매장이 없습니다. 분발하세요.\n";
		}
		System.out.print(bonusMsg);
	}
}
