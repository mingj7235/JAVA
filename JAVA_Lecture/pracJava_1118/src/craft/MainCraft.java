package craft;

public class MainCraft {
	public static void main(String[] args) {
		Marine m1 = new Marine();
		Tank t1 = new Tank();
		Dropship ds1 = new Dropship();
		
		m1.move(m1.x, m1.y);
		m1.move(m1.x, m1.y);
		m1.stop();
		m1.stimPack();
		System.out.println();
		t1.move(t1.x, t1.y);
		t1.move(t1.x, t1.y);
		t1.stop();
		t1.changeMode();
		System.out.println();
		ds1.move(ds1.x, ds1.y);
		ds1.move(ds1.x, ds1.y);
		ds1.stop();
		ds1.load(m1.x, m1.y);
		ds1.unload(t1.x, t1.y);
		
	}
}
