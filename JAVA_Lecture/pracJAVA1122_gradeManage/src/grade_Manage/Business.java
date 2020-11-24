package grade_Manage;

import java.util.Scanner;

public class Business {
	Scanner sc = new Scanner(System.in);
	School data [][] = new School[3][5]; //학교당 5개 과목 입력가능
	int eleNum = 0, mdlNum = 0, highNum = 0;

	public int main() { //메인메뉴 선택
		System.out.println("-------------");
		System.out.println("1.입력 2.조회");
		System.out.println("-------------");
		System.out.print("선택-> ");
		return sc.nextInt();
	}

	public int choiceSc() {
		System.out.println("-----------학교 선택-----------");
		System.out.println("1.초등학교 2.중학교 3.고등학교");
		System.out.println("------------------------------");
		System.out.print("선택-> ");
		return sc.nextInt() - 1;
	}
	
	public void input(int school) {
		School a = new High();
		System.out.print("과목명: ");
		a.subject = sc.next();
		System.out.print("중간고사: ");
		a.middleSc = sc.nextInt();
		System.out.print("기말고사: ");
		a.endSc = sc.nextInt();
		System.out.print("수행평가: ");
		a.performSc = sc.nextInt();
		a.score = a.middleSc + a.endSc + a.performSc;

		if(school == 0) { //초등학교
			data[school][eleNum++] = (Elementary) a;
		}else{//중학교 또는 고등학교
			Middle tmp = (Middle) a;
			System.out.print("출석점수: ");
			tmp.attendance = sc.nextInt();
			System.out.print("봉사점수: ");
			tmp.volunteer = sc.nextInt();
			System.out.print("담당교사: ");
			tmp.teacher = sc.next();
			a.score += tmp.attendance + tmp.volunteer;
			if(school == 1) { //중학교
				data[school][mdlNum++] = tmp;				
			}else { //고등학교
				High tmp2 = (High) tmp;
				tmp2.deviation = 1234;
				data[school][highNum++] = tmp2;								
			}
		}
	}
	public void output(int school) {
		String schoolName;
		if(school == 0) schoolName = "초등학생";
		else if(school == 1) schoolName = "중학생";
		else schoolName = "고등학생";
		System.out.println("----------------------");
		System.out.println(schoolName+" 성적입니다.");
		System.out.println("----------------------");
		for (int i = 0; i < data[school].length; i++) {
			if(data[school][i] == null) break;
			Middle tmp = (Middle)data[school][i];
			System.out.println("과목명: "+data[school][i].subject);
			if(school != 0) {
				System.out.println("담당교사: "+tmp.teacher);				
			}
			System.out.print("시험: 중간고사: "+data[school][i].middleSc+", 기말고사: "+data[school][i].endSc
					+", 수행평가: "+data[school][i].performSc);
			if(school != 0) {
				System.out.print(", 출석점수: "+tmp.attendance+", 수행평가: "+tmp.volunteer);
			}
			System.out.println("\n점수: "+data[school][i].score);
			if(school == 2) {
				High tmp2 = (High)data[school][i];
				System.out.println("표준편차: " + tmp2.deviation);
			}
			System.out.println("\n");
		}
	}
}
