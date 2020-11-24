package day10;


import javax.swing.JOptionPane;

public class ArrShop {
	//나이키
	//강남점, 홍대점, 명동점
	//성인, 키즈
	// 강남점 키즈, 홍대점 키즈, 명동점 키즈
	// 강남점 성인, 홍대점 성인, 명동점 성인
	public static void main(String[] args) {
		int [][] arrIncome = new int [2][3]; 
		int [] arASum = new int [2];
				//연령별이니까 A K 두가지니까 2열짜리 배열
		int [] arBSum = new int [3];
				//지점별이니까 3가지니까 3열짜리 배열
		int sum = 0; 
		double [] aAvg = new double [2];
		double [] bAvg = new double [3];
		double avg = 0.0;
		
		int rLength = arrIncome.length;
		int cLength = arrIncome[0].length;
		String result = "__________________________\n";
		
		String [][] arrName = {
				{"강남점 A", "홍대점 A", "명동점 A"},
				{"강남점 K", "홍대점 K", "명동점 K"}
		};
		
		String [] arAName = {"성인", "키즈"};
		String [] arBName = {"강남점", "홍대점", "명동점"};
		
		String inputMsg = "매출액을 입력하세요.";
//2행 3열이니까 2중 for문을 쓴다. 				
		for (int i = 0 ; i < rLength; i++) {
			for (int j = 0; j < cLength; j++) {
				arrIncome[i][j] = Integer.parseInt(JOptionPane.showInputDialog(arrName[i][j] + " " + inputMsg));
				// 연령별 sum을 누적시킨 것. 
				arASum[i] += arrIncome [i][j];
				// 지점별이라서 j 를 고정시키고 arrIncome 값을 누적시킨 것. 
				arBSum[j] += arrIncome [i][j];
				sum += arrIncome[i][j];
				//총 매출액

			}
		}
		for (int i = 0 ; i <aAvg.length; i++) {
			aAvg[i] = Double.parseDouble(String.format("%.2f", (double)arASum[i] / arBSum.length));
		}
		for (int i = 0 ; i <bAvg.length; i++) {
			bAvg[i] = Double.parseDouble(String.format("%.2f", (double)arBSum[i] / arASum.length));
		//연령별 매출액 평균
		}
		
		avg = Double.parseDouble(String.format("%.2f", (double)sum / (rLength * cLength)));
		
		for (int i = 0 ; i < rLength ; i++) {
			for (int j = 0 ; j < cLength ; j++) {
				result += arrName [i][j] + "매출액 : " + arrIncome[i][j] + "만원\n";
				
			}
			//연령별 매출액
			result += arAName[i] + " 총 매출액 : " + arASum[i] + "만원\n";
			result += arAName[i] + " 평균 매출액 : " + aAvg[i] + "만원\n";
			result += "__________________________\n";
			
		}
		for (int i = 0 ; i < arBSum.length; i++) {
			result += arBName[i] + " 총 매출액 : " + arBSum[i] + "만원\n";
			result += arBName[i] + " 평균 매출액 : " + bAvg[i] + "만원\n";
			result += "__________________________\n";
		}
		
		result += "총 매출액 : " + sum + "만원\n";
		result += "평균 매출액 : " + avg + "만원\n";
		result += "__________________________\n";
		
		JOptionPane.showMessageDialog(null, result);
				
				
	}
}

