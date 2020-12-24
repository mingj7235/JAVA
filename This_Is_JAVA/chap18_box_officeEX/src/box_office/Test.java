package box_office;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.BoxOfficeDAO;
import vo.BoxOfficeVO;

public class Test {
	public static void main(String[] args) throws IOException{
		
		BoxOfficeDAO dao = new BoxOfficeDAO();
		
		System.out.println(dao.selectAll());
		
//
//		for(BoxOfficeVO film : dao.select("국")) {
//			System.out.println(film.getFilm_name());
//		}
		
//		if(dao.delete(3)) {
//			System.out.println("삭제 성공");
//		}else {
//			System.out.println("삭제 실패");
//		}
		
		//수정
//		BoxOfficeDAO dao = new BoxOfficeDAO();
//		Scanner sc = new Scanner(System.in);
//		
//		String keyword = null;
//		
//		System.out.println("수정하실 영화 제목 혹은 키워드를 입력해주세요.");
//		keyword = sc.next();
//		
//		ArrayList<BoxOfficeVO> films = dao.selectForUpdateAndDelete(keyword);
//		
//		String choiceYN = null;
//		
//		if(films == null) {
//			System.out.println("검색된 영화가 없습니다.");
//		}else if(films.size() == 1) {
//			BoxOfficeVO film = films.get(0);
//			System.out.println(film.getFilm_name() + " 영화 제목을 수정하시겠습니까?[y, n]");
//			choiceYN = sc.next().toLowerCase();
//			
//			if(choiceYN.equals("y")) {
//				System.out.println("새로운 영화 제목을 입력해주세요.");
//				if(dao.update(film.getRanking(), sc.next())) {
//					System.out.println("수정 성공");
//				}else {
//					System.out.println("수정 실패");
//				}
//			}else {
//				System.out.println("다시 검색해주세요.");
//			}
//			
//		}else {
//			int idx = 0;
//			for(BoxOfficeVO film : films) {
//				System.out.println(++idx + ". " + film.getFilm_name() + "(" + film.getRelease_date() + ")");
//			}
//			System.out.println("수정하실 영화의 번호를 선택하세요.");
//			int choice = films.get(sc.nextInt() - 1).getRanking();
//			
//			System.out.println("새로운 영화 제목을 입력하세요.");
//			System.out.println(dao.update(choice, sc.next()) ? "수정 성공" : "수정 실패");
//		}
	}
}




























