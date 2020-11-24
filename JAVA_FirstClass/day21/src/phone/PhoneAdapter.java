package phone;

public abstract class PhoneAdapter implements Phone {
	
	public void turnOn () {
		System.out.println("전원 켜기");
	}
	
	public void turnOff () {
		System.out.println("전원 끄기");
	}


	@Override
	public void msg(String tMsg, String telNum) {

	}

	@Override
	public void call(String telNum) {

	}
	
	@Override
	public void useInternet() {

	}

}
