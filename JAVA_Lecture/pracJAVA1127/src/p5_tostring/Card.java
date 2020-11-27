package p5_tostring;

public class Card {
	String kind;
	int number;
	
	public Card() {
		this("SPADE", 1);
	}
	
	public Card (String kind, int number) {
		this.kind = kind;
		this.number =number;
	}
	
	@Override
	public String toString() {
		return "kind : "  + kind + " number : " + number;
	}
}
