package p1;

public class Circle implements Cloneable{
	Point p;
	double r;

	public Circle(Point p, double r) {
		this.p = p;
		this.r = r;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = null;
		obj = super.clone(); //Object의 clone()을 호출한것임.
		return obj;
	}
	//얕은 복사
	public Circle shallowCopy () {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Circle)obj;
	}
	//깊은 복사
	public Circle deepCopy () {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//깊은 복사일때 다시 하는것.
		Circle c = (Circle) obj;
		//실제 내용을 넣기 이부분이 중요.
		c.p =new Point(this.p.x, this.p.y);
		return c;
	}
	@Override
	public String toString() {
		return "[p = " + p + ", r = " + r + "]";
	}
}

class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
