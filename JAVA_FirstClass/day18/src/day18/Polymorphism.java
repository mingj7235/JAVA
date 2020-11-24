package day18;

import java.util.Random;

//이렇게 만들면똥이다. 똥을 보여주기위해 만드는 것
class Avengers {
	public void fight ()	{
		System.out.println("Avengers Assemble");
	}
}

class IronMan extends Avengers{
	@Override
	public void fight() {
		System.out.println("Beam!");
	}
}

class Thor extends Avengers {
	public void fight() {
		System.out.println("Thunder from Hammer!");
	}
}

class Hulk extends Avengers {
	@Override
	public void fight() {
		System.out.println("Big Green monster!");
	}
}

class CaptainAmerica extends Avengers {
	@Override
	public void fight() {
		System.out.println("Throw the SHIELD");
	}
}

class HawkEye extends Avengers {
	@Override
	public void fight() {
		System.out.println("Arrow Bomb!");
	}
}

class BlackWidow extends Avengers {
	@Override
	public void fight() {
		System.out.println("Kick and Punch!");
	}
}

class Loki extends Avengers {
	public void fight() {
		System.out.println("Duplication!");
	}
}


public class Polymorphism {
	public boolean whoAreYou (Avengers a)	{
		boolean isLoki = false;
		//Avengers 타입을 받아오는것이다..... 오...............
		//엄마클래스에서 자식클래스를 불러오는거... upcasting
		
		if (a instanceof IronMan) {
			System.out.println("I AM IRONMAN");
		} else if (a instanceof Thor) {
			System.out.println("I AM THOR");
		}else if (a instanceof CaptainAmerica) {
			System.out.println("I AM CAPTAINAMERICA");
		}else if (a instanceof Hulk) {
			System.out.println("I AM HULK");
		}else if (a instanceof BlackWidow) {
			System.out.println("I AM BlackWidow");
		}else if (a instanceof HawkEye) {
			System.out.println("I AM HawkEye");
		}else if (a instanceof Loki) {
			isLoki = true;
			System.out.println("We Found Loki !");
		}else {
			System.out.println("Villain");
		}
		return isLoki;
	}
	
	public static void main(String[] args) {
		Polymorphism p = new Polymorphism();
		Random r = new Random ();
	
			Avengers [] avengers = {
					new IronMan (),
					new Thor(),
					new CaptainAmerica(),
					new HawkEye(),
					new Hulk(),
					new BlackWidow(),
					new Loki()
					
			};
		for (int i = 0; i < 100; i++) {
			int index = r.nextInt(7);
			if (p.whoAreYou(avengers[index])) break;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
			
			
	}
	
	
	
	
	
	
}
	
	
	
	
	

