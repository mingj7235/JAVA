package p2_ClassClass;
//Class 클래스도 final 클래스다. 
//Class는 생성자가 없다. 그냥 바로 메소드를 타 클래스로 접근가능하다. 
public class ClassEx01 {
	public static void main(String[] args) {
		Car car = new Car ();
		System.out.println(car.getClass());
		Class cls = car.getClass();
		String name = cls.getName();
		System.out.println(name);
	}
}

class Car{
	@Override
	public String toString() {
		return "Car";
	}
	
	
}
