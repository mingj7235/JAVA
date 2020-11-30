package p2_StringClass;

public class StringCharAtEx {
	public static void main(String[] args) {
		String ssn1 = "010624-1230123";
		String ssn2 = "010624-1230123";
		String ssn3 = new String ("010624-1230123");
		
//		char s1 =ssn1.charAt(0);
//		char s2=ssn1.charAt(1);
//		System.out.println(""+s1 + s2);
		
		if (ssn1==ssn2)  { //주소가 같니?
			System.out.println("같은 주민번호");
		}else {
			System.out.println("다른 주민번호");
		}
		if (ssn1==ssn3)  {
			System.out.println("같은 주민번호");
		}else {
			System.out.println("다른 주민번호");
		}
		if (ssn1.equals(ssn3))  {// 주소안의 값이 같니? 
			System.out.println("같은 주민번호");
		}else {
			System.out.println("다른 주민번호");
		}
		if (ssn1.equals(ssn2))  {
			System.out.println("같은 주민번호");
		}else {
			System.out.println("다른 주민번호");
		}
		
		
		
	}
}
