package craft;

public class Dropship extends Unit {
	int x = 1100;
	int y = 2500;
	
	@Override
	void move(int x, int y) {
		this.x = x -100;
		this.y = y- 500;
		System.out.println("드랍쉽의 위치 : " + this.x + ", " + this.y);
	}
	
	@Override
	void stop() {
		System.out.print("드랍쉽 ");super.stop();
	}
	void load (int a, int b) {
		System.out.println("드랍쉽 보병위치" + "(" +a + "," 
				+ b + ")" +"에서 보병을 태운다.");
	}
	void unload (int a, int b) {
		System.out.println("드랍쉽 탱크위치" + "(" +a + "," 
				+ b + ")" +"에서 탱크을 내린다.");
	}
}
