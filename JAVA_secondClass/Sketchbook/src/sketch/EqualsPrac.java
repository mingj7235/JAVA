package sketch;

class Animals implements Cloneable{
	String name;
	public Animals(String name) {
		this.name = name;
	}
	public Object clone () throws CloneNotSupportedException {
		return super.clone();
	}
}


public class EqualsPrac {
	public static void main(String[] args) {
		Animals a1 = new Animals("호랑이");
		try {
			Animals a2 = (Animals) a1.clone();
			System.out.println(a1.name);
			System.out.println(a2.name);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//클론은 Object에 있는 메소드다. 하지만 이 clone은 protected 라서 패키지가 다르면 호출 불가.
		//Object클래스는 java.lang이라는 패키지에 있다. 그래서 호출이 바로안된다. 
		
	}
	
	
	
	
}
