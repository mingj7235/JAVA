

//Data (data transfer object)  데이터 전송 이동 객체, db처리하는데이용함 
public class MemberDTO {
	
	private String id;
	private String pwd;
	private String name;
	private String tel;
	private String addr;
	private String birth;
	private String job;
	private String gender; 
	private String email;
	private String date; // 등록날짜
	private String dateCheck; // 만료기간 

	// MenuDAO 테이블 컬럼 
	// id는 포린키 연동
	private String weight; // 몸무게
	private String height; // 키 

	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDateCheck() {
		return dateCheck;
	}
	public void setDateCheck(String dateCheck) {
		this.dateCheck = dateCheck;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() { // 테스트
		return "MemberDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", tel=" + tel + ", addr=" + addr
				+ ", birth=" + birth + ", job=" + job + ", gender=" + gender + ", email=" + email + ", date=" + date
				+ ", dateCheck=" + dateCheck + ", weight=" + weight + ", height=" + height + "]";
	}
	
// DTO 객체 확인
	// toString 자동생성 우클릭 source -> generate toString -> ok
	// 0.1h 패치전 
//	@Override
//	public String toString() {
//		return "MemberDTO [id = "+id+", pwd = "+pwd+", name = "+name+", tel = "+tel
//				+", addr = "+addr+", birth = "+birth+", job = "+job+", gender = "
//				+gender+", email = "+email+", date = "+date+", dateCheck = "+dateCheck+"]";
//	}
	
	
	
}
