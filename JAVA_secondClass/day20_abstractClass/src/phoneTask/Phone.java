package phoneTask;
/*
 * Phone 내에서 모든 핸드폰이 사용하는 기능정의
 * Phone2G, Phone3G, Phone4G 에 구현
 * User 클래스에서 3가지 전부 사요해보기
 */
public interface Phone {
	void msg(String num, String text);
	void	call(String num);
	void useInternet();
}
