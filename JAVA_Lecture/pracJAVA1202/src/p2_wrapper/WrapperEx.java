package p2_wrapper;

public class WrapperEx {
	public static void main(String[] args) {
		//boxing
		int i = 100;
		Integer ii = new Integer(100);
		float f = 10.5f;
		Float ff = new Float(10.5);
		char c = 'a';
		Character cc =new Character('a');
		boolean b = true;
		Boolean bb = new Boolean(true);
		
		//boxing하면 그 해당 클래스의 메소드들에 접근을 할 수있다.
		//기본타입은 접근이 불가능하다.
		
		
		//박싱된 포장객체에서 다시 기본타입의 값을 얻어내기위해 (언박싱) '기본타입형+value()' 메소드를 호출해야한다.
		byte bii = ii.byteValue();
		int iii = ii.intValue();
		
		ff.byteValue();
		ff.doubleValue();
		ff.intValue();
		
		
	}
}
