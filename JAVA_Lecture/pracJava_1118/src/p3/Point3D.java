package p3;

public class Point3D extends Point{
	int z;
	
	@Override	 //@ 어노테이션 -> 아래 메소드에 대해 설명해 주는 것임
	String getLocation ()throws Exception {
		return "x = " + x + " y = " + y + " z =" + z;
	}
	
	@Override
	public String toString() {
		return "이곳은 자식 point3d 부분입니다.";
	}
	
//	String superGetLocation() {
//		return super.getLocation();
	}
	
//}