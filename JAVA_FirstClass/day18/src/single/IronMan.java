package single;

public class IronMan {
	
	
	private IronMan() {}
	//private으로 막아서 new하지 못하게한다.
	
	public static IronMan getInstance() {
		IronMan im = new IronMan();
		return im;
	}
	//getInstance라는 메서드는 IronMan 타입을 리턴하는 매서드. 
	
	public static void fight () {
		System.out.println("빔 발사");
	}
	
	public void walk ()	{
		System.out.println("날아간다");
	}
	
}
