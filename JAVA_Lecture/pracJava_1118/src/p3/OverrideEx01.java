package p3;

public class OverrideEx01 extends Object{
	public static void main(String[] args) {
		Point3D pt3d = new Point3D();
//		System.out.println(pt3d.getLocation());
		
		//부모의 메소드를 출력하기
		Point pt = new Point();
//		System.out.println(pt.getLocation());
		
		System.out.println(pt3d);
		System.out.println(pt);
		
	}
}