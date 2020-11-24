package sketch;

public class Room1 {

	private Room1() {}
	
	private static Room1 room1 = new Room1();

	public static Room1 getRoom1() {
		return room1;
	}
	
	public void sleep (Object data) {
		System.out.println(data);
	}
	
	
	
}
