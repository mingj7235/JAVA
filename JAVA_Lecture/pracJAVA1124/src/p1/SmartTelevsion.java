package p1;

public class SmartTelevsion implements RemoteControl, Searchable{
	private int volume;
	@Override
	public void search(String url) {
		System.out.println(url + "을 검색합니다.");
	}

	@Override
	public void turnOn() {
		System.out.println("스마트 TV 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("스마트 TV 끕니다.");
		
	}

	@Override
	public void setVolume(int volume) {
		if (volume > MAX_VOLUME) {
			volume = MAX_VOLUME;
		}if (volume < MIN_VOLUME) {
			volume = MIN_VOLUME;
		}
		System.out.println("현재 TV 볼륨은" + volume);
	}

}
