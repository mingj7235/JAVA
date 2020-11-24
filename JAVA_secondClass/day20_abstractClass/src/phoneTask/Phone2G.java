package phoneTask;

public class Phone2G extends PhoneAdapter{

	@Override
	public void msg(String num, String text) {
		System.out.println(num + "에게 전송중" + "\n내용 : " + text);
	}

	@Override
	public void call(String num) {
		System.out.println(num + "에게 전화 거는중");
	}
	
}
