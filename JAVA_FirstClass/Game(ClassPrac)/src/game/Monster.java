package game;

import java.util.Random;

public class Monster {
	
	int monsterIndex;
	
	int choiceMonster () {
		Random r = new Random()	;
		return monsterIndex = r.nextInt(3);
	}
	
	
}
