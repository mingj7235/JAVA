package day13;
//메인클래스에만 public을 붙일 수 있다. 다른 클래스에는 붙일 수 없다. 다른 클래스는 default만 붙을 수 있다. 
public class Access {
	
	int data1 = 10;
	public int data2 = 20;
	protected int data3 = 30;
	private int data4 = 40;
	
	//private으로 막아놓은것을 다른곳에서 쓸 수 있게 해주는 getter.
	//메서드를 사용해서 접근할 수 있도록 한다. 
	//private을 쓰는 이유 : 개발자가 경각심 갖고 한번 더 볼 수 있게 하도록 하는 의도가 있음. 개발자들 끼리의 주의임.

	public int getData4() {
		//리턴하도록 하는 것임. 그래서 이 메서드를 사용하게 하는거임. private을 줘서 data4에 접근할 수 있도록.. 오...이해됨
		//리턴하면 그 값을 주는 거니까! data4를 리턴시키면 getData4()의 값은 data4다. 이해오오오오.!!
		return data4;
	}

	public void setData4(int data4) {
		//이것은 data4값을 수정하는 setter.
		//사용하는 부분에서 매개 변수를 수정하면 this.data4가 data4로 변하므로. 수정이된다.
		//수정 후 getter를 다시 출력하면 바뀌어 있는것을 확인할 수 있다. 
		this.data4 = data4;
	}

	void f() {
		
	}
}

class Cloud{
	void function () {
		//Access에 접근하기 위해 Access 객체화.
		Access a = new Access();
		
		
	}
}
