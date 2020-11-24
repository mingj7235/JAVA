package day20_abstractClass;

public class User {

	public void check (Soldier a) {
		if (a instanceof Private) {
			System.out.println("저는 이병입니다. ");
		} else if (a instanceof Pfc) {
			System.out.println("저는 일병입니다.");
		} else if (a instanceof Corporal) {
			System.out.println("저는 상병입니다.");
		} else if (a instanceof Sergeant) {
			System.out.println("저는 병장입니다. ");
		}
	}
	public static void main(String[] args) {
		User c = new User ();
		Soldier [] soldier = {
				new Private(),
				new Pfc(),
				new Corporal(),
				new Sergeant()
		};
		
		c.check(new Private());
		
		
		
	}
}
