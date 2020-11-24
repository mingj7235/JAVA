package day10;

import javax.swing.JOptionPane;

public class ArrShopPrac {
	public static void main(String[] args) {
		int [][] arrIncome = new int [2][3];
		int [] arASum = new int [2];
		int [] arBSum = new int [3];
		int sum = 0;
		int rLength = arrIncome.length;
		int cLength = arrIncome[0].length;
		double [] arAAvg = new double[2];
		double [] arBAvg = new double[3];
		double avg = 0.0;
		String [][] arrName = {
				{"강남점A" , "홍대점A", "신촌점A"},
				{"강남점K" , "홍대점K", "신촌점K"},
		};
		String inputMsg = "매출액을 입력하시오";
		String [] arAName = {"성인" , "키즈"};
		String [] arBName = {"강남점", "홍대점", "신촌점"};
		String result = "";
		
		for (int i = 0 ; i <rLength ; i++) {
			//arrIncome.length 와 arrIncome[0].length 의 차이 : 접근 !!! 대괄호치면 접근이다. 개소름..
			for (int j = 0 ; j <cLength; j++) {
				arrIncome[i][j] = Integer.parseInt(JOptionPane.showInputDialog(arrName[i][j] + "" + inputMsg));
				arASum[i] += arrIncome[i][j];
				arBSum[j] += arrIncome[i][j];
				sum += arrIncome[i][j];				
			}
		}
		for (int i = 0 ; i <arAAvg.length; i++) {
			arAAvg[i] = Double.parseDouble(String.format("%.2f", (double)arASum[i] / arBSum.length));
		}
		for (int i = 0 ; i <arBAvg.length; i++) {
			arBAvg[i] = Double.parseDouble(String.format("%.2f", (double)arBSum[i] / arASum.length));
		}
		
		avg = Double.parseDouble(String.format("%.2f", (double)sum / (rLength*cLength)));
		
		for (int i = 0; i < rLength; i++) {
			for (int j = 0; j < cLength; j++) {
				result += arrName[i][j] + "매출액 : " + arrIncome[i][j] + "만원\n";
				
			}
			//연령별 매출액
			result +=  arAName [i] + " 지점 총 매출액 : " + arASum[i] + "만원\n";
			result += arAName [i] + " 지점 평균 매출액 : " + arAAvg[i] + "만원\n";
			
		}
		for (int i = 0; i < arBSum.length; i++) {
			result += arBName [i] + " 총 매출액 : " + arBSum[i] + "만원\n";
			result += arBName [i] + " 지점 평균 매출액 : " + arBAvg[i] + "만원\n";
			
			
		}
	}
}
