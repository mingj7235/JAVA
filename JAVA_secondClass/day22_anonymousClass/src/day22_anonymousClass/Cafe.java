package day22_anonymousClass;

public interface Cafe {
	void setMenu (String[] menu);
	String[] getMenu();
	void sell(String choice);
}

//메뉴판
//판매
//인터페이스 이기 때문에 앞에 public abstract가 생략되어있다.