package view;

//사용자 예외 만들기
public class RecordNotFoundException extends Exception {
	public RecordNotFoundException(String msg) {
		super(msg); 
	}
}
