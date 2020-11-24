package single;

public class IronMan {
	
	private IronMan () {}
	
	public static IronMan getInstance () {
		IronMan im = new IronMan();
		return im;
	}
	
	public static void fight () {
		System.out.println("빔 발사");
	}
	public void walk () {
		System.out.println("날아간다");
	}
}
