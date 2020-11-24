package day20_abstractClass;

public abstract class Shape {
	double area;
	
	public abstract void draw (double w, double h);
	//구현 안한 (바디가 없는) 메서드

	//재정의 할 수 없게 만드는 법. 
	final static void function () {
		System.out.println("추상 클래스의 일반 메서드 입니다.");
	}
}

class Rect extends Shape {
	@Override
	public void draw(double w, double h) {
		System.out.println("직사각형 점 4개 연결");
		area = w*h;
		System.out.println("넓이 :  " + area);
	}
}

class Tri extends Shape{
	@Override
	public void draw(double w, double h) {
		System.out.println("삼각형 점 3개 연결");
		area = w*h*0.5;
		System.out.println("넓이 :  " + area);
	}
}
