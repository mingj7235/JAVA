package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import dto.StudentVO;

public class ScoreDAO {
	//국영수
	public final int SUBJECT_SIZE = 3;
	public Scanner sc = new Scanner(System.in);
	private ArrayList<StudentVO> arStudent = null;
	private ArrayList<Integer> arScore = null;
	//저장소 : HashMap/ key값 : studentVO, values : arSocre의 타입인 arrayList(Integer) 
	private LinkedHashMap<StudentVO, ArrayList<Integer>> smsMap = new LinkedHashMap<>();
	//LinkedHashMap => 순서가 생긴다. 넣은대로 link가된다고생각하면됨. 넣은대로 연결이된다. 
	
	
	public void index () {
		//메인 view 단
		int choice = 0;
			do {
				System.out.println("학생 관리 시스템"
						+ "\n1. 등록"
						+ "\n2. 검색"
						+ "\n3. 삭제"
						+ "\n4. 수정"
						+ "\n5. 나가기");

				choice = sc.nextInt();
				//엔터 상쇄를 위해 sc.nextLine해줌
				sc.nextLine();
				if (choice == 5) break;
				switch (choice) {
				case 1:
					join();
					break;
				case 2:
					search();
					break;
				case 3 :
					delete();
					break;
				case 4 : 
					update();
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
				}
			} while (true);
	}
	
	public void join () {
		String isQuit = "";
		do {
			System.out.println("============[학생정보 입력(종료는 q)=============");
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("나이 : ");
			int age = sc.nextInt();
			
			//입력받을 때 엔터키를 먹기위해서 sc.nextLine();하나 더 써준것임
			sc.nextLine();
			StudentVO std = new StudentVO(name, age);
			arStudent = new ArrayList<>();
			arScore = new ArrayList<>();
			
			arStudent.add(std);
			//학생을 저장소에 입력!
			System.out.println("국어 영어 수학 점수를 입력하세요 \n예시 > 100 90 20");
			for (int i = 0; i < SUBJECT_SIZE; i++) {
				arScore.add(Integer.parseInt(sc.next()));
			}
			//점수가 arScore에 담김
			smsMap.put(std, arScore);
			//학생정보, 점수를 Map 저장소에 담음.
			System.out.println("종료?");
			
			//점수 입력 후 엔터 상쇄
			sc.nextLine();
			isQuit = sc.nextLine();
			
		}while(isQuit.intern() != "q");
		//intern()을해서 값을 비교해줘야한다. 그냥 isQuit != "q" 하면 안댐!!
		list(smsMap);
	}
	
	public void list (LinkedHashMap <StudentVO, ArrayList<Integer>> db) {
		Set<Entry<StudentVO, ArrayList<Integer>>> set = db.entrySet();
		Iterator<Map.Entry<StudentVO, ArrayList<Integer>>> iter = set.iterator();
		int size = smsMap.size();
		
		if (size == 0) {
			System.out.println("등록된 학생이 없습니다.");
		}else {
			System.out.println("======[가입 목록]======");
			while (iter.hasNext()) {
				//HashMap : FILO (First in Last Out)
				Entry<StudentVO, ArrayList<Integer>> temp = iter.next();
				temp.getKey().show();
				System.out.println("      국어      영어       수학");
				System.out.print("    ");
				for (int score : temp.getValue()) {
					System.out.print(score + "점    ");
				}
				System.out.println("\n");
			}
		}
	}
	
	public void search () {
		Set <StudentVO> scoreSet = smsMap.keySet();
		Iterator<StudentVO> iter = scoreSet.iterator();
		
		String name = null;
		System.out.println("검색할 학생의 이름 : ");
		name = sc.nextLine();
		
		System.out.println("======[검색 결과]======");
		while(iter.hasNext()) {
			StudentVO std = iter.next();
			if(name.equals(std.getName())) {
				std.show();
				System.out.println("      국어      영어       수학");
				System.out.print("    ");
				for(int score : smsMap.get(std)) {
					System.out.print(score + "점    ");
				}
				System.out.println("\n");
			}
		}
	}
	
	public void update () {
		list(smsMap);
		int num = 0, choice = 0;
		boolean isUser = false;
		System.out.println("수정할 학생의 번호 : ");
		num = sc.nextInt();
		
		Iterator<StudentVO> iter = smsMap.keySet().iterator();
		
		while(iter.hasNext()) {
			StudentVO std = iter.next();
			if (num == std.getNumber()) {
				isUser = true;
				System.out.println("1. 정보수정 \n2. 점수수정");
				choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1 :
					System.out.println("이름과 나이를 순서대로 입력하세요.");
					std.setName(sc.next());
					std.setAge(Integer.parseInt(sc.next()));
					sc.nextLine();
					//setter를 만들었으면 사용하자!!!! 오오오오!!!
					System.out.println("수정완료");
					break;
				case 2 :
					System.out.println("국어 영어 수학 점수를 선수대로 입력하세요.");
					for (int i = 0; i < SUBJECT_SIZE; i++) {
						smsMap.get(std).set(i, sc.nextInt());
					}
					sc.nextLine();
					System.out.println("수정완료");
					break;
				default:
					isUser = false;
					System.out.println("수정 실패");
				}
			}
		}
		if (!isUser) {
			System.out.println("수정하실 학생이 존재하지 않습니다. ");
		}
		list(smsMap);
	}
	
	public void delete () {
		//Iterator로 검색 (번호)
		int num = 0;
		StudentVO delStd = null;
		
		System.out.println("삭제할 학생의 번호를 입력하세요 : ");
		num = sc.nextInt();
		//엔터 상쇄
		sc.nextLine();
		
//		Set<StudentVO> stdSet = smsMap.keySet();
//		Iterator<StudentVO> iter = stdSet.iterator();
		Iterator <StudentVO> iter = smsMap.keySet().iterator();
		
		while(iter.hasNext()) {
			StudentVO std = iter.next();
			if (num == std.getNumber()) {
				delStd = std;
			}
		}
		if (delStd == null) {
			System.out.println("학생이 없습니다.");
		}else {
			smsMap.remove(delStd);
			System.out.println("삭제 완료");
			list(smsMap);
		}
		
	}
}
