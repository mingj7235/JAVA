package avengers;

import java.util.Random;

class Avengers {
	public void fight () {
		System.out.println("Avengers Assemble");
	}
}

class IronMan extends Avengers{
	@Override
	public void fight() {
		System.out.println("Beam!");
	}
}

class Thor extends Avengers{
	@Override
	public void fight() {
		System.out.println("Thunder!");
	}
}

class Hulk extends Avengers{
	@Override
	public void fight() {
		System.out.println("Big Green Monster!");
	}
}

class CaptainAmerica extends Avengers{
	@Override
	public void fight() {
		System.out.println("Shield!");
	}
}

class HawkEye extends Avengers{
	@Override
	public void fight() {
		System.out.println("Arrow Bomb!");
	}
}

class BlackWidow extends Avengers{
	@Override
	public void fight() {
		System.out.println("Kick!");
	}
}

class Loki extends Avengers{
	@Override
	public void fight() {
		System.out.println("Duplication!");
	}
}

public class Polymorphism {
	public boolean whoAreYou (Avengers a){
		boolean isLoki =false;
		//Avengers 타입.. 다 상속받으니까. 
		//자식클래스로 선언한 객체 a는 부모클래스 이기도 하다. 
		if (a instanceof IronMan) {
			System.out.println("I AM IRONMAN");
		} else if (a instanceof Thor) {
			System.out.println("I AM THOR");
		} else if (a instanceof CaptainAmerica){
			System.out.println("I am CaptainAmerica");
		} else if (a instanceof Hulk) {
			System.out.println("I am Hulk");
		} else if (a instanceof BlackWidow) {
			System.out.println("I am BlackWidow");
		} else if (a instanceof HawkEye) {
			System.out.println("I am HawkEye");
		} else if (a instanceof Loki) {
			isLoki = true;
			System.out.println("We Found LoKi!");
		} else {
			System.out.println("Villain");
		}
		return isLoki;
	}
	
	public static void main(String[] args) {
		Polymorphism p = new Polymorphism();
		Random r = new Random();
		Avengers [] avengers = {
			new IronMan(),
			new Thor(),
			new CaptainAmerica(),
			new Hulk(),
			new HawkEye(),
			new BlackWidow(),
			new Loki()
		};
		for (int i = 0; i < 100; i++) {
			int index = r.nextInt(7);
			if (p.whoAreYou(avengers[index])) break;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}
