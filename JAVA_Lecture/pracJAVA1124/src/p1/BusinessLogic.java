package p1;

public class BusinessLogic {
	void start ( ) {
		RemoteControl rc = null; //인터페이스를 참조변수로 사용하기 위하여 선언
		RemoteControl rcadio = null;
		
		rc = new SmartTelevsion();
		rc.turnOn();
		rc.setVolume(7);
		rc.setMute(true);
		rc.turnOff();
		
		//search() 호출하기
		//down casting 하기
		SmartTelevsion sm = (SmartTelevsion) rc;
		sm.search("KBS");
		
		rcadio = new Audio();
		rcadio.turnOn();
		rcadio.setVolume(5);
		rcadio.setMute(true);
		rcadio.turnOff();
		
		Audio audio = (Audio) rcadio;
		audio.search("FM11.3");
		audio.chatting("사랑해요 여러분");
	}
}
