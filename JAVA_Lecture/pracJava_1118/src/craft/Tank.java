package craft;

public class Tank extends Unit {
	int x = 150;
	int y = 150;
	
	@Override
	void move(int x, int y) {
		this.x = x -50;
		this.y = y+ 50;
		System.out.println("탱크의 위치 : " + this.x + ", " + this.y);
	}
	
	@Override
	void stop() {
		System.out.print("탱크 ");super.stop();
	}
	
	
	
	void changeMode () {
		System.out.println("탱크 공격모드를 변환한다");
	}
}
