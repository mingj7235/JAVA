package p1;

public class CaptionTV extends TV{
	String text;
	void caption() {
		System.out.println(text);
	}
	@Override
	void channelUp() {
		System.out.println("CaptionTV 채널 업");
		channel += 5;
	}
	@Override
	void channelDown() {
		System.out.println("Caption TV 채널 다운");
		channel -= 5;
	}
	void captionTVMethod () {
		System.out.println("CaptionTV의 자신의 메소드 부분");
	}
}
