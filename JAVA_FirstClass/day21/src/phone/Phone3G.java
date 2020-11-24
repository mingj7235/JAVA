package phone;

public class Phone3G implements Phone{

	@Override
	public void msg(String tMsg, String telNum) {
		System.out.println("\""+ telNum+ "\""+"으로부터 문자메세지가 도착했습니다 : \n" + tMsg);
	}

	@Override
	public void call(String telNum) {
		System.out.println("\""+ telNum+ "\""+ "에게서 전화가 왔습니다.");
	}
	
	@Override
	public void useInternet() {
		System.out.println("웹 서핑중");
		
	}
}
