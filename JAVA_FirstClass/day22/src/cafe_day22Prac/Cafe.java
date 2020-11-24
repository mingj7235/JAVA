package cafe_day22Prac;

public interface Cafe {
	//메뉴판
	//판매
	void setMenu(String [] menu);
	String [] getMenu ();
	void sell (String choice);
}
