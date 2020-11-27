package p3_ApiEx;

public class Member {
	public String id;
	public Member() {
	}
	public Member(String id) {
		this.id = id;
	}
	
	//equals 오버라이드
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member member = (Member) obj;
			if(id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}
}
