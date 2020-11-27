package p6_Clone;

public class MemberExample {
	public static void main(String[] args) {
		Member original = new Member("blue", "ȫ�浿", "12345", 25, true);
		Member cloned = original.getMember();
		
		System.out.println(original.id);
		System.out.println(original.name);
		System.out.println(original.password);
		System.out.println(original.age);
		System.out.println(original.adult);
		
		System.out.println("============");
		
		cloned.id = "red";
		cloned.password = "7777";
		
		System.out.println("cloned : " + cloned.id);
		System.out.println("original : "  + original.id);
		System.out.println("clond : " + cloned.password);
		System.out.println("original : " + original.password);
	}
}

