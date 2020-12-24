package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import vo.BoxOfficeVO;

public class BoxOfficeDAO {
	
	/**
	 * 랭킹 넘기면 삽입, 아니면 추가
	 * @param vo
	 * @return
	 * @throws IOException
	 */
	//추가와 삽입
	//해당 파일에 추가하고 싶을 때에는 사용자가 해당 메소드만 사용하도록 한다(편의성 제공)
	public boolean insertORappend(BoxOfficeVO vo) throws IOException{
		//정보가 null로 들어왔다면 추가 실패
		if(vo == null) {return false;}

		//사용자가 전달한 ranking을 가져온다.
		int ranking = vo.getRanking();
		
		//추가 성공 여부 FLAG
		boolean check = false;
		
		if(ranking == 0) {
			//랭킹을 전달하지 않았다면 마지막에 추가
			check = append(vo);
			
		}else {
			//랭킹을 전달했다면 해당 랭킹에 삽입
			
			//마지막 순위와 사용자가 전달한 순위를 비교한다.
			//삽입할 수 있는 순위라면 insert()를 호출해서 삽입해준다.
			//new String(Files.readAllBytes(Paths.get(DBConnecter.PATH))) : 전체 내용 문자열 값
			//전체 내용 문자열 값.split("\n") : 배열에 각 행을 각 칸에 저장(\n을 기준으로 분리)
			//전체 내용 문자열 값에서 \n을 기준으로 분리하여 각 행을 각 칸에 저장한 배열.length : 그 길이
			if(ranking <= new String(Files.readAllBytes(Paths.get(DBConnecter.PATH))).split("\n").length) {
				check = insert(vo);
			}
		}
		return check;
	}
	
	
	//삽입
	//외부에서 삽입할 영화 정보를 Model객체로 전달받는다.
	private boolean insert(BoxOfficeVO vo) throws IOException{
//		if(vo == null) {return false;}
		
		BufferedReader br = DBConnecter.getReader();
		
		//해당 경로에 파일이 존재하지 않을 때
		if(br == null) {return false;} 
		
		String line = null;
		
		//사용자가 전달한 ranking은 삽입하고 싶은 행 번호이다.
		String film = vo.getRanking() + "\t" + vo.getFilm_name() + "\t" + vo.getRelease_date() + "\t"
				+ vo.getIncome() + "\t" + vo.getAudience_cnt() + "\t"
						+ vo.getScreen_cnt() + "\n";
		
		//삽입이 모두 완료된 문자열 값을 저장할 변수
		String temp = "";
		
		boolean check_insert = false;
		
		while((line = br.readLine()) != null) {
			//Integer.parseInt(line.split("\t")[0] : 각 행별 순위
			if(Integer.parseInt(line.split("\t")[0]) == vo.getRanking()) {
				//삽입
				temp += film;
				
				//삽입 완료 시 flag true
				check_insert = true;
			}
			
			if(check_insert) {
				//삽입이 되었을 때
				//Integer.parseInt(lint.split("\t")[0] + 1 : 위에서 영화 한 편이 삽입 되었기 때문에 내 순위가 하나 밀림
				//20	극한직업	...	...	... : 영화 한 편의 정보
				//20\t극한직업\t...\t...\t... : 각 구분은 \t로 구분된다.
				//"20\t극한직업\t...\t...\t...".substring(첫번째 \t의 인덱스) : 순위를 제외한 나머지 정보
				temp += Integer.parseInt(line.split("\t")[0]) + 1 + line.substring(line.indexOf("\t")) + "\n";
			}else {
				//삽입이 안되었을 때
				temp += line + "\n";
			}
		}
		
		br.close();
		
		BufferedWriter bw = DBConnecter.getWriter();
		//덮어쓰기
		bw.write(temp);
		bw.close();
		
		return true;
	}
	//추가
	//외부에서 추가할 영화 정보를 Model객체로 전달받는다.
	private boolean append(BoxOfficeVO vo) throws IOException{
//		if(vo == null) {return false;}
		
		BufferedReader br = DBConnecter.getReader();
		
		//해당 경로에 파일이 없다면
		if(br == null) {return false;}
		
		//외부저장소에 있는 내용 중 한 줄을 담아줄 변수
		String line = null;
		int last_ranking = 0;
		
		//line이 null일 때 탈출
		while((line = br.readLine()) != null) {
			//행 개수만큼 last_ranking은 1씩 증가한다.
			//while문을 탈출하면 last_ranking에 담긴 정수와 마지막 순위는 동일하다.
			last_ranking++;
		}
		
		br.close();

		//String 생성자에 byte배열을 전달하면 문자열 값으로 변환된다.
		//readAllbytes()를 사용해서 해당 경로에 있는 파일의 모든 내용을 byte[]로 가져온다.
		//※ \n까지 가져온다.
		String content = new String(Files.readAllBytes(Paths.get(DBConnecter.PATH)));
		
		BufferedWriter bw = DBConnecter.getAppend();

		String film = "";
		
		//content.charAt(content.length() - 1) : 내용 중 가장 마지막 문자
		if(content.charAt(content.length() - 1) != '\n') {
			//마지막에 줄바꿈이 없다면 추가할 정보 앞에 \n을 붙여준다.
			film = "\n";
		}
		
		//사용자가 전달한 추가할 정보 앞에 마지막 순위 + 1 을 연결해준다.
		film += ++last_ranking + "\t" + vo.getFilm_name() + "\t" + vo.getRelease_date() + "\t"
				+ vo.getIncome() + "\t" + vo.getAudience_cnt() + "\t"
						+ vo.getScreen_cnt() + "\n";
		
		//추가할 정보를 해당 경로에 있는 파일의 마지막 줄에 추가해준다. 
		bw.write(film);
		bw.close();
		return true;
	}
	//영화 제목 수정(update)
	//**참고** 전체 수정은 외부에서 인덱스 번호를 전달받아야 한다.
	public boolean update(int ranking, String new_film_name) throws IOException{
		//외부에서 영화 제목을 받아오면 중복될 수 있으므로, 중복이 없는 ranking을 조회해서 수정한다.
		BufferedReader br = DBConnecter.getReader();
		boolean check = false;
		if(br == null) {return check;}
		
		String line = null;
		String temp = "";
		
		
		while((line = br.readLine()) != null) {
			
			//contains : 해당 문자 혹은 문자열이 포함되어 있으면 참
			//equals   : 똑같아야 참
			if(Integer.parseInt(line.split("\t")[0]) == ranking) {
				//data:명량	2014-07-30	135,748,398,910	17,613,682	1,587
				String data = line.substring(line.indexOf("\t") + 1);
				//data.substring(data.indexOf("\t")):	2014-07-30	135,748,398,910	17,613,682	1,587
				temp += line.split("\t")[0] + "\t" + new_film_name + data.substring(data.indexOf("\t")) + "\n";
				
				//하나라도 수정되었다면 flag true
				check = true;
				continue;
			}
			temp += line + "\n";
		}
		if(check) {
			//수정완료된 내용으로 덮어쓰기
			BufferedWriter bw = DBConnecter.getWriter();
			bw.write(temp);
			bw.close();
		}
		return check;
	}
	
	//삭제
	public boolean delete(int ranking) throws IOException{
		BufferedReader br = DBConnecter.getReader();
		if(br == null) {return false;}

		String line = null;

		String temp = "";
		
		boolean check = false;
		
		while((line = br.readLine()) != null) {
			if(Integer.parseInt(line.split("\t")[0]) == ranking) {
				check = true;
				//기존의 정보를 스킵(삭제)
				continue;
			}
			
			if(check) {
				//위에서 삭제가 되었다면 그 밑에 있던 영화들이 위로 한 칸씩 올라가므로
				//순위를 하나씩 올려준다.
				temp += Integer.parseInt(line.split("\t")[0]) - 1 + line.substring(line.indexOf("\t")) + "\n";
			}else {
				temp += line + "\n";
			}
		}
		
		if(check) {
			BufferedWriter bw = DBConnecter.getWriter();
			bw.write(temp);
			bw.close();
		}
		
		return check;
	}
	
	//수정, 삭제하기 전에 사용할 검색
	public ArrayList<BoxOfficeVO> selectForUpdateAndDelete(String keyword) throws IOException{
		//외부에서 전달받은 키워드가 포함된 영화제목 검색
		
		//검색 결과는 여러 개일 수 있으므로 ArrayList에 담아준다.
		ArrayList<BoxOfficeVO> selected_films = new ArrayList<>();
		BufferedReader br = DBConnecter.getReader();
		if(br == null) {return null;}
		
		String line = null;

		while((line = br.readLine()) != null) {
			//영화 한 개의 정보들을 각각 분리한 후 배열의 각 방에 대입
			String[] arTemp = line.split("\t");
			
			//arTemp[1] : 영화 제목
			if(arTemp[1].contains(keyword)) {
				BoxOfficeVO film = new BoxOfficeVO();
				
				//모델 객체에 정보 담기
				film.setRanking(Integer.parseInt(arTemp[0]));
				film.setFilm_name(arTemp[1]);
				film.setRelease_date(arTemp[2]);
				
				//모델객체를 ArrayList에 추가하기
				selected_films.add(film);
			}
		}
		br.close();
		
		//하나도 안담겼으면 검색결과가 없으므로 null 리턴
		return selected_films.size() == 0 ? null : selected_films;
	}
	
	//검색
	public ArrayList<BoxOfficeVO> select(String keyword) throws IOException{
		BufferedReader br = DBConnecter.getReader();
		if(br == null) {return null;}
		
		ArrayList<BoxOfficeVO> films = new ArrayList<>();
		
		String line = null;
		
		while((line = br.readLine()) != null) {
			if(line.split("\t")[1].contains(keyword)) {
				String[] arFilm = line.split("\t");
				BoxOfficeVO film = new BoxOfficeVO();
				
				//모델 객체에 검색된 정보 하나씩을 담아준다.
				film.setRanking(Integer.parseInt(arFilm[0]));
				film.setFilm_name(arFilm[1]);
				film.setRelease_date(arFilm[2]);
				//기본 정보에 숫자는 ,를 사용하였기 때문에 ,를 replaceAll()을 통해서 없애준다.
				film.setIncome(Long.parseLong(arFilm[3].replaceAll(",", "")));
				film.setAudience_cnt(Integer.parseInt(arFilm[4].replaceAll(",", "")));
				film.setScreen_cnt(Integer.parseInt(arFilm[5].replaceAll(",", "")));
				
				films.add(film);
			}
		}
		return films.size() == 0 ? null : films;
	}
	
	//목록
	public String selectAll() throws IOException{
		return new String(Files.readAllBytes(Paths.get(DBConnecter.PATH)));
	}
}




