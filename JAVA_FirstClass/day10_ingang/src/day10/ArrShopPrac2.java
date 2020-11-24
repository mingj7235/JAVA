package day10;

import javax.swing.JOptionPane;

public class ArrShopPrac2 {
	public static void main(String[] args) {
		//선언부
		int [][] arrIncome = new int [2][3];
		int sum = 0;
		int [] arASum = new int [2];
		int [] arBSum = new int [3];
		int rLength = arrIncome.length;
		int cLength = arrIncome[0].length;
		
	    double avg = 0.0;
		String [][] arrShop = {
				{"강남점A","신촌점A","명동점A"},
				{"강남점K","신촌점K","명동점K"}
		};
		// 매출액 합계 넣는 부분		
		for (int i = 0; i < rLength; i++) {
			for (int j = 0; j < cLength; j++) {
				arrIncome[i][j] = Integer.parseInt(JOptionPane.showInputDialog(arrShop[i][j]+" 의 매출액을 쓰시오. (단위는 만원)\n"));
				arASum[i] += arrIncome[i][j];
				arBSum[j] += arrIncome[i][j];
				sum += arrIncome[i][j];
			}
		}
		
		avg = Double.parseDouble(String.format("%.2f",(double)sum / (rLength * cLength)));
		// 평균액 넣는 부분
		for (int i = 0; i < rLength; i++) {
			for (int j = 0; j < cLength; j++) {
				
			}
		}
		
		
		
		
		JOptionPane.showMessageDialog(null, "NIKE 6개 매장의 총 매출액은 " + sum + "만원 입니다.");
	}
}
