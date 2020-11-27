package p6_Clone;

public class Member implements Cloneable{
	public String id;
	public String name;
	public String password;
	public int age;
	public boolean adult;

	public Member(String id, String name, String password, int age, boolean adult) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.adult = adult;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		//1단계 얕은 복제를 한다.
		Member cloned = (Member) super.clone();
		//2단계 scores를 복제한다.
		return super.clone();
	}
	
	public Member getMember () {
		Member cloned = null;
		try {
			cloned = (Member) clone ();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} //자손 참조변수 = Object 리턴형
		return cloned;
	}
	
}
