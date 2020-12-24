package vo;

public class BoxOfficeVO {
	//alt + shift + a : 그리드 모드(커서 확장 : shift 방향키)
	//순위
	private int ranking;
	//영화명
	private String film_name;
	//개봉일
	private String release_date;
	//매출액
	private long income;
	//관객수
	private int audience_cnt;
	//스크린수
	private int screen_cnt;
	
	public BoxOfficeVO() {;}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getFilm_name() {
		return film_name;
	}

	public void setFilm_name(String film_name) {
		this.film_name = film_name;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public int getAudience_cnt() {
		return audience_cnt;
	}

	public void setAudience_cnt(int audience_cnt) {
		this.audience_cnt = audience_cnt;
	}

	public int getScreen_cnt() {
		return screen_cnt;
	}

	public void setScreen_cnt(int screen_cnt) {
		this.screen_cnt = screen_cnt;
	}
}











