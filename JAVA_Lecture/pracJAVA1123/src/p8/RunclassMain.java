package p8;

public class RunclassMain {
	public static void main(String[] args) {
		//구현 클래스를 객체화 하세요
		RunClassEx rce = new RunClassEx();
		
		rce.inter01Method();
		rce.inter0101Method();
		rce.inter0102Method();
		
		//다형성 구현 클래스를 객체화 하고 부모참조변수를 Inter0102로 하세요
		Inter0102 inter0102 = new RunClassEx();
		
		inter0102.inter01Method();
		inter0102.inter0102Method();
		
//		inter0102.inter0101Method();
		
		//다형성 구현클래스를 객체화 하고 부모참조 변수를 inter01로 하세요
		Inter01 inter01 = new RunClassEx();
		inter01.inter01Method();
		
		Inter0101 inter0101 = (Inter0101) inter01;
		inter0101.inter0101Method();
		
		
	}
}
