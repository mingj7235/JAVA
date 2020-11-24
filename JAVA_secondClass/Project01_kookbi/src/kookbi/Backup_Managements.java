package kookbi;

//2020.11.04 백업

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
public class Backup_Managements {
		Scanner sc = new Scanner(System.in);
		final public int SUBJECTS = 3;
//		ArrayList<Students> arStudents = null;
		ArrayList<Integer> arScores = null;
		LinkedHashMap<Students, ArrayList<Integer>> StudentsBook = new LinkedHashMap<>();
		
		public void view () {
			int choice = 0;
			do {
				System.out.println("<코리아 IT 아카데미 학생부 관리 시스템>"
						+ "\n1. 학생부 등록"
						+ "\n2. 학생부 검색"
						+ "\n3. 학생부 삭제"
						+ "\n4. 학생부 수정"
						+ "\n5. 학생부 조회"
						+ "\n6. 장학생 조회"
						+ "\n7. 재수강 대상자 조회"
						+ "\n8. 시스템 종료");
				System.out.print("\n사용하실 메뉴의 번호 입력 : ");
				try {
					choice = sc.nextInt();
				} catch (Exception e) {
					System.out.println("숫자를 1~8까지만 입력해주세요.");
					break;
				}
				sc.nextLine();
				
				if (choice == 8) break;
				switch (choice) {
				case 1:
					insert();
					break;
				case 2:
					search();
					break;
				case 3:
					delete();
					break;
				case 4:
					update();
					break;
				case 5:
					list (StudentsBook);
					break;
				case 6:
					list_scholarship(StudentsBook);
					break;
				case 7:
					list_fail_students(StudentsBook);
					break;
				default :
					System.out.println("잘못 입력하셨습니다.");
				}
			} while(true) ;
		}
		
		void insert () {
			while (true) {
				System.out.print("♡[학생부 등록]♡"
						+ "\n학생 등록을 진행하시겠습니까? (y/n) : ");
				String choice = "";
				choice = sc.nextLine();
				boolean flag = false;
				if (choice.equals("y") || choice.equals("Y")) {
					System.out.print("등록할 학생 이름을 적어주세요. : ");
					String name = sc.nextLine();
					System.out.print(""+ name + "학생의 나이 : ");
					int age = sc.nextInt();
					sc.nextLine();
					int total= 0, avg = 0, score = 0;
					arScores = new ArrayList<>();
					System.out.println(name + "학생의 점수를 입력하세요.\n" + 
							"C언어 JAVA Spring  순서대로 적어주세요.\n" + 
							"예시> 100 80 70");
					for (int i = 0; i < SUBJECTS; i++) {
						score = sc.nextInt();
						if (score < 0 || score > 100) {
							flag = true;
							System.out.println("점수는 0점 ~ 100점 사이입니다. 처음으로 돌아갑니다. \n" );
							continue;
						} else {
							arScores.add(score);
						}
					}if (flag) {
						break;
					}
					Students std = new Students(name, age);
//					arStudents = new ArrayList<>();
//					arStudents.add(std);
					//평균점수 등록
					for (int j = 0; j < SUBJECTS; j++) {
						total +=arScores.get(j);
					}
					avg = (total / SUBJECTS);
					arScores.add(avg);
					StudentsBook.put(std, arScores);
					System.out.println(name + "학생의 정보가 입력되었습니다.\n");
					sc.nextLine();
					list(StudentsBook);
					continue;
				} else if (choice.equals("n") || choice.equals("N")) {
					System.out.println("학생 등록을 취소합니다.");
					break;
				}
			}
		}
		
		void search () {
			Iterator<Students> iter = StudentsBook.keySet().iterator();
			String name = null;
			System.out.println("♡[학생 검색]♡");
			System.out.print("검색할 학생의 이름 : ");
			name = sc.nextLine();
			System.out.println("====[검색 결과]====");
			while(iter.hasNext()) {
				Students std = iter.next();
				if(name.equals(std.getName())) {
					std.show();
					System.out.println("===C언어===JAVA===Spring===평균===");
					for(int score: StudentsBook.get(std)) {
						System.out.print("=="+ score + "점==");
					}
					if (StudentsBook.get(std).get(3) >= 85) {
						System.out.println("\n축하합니다. " + name + "학생은 장학생입니다.");
					} else if (StudentsBook.get(std).get(3) <= 60) {
						System.out.println("\n"+name+ "학생은 재수강 대상자입니다. 분발하세요.");
					} else {
						System.out.println("\n");
					}
				}
			}
		}
		
		void update () {
			boolean flag = false;
			list(StudentsBook);
			int num = 0, choice = 0;
			System.out.print("수정할 학생의 번호 : ");
			num = sc.nextInt();
			Iterator<Students> iter = StudentsBook.keySet().iterator();
			while (iter.hasNext()) {
				Students std = iter.next();
				if (num == std.getNumber()) {
					flag = true;
					System.out.println("1. 신상정보 수정"
							+ "\n2. 점수수정");
					choice = sc.nextInt();
					sc.nextLine();
					switch (choice) {
					case 1 :
						System.out.println("[신상정보 수정]"
								+ "\n이름, 나이를 순서대로 입력하세요.");
						std.setName(sc.next());
						std.setAge(sc.nextInt());
						sc.nextLine();
						System.out.println("신상정보 수정 완료");
						break;
					case 2: 
						int total = 0, avg = 0;
						System.out.println("각 과목의 점수를 순서대로 입력하세요. "
								+ "\n(C언어 JAVA Spring)");
						for (int i = 0; i < SUBJECTS; i++) {
							StudentsBook.get(std).set(i, sc.nextInt());
						}
						for (int j = 0; j < SUBJECTS; j++) {
							total +=StudentsBook.get(std).get(j);
						}
						avg = (total / SUBJECTS);
						StudentsBook.get(std).set(3, avg);
						sc.nextLine();
						System.out.println("수정완료");
						break;
					default :
						flag = false;
						System.out.println("수정 실패");
					}
				}
			}
			if (!flag) {
				System.out.println("수정할 학생의 번호를 다시 확인해 주세요.");
			}
			list(StudentsBook);
		}
		
		void delete () {
			int num = 0;
			Students delStd = null;
			System.out.println("♡[학생부 삭제]♡"
					+ "\n삭제할 학생의 번호를 입력해주세요 : ");
			num = sc.nextInt();
			sc.nextLine();
			
			Iterator<Students> iter = StudentsBook.keySet().iterator();
			while (iter.hasNext()) {
				Students std = iter.next();
				if (num == std.getNumber()) {
					delStd =std;
				}
			}
			if(delStd == null) {
				System.out.println("찾는 학생이 없습니다. 다시 확인해주세요.");
			}else {
				StudentsBook.remove(delStd);
				System.out.println("해당 번호의 학생이 삭제 되었습니다.");
				list(StudentsBook);
			}
		}
		
		void list (LinkedHashMap<Students, ArrayList<Integer>> book) {
			Iterator<Map.Entry<Students, ArrayList<Integer>>> iter = book.entrySet().iterator();
			int size = StudentsBook.size();
			if (size == 0) {
				System.out.println("등록된 학생이 없습니다. 다시 확인해주세요.");
			}else {
				System.out.println("♡[코리아 IT 아카데미 학생]♡");
				while (iter.hasNext()) {
					Entry<Students, ArrayList<Integer>> temp = iter.next();
					temp.getKey().show();
					System.out.println("===C언어===JAVA===Spring===평균===");
					for (int score : temp.getValue()) {
						System.out.print("=="+ score + "점==");
					}
					System.out.println("\n");
				}
			}
		}
		
		void list_scholarship (LinkedHashMap<Students, ArrayList<Integer>> book) {
			Iterator<Map.Entry<Students, ArrayList<Integer>>> iter = book.entrySet().iterator();
			int size = StudentsBook.size();
			int avg = 0;
			boolean flag = false;
			if (size == 0)  {
				System.out.println("등록된 학생이 없습니다. 다시 확인해주세요.");
			}else {
				System.out.println("♥[코리아 IT 아카데미 장학생]♥"
						+ "\n(장학생은 평균점수 85점 이상인 학생들입니다.)");
				while (iter.hasNext()) {
					Entry<Students, ArrayList<Integer>> std = iter.next();
					avg = std.getValue().get(3);
					if (avg >= 85) {
						System.out.println("★장학생 : " + std.getKey().getName()+"★");
						flag = true;
					}
				}
			}
			if (!flag) {
				System.out.println("장학생은 없습니다.\n");
			}
		}
		
		void list_fail_students (LinkedHashMap<Students, ArrayList<Integer>> book) {
			Iterator<Map.Entry<Students, ArrayList<Integer>>> iter = book.entrySet().iterator();
			int size = StudentsBook.size();
			int avg = 0;
			boolean flag = false;
			if (size == 0) {
				System.out.println("등록된 학생이 없습니다. 다시 확인해주세요.");
			}else {
				System.out.println("◆[재수강 대상자]◆"
						+ "\n(재수강 대상자는 평균점수 60점 아래인 학생들입니다.)");
				while (iter.hasNext()) {
					Entry<Students, ArrayList<Integer>> std = iter.next();
					avg = std.getValue().get(3);
					if (avg <= 60) {
						System.out.println("♠재수강 대상자 : " + std.getKey().getName()+"♠");
						flag = true;
					}
				}
			}
			if (!flag) {
				System.out.println("재수강 대상자는 없습니다.\n");
			}
		}
	}

