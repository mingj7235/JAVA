package game;


public  class Warrior extends CharacterPublic{
	
	//스탯 및 캐릭터 정보
	int cHp = 800;
	int cMp = 100;
	String cName = "";
	int damage = 200;

	
	@Override
	String attack(int cDamage, int mHp) {
		// 간단하게 일단 공격을 할 수 있게 하자. 
		String result = "";
		
		result = "" + (cDamage - mHp);
		return result;	
	}


	@Override
	void defense() {
		
	}

	@Override
	void escape() {
		
	}

	@Override
	void showStatus() {
		
	}

	
	
	
}
