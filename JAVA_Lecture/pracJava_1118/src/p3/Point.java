package p3;

public class Point {
	int x,y;
	String getLocation() throws Exception {
		return "x = " + x + " y = " + y ;
	}
	
	@Override
	public String toString() {
		return "이곳은 자식 point 부분입니다.";
	}
	
	
}