package craft;

public class Marine extends Unit {
	int x = 0;
	int y = 30;
	@Override
	void move(int x, int y) {
		this.x=x+10;
		this.y=y-10;
		System.out.println("보병의 위치 : " + this.x + ", " + this.y);
	}
	
	@Override
	void stop() {
		System.out.print("보병 ");super.stop();
	}
	
	void stimPack () {
		System.out.println("스팀팩을 사용한다.");
	}
}
