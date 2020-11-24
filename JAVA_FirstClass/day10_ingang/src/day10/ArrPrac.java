package day10;

import javax.swing.JOptionPane;

public class ArrPrac {
	public static void main(String[] args) {
		//선언부
		int [][] arrIncome = new int [2][3];
		int rLength = arrIncome.length;
		int cLength = arrIncome[0].length;
		int sum = 0;
		int [] arASum = new int [2];
		int [] arBSum = new int [3];
		
		double avg = 0.0;
		double [] arAAvg = new double [2];
		double [] arBAvg = new double [3];
		
		String [][] arrName = {
				{"강남점A", "신촌점A", "명동점A"},
				{"강남점K", "신촌점K", "명동점K"},
		};
		String [] arAName = {"성인 매장", "키즈 매장"};
		String [] arBName = {"강남점", "신촌점", "명동점"};
		String result = "_________________________________\n";
		
		//매출액
		for (int i = 0; i < rLength; i++) {
			for (int j = 0; j < cLength; j++) {
				arrIncome [i][j] = Integer.parseInt(JOptionPane.showInputDialog(arrName[i][j] + " 의 매출액을 입력하시오 (단위 : 만원) \n"));
				arASum[i] += arrIncome[i][j];
				arBSum[j] += arrIncome[i][j];
				sum += arrIncome[i][j];
			}
		}
		
		//평균액 
		for (int i = 0; i < arAAvg.length; i++) {
			arAAvg [i] = Double.parseDouble(String.format("%.2f", (double) arASum [i] / arBSum.length));
			
		}
		for (int i = 0; i < arBAvg.length; i++) {
			arBAvg [i] = Double.parseDouble(String.format("%.2f", (double) arBSum [i] / arASum.length));
		}
		avg = Double.parseDouble(String.format("%.2f", (double) sum / (rLength * cLength)));
		
		//결과 출력
		for (int i = 0; i < rLength; i++) {
			for (int j = 0; j < cLength; j++) {
				result += arrName[i][j] + "매출액 : " + arrIncome [i][j] + "만원\n";
			}
			//연령별 매출액
			result += arAName [i] + " 총 매출액 : " + arASum [i] + "만원\n";
			result += arAName [i] + " 평균 매출액 : " + arAAvg [i] + "만원\n";
			result += "_________________________________\n";
		}
		
		for (int i = 0; i < arBSum.length; i++) {
			result += arBName [i] + "총 매출액 : " + arBSum [i] + "만원\n";
			result += arBName [i] + "평균 매출액 : " + arBAvg [i] + "만원\n";
			result += "_________________________________\n";
			}
		result += "총 매출액 : " + sum + "만원\n";
		result += "평균 매출액 : " + avg + "만원\n";
		result += "_________________________________\n";
		JOptionPane.showMessageDialog(null, result);
		
		}
	}
