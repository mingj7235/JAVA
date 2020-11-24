package p1;
//구현 클래스의 부모로 사용할 필드나 메소드 (상속보다 더 강력하다)
public interface RemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	void turnOn();
	void turnOff();
	void setVolume (int volume);
	
	default void setMute (boolean mute) {
		if (mute) {
			System.out.println("무음 처리 합니다.");
		}else {
			System.out.println("무음 헤제합니다.");
		}
	}
}
