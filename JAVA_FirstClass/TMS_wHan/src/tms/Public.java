package tms;

public abstract class Public {

	String [] arStation = {"±³´ë", "°­³²", "¿ª»ï", "¼±¸ª"};
	
	abstract int pay (int money);
	abstract void showDestMsg(String destination);
	abstract String go (int btnIndex, int money);
}
