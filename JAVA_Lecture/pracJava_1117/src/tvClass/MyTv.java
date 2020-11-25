package tvClass;

public class MyTv {
	boolean isPowerOn;
	int channel;
	int volume;
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	void turnOnOff () {
		if (isPowerOn) {
			System.out.println("TV가 꺼졌습니다.");
			isPowerOn = false;
		}else {
			System.out.println("TV가 켜졌습니다.");
			isPowerOn = true;
		}
	}
	void volumeUp () {
		if (volume < MAX_VOLUME) {
			volume ++;
		} 
	}
	
	void volumeDown () {
		if (volume > MIN_VOLUME) {
			volume --;
		}
	}
	
	void channelUp () {
		
		
	}
	
	
	
}
