package p1;

public class Audio implements RemoteControl, Searchable{

	@Override
	public void search(String url) {
		System.out.println(url + " 채널을 겁색합니다.");
	}

	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("오디오를 끕니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		if (volume > MAX_VOLUME) {
			volume = MAX_VOLUME;
		}if (volume < MIN_VOLUME) {
			volume = MIN_VOLUME;
		}
		System.out.println("현재 볼륨은 " + volume +"입니다.");
	}
	
	public void chatting (String msg) {
		System.out.println(msg);
	}
	
}
