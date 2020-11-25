package inheritance;

public class PhoneEx {
	public static void main(String[] args) {
		MusicPhone mup = new MusicPhone();
		mup.call();
		mup.charge();
		mup.connect();
		mup.musicDown();
		mup.playMusic();
		mup.respond();
		
		MobilePhone mop = new MobilePhone();
		mop.call();
		mop.charge();
		mop.connect();
		mop.respond();
		//자식의 메소드는 사용할 수 없다. 
	}
}
