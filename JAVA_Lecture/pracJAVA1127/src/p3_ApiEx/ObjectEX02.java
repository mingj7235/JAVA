package p3_ApiEx;
//equals
public class ObjectEX02 {
	public static void main(String[] args) {
		Value v1 = new Value(10, 30);
		Value v2 = new Value(10, 30);
		Value v3 = new Value(20, 30);
		if (v1.equals(v2)) {
			System.out.println("서로 같다");
		}else {
			System.out.println("서로 다르다");
		}
		if (v1.equals(v3)) {
			System.out.println("서로 같다");
		}else {
			System.out.println("서로 다르다");
		}
	}
}
class Value {
	int num1, num2;
	public Value(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Value) {
			Value v = (Value) obj;
			if (num1 == v.num1 && num2 == v.num2) {
				return true;
			}
		}
		return false;
	}
}
