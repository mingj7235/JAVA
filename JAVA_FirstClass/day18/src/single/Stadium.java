package single;

public class Stadium {
	public static void main(String[] args) {
//		IronMan i = new IronMan ();
		IronMan i = IronMan.getInstance();
		IronMan.fight();
		i.walk();
		
		
		//아이언맨은 한명이니까. 하나니까. 
	}
}
