package day07_new;

import java.util.Scanner;

public class arrTask {
	public static void main(String[] args) {
		/*
		 * 닥스 매장
		 * 				강남점 홍대점 신촌점
		 * 일반점
		 * 키즈점
		 * 
		 * 각 지점별 총 매출액, 평균 매출액
		 * 각 연령별 총 매출액, 평균 매출액
		 * 닥스 총 매출액, 평균 매출액
		 * 
		 * 닥스 평균 매출액 보다 높은 매출액 매장은 인센티브 매장으로 출력
		 */
		Scanner sc = new Scanner(System.in);
		String [][] arrDAKS = {
				{"강남 - 일반점", "홍대 - 일반점", "신촌- 일반점"},
				{"강남 - 키즈점", "홍대 - 키즈점", "신촌- 키즈점"},
		};
		String q_msg = null;
		String n_income = "";
		String k_income = "";
		
		int num_shops = arrDAKS.length * arrDAKS[0].length;
		int n_sum = 0;
		int k_sum = 0; 
		int t_sum = 0;
		
		double n_avg = 0.0;
		double k_avg = 0.0;
		double t_avg = 0.0;
				
		int [][] arrIncome = new int [arrDAKS.length][arrDAKS[0].length];
		int [] arNormalIncome = new int [arrDAKS[0].length];
		int [] arKidsIncome = new int [arrDAKS[0].length];
		
		for (int i = 0; i < arrDAKS.length; i++) {
			for (int j = 0; j < arrDAKS[i].length; j++) {
				q_msg = arrDAKS [i][j] + " 의 매출액을 적어주세요 (단위는 만원) : ";
				System.out.print(q_msg);
				if (i == 0) {
					arNormalIncome[j] = sc.nextInt();
				}
				if (i == 1) {
					arKidsIncome[j] = sc.nextInt();
				}
			}
		}
		
		for (int i = 0; i < arrDAKS.length; i++) {
			for (int j = 0; j < arrDAKS[i].length; j++) {
				if (i == 0) {
					arrIncome[0][j] = arNormalIncome[j];
				}
				if (i == 1) {
					arrIncome[1][j] = arKidsIncome[j];
				}
			}
		}
		
		//일반점 매출액
		System.out.println("DAKS 일반점 매출액");
		for (int i = 0; i < arNormalIncome.length; i++) {
			n_income += arrDAKS[0][i] + "의 매출액 : " +  arNormalIncome[i] + "만원\n";
		}
		System.out.println(n_income);
		
		//일반점 총 매출액
		System.out.println("DAKS 일반점 총 매출액");
		for (int i = 0; i < arNormalIncome.length; i++) {
			n_sum += arNormalIncome[i];
		}
		System.out.println("일반점 총 매출액 : " +  n_sum + "만원");
		
		//일반점 평균 매출액
		System.out.println("DAKS 일반점 평균 매출액");
		for (int i = 0; i < arNormalIncome.length; i++) {
			n_avg = Double.parseDouble(String.format("%.2f", (double)n_sum / arNormalIncome.length));
		}
		System.out.println("일반점 평균 매출액 : " +  n_avg + "만원");
				
		//키즈점 매출액
		System.out.println("DAKS 키즈점 매출액\n");
		for (int i = 0; i < arKidsIncome.length; i++) {
			k_income += arrDAKS[1][i] + "의 매출액 : " +  arKidsIncome[i] + "만원\n";
		}
		System.out.println(k_income);
		
		//키즈점 총 매출액
		System.out.println("DAKS 키즈점 총 매출액");
		for (int i = 0; i < arKidsIncome.length; i++) {
			k_sum += arKidsIncome[i];
		}
		System.out.println("키즈점 총 매출액 : " +  k_sum + "만원");
		
		//키즈점 평균 매출액
		System.out.println("DAKS 키즈점 평균 매출액");
		for (int i = 0; i < arKidsIncome.length; i++) {
			k_avg = Double.parseDouble(String.format("%.2f", (double)k_sum / arKidsIncome.length));
		}
		System.out.println("키즈점 평균 매출액 : " +  k_avg + "만원");
		
		
		//닥스 총 매출액, 평균 매출액
		
		t_sum = n_sum + k_sum;
		t_avg =  Double.parseDouble(String.format("%.2f", (double)t_sum / num_shops));
				
		System.out.println("DAKS 총 매출액 : " + t_sum + "만원");
		System.out.println("DAKS 평균 매출액 : " + t_avg + "만원");
		
		//인센티브 매장
		for (int i = 0; i < arrDAKS.length; i++) {
			for (int j = 0; j < arrDAKS[i].length; j++) {
				if(arrIncome[i][j] > t_avg) {
					System.out.println(arrDAKS[i][j] + "이 우수매장입니다!");
				}
			}
		}
	}
}
