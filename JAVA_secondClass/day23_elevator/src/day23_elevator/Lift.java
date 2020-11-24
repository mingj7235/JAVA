package day23_elevator;

public abstract class Lift {
	
	static int floor = 0;
	
	public abstract void up();
	public abstract void down();
	public abstract void start(int choice);
	public abstract void stop();
	public abstract void go();
}
