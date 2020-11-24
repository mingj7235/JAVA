package day19;

public abstract class Shape {
	double area;
	
	abstract void showArea(double w, double h);
	
	//final 을 달은 이유 : 자식클래스에서 재사용을 하지 못하고 사용만 하도록 하기 위해서. 메서드에도 final을 사용할 수 있다. 
	final void function ()	{
		System.out.println("추상 클래스의 일반 메서드 입니다.");
	}
}

class Rect extends Shape {

	@Override
	void showArea(double w, double h) {
		area = w*h;
		System.out.println("사각형의 넓이 : " + area + "cm²"); 
	}
	
	
}

class Tri extends Shape {
	@Override
	void showArea(double w, double h) {
		area = (w*h) / 2;
		System.out.println("삼각형의 넓이 : " + area + "cm²"); 
	}
}


