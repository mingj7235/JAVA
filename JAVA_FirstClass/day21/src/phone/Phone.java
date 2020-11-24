package phone;

/*
 * Phone 인터페이스(추상클래스) 내에서 모든 핸드폰이 사용하는 기능 정의
 * Phone2G, Phone3G, Phone4G에 구현한다.
 * User 클래스에서 3가지 전부 사용해보기
 */
public interface Phone {
	void msg (String tMsg, String telNum);
	void call (String telNum);
	void useInternet();


}
