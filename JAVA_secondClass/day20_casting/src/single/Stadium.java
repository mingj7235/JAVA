package single;

public class Stadium {
	public static void main(String[] args) {
//		IronMan i = new IronMan();
		//불가하다. 접근할수가없다. IronMan 클래스에서 private으로 막아놨다. 객체가 하나기때문이다. 
		IronMan.fight();
		
//		IronMan.walk(); 이거 접근이안된다. 왜냐하면 walk에는 static을 붙이지 않았기 때문이다.
		//그래서 이것에 접근하기위해서는 객체로 접근해야하고,
		IronMan i = IronMan.getInstance();
		//객체를 만들고 싶으면 이렇게 접근해야한다.
		//IronMan클래스에서 선언한 new를 호출해서 가져오는 것이다. 
		
	}
}
