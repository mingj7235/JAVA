package forTest;

public class Arr {
	public static void main(String[] args) {
//		String [] arData = {"안녕", "반가워", "이름이", "뭐니?"};
//		
//		//빠른for문
//		for(String i : arData) {
//			System.out.println(i);
//		}
		
		int [][] arrScore = {
				{10, 20, 30}, //1번학생
				{11, 25, 39}, //2번학생
				{12, 26, 38}, //3번학생
				{13, 27, 37}, //4번학생
 				{13, 28, 36}  //5번학생
		};
		int total = 0;
		double avg = 0.0;
		int cnt = 0;
		//각 학생별 총점과 평균 출력하기 빠른포문으로
		
		for(int [] arScore : arrScore) {
			total = 0;
			//초기화 안시켜주면 누적이되서 오류남.
			//시작할때 total을 0으로 초기화시키는 것임. 
			cnt++;
			for(int score : arScore) {
				total += score;
			}
			avg = Double.parseDouble(String.format("%.2f", (double) total / arScore.length));
			System.out.println(cnt +"번 총점 : " + total+ "점");
			System.out.println(cnt + "번 평균 : " + avg + "점");
		}
		
	}
}
