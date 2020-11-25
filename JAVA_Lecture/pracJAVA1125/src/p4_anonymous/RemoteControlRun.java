package p4_anonymous;
//±¸Çö °´Ã¼ ¸¸µé±â
public class RemoteControlRun implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("±¸Çö°´Ã¼ ÄÑ±â");
	}

	@Override
	public void turnOff() {
		System.out.println("±¸Çö°´Ã¼ ²ô±â");
	}

}
