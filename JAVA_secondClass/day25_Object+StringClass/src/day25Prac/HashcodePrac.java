package day25Prac;

public class HashcodePrac {
		  public static void main(String[] args) {
		    String str = new String("TEST");
		    String str2 = new String("TEST");

		    System.out.println("str과 str2의 주소값은 같나요 ? : " + (str==str2));
		    System.out.println("str과 str2의 해시코드는 같나요? : " +
		    (str.hashCode()==str.hashCode()));

		    System.out.println("str의 해시코드? : " + str.hashCode());
		    System.out.println("str2의 해시코드? : " + str2.hashCode());

		    //객체의 해시코드는?
		    HashcodePrac test1 = new HashcodePrac();
		    HashcodePrac test2 = new HashcodePrac();

		    System.out.println("test1과 test2의 주소값은 같나요 ? : " + (test1==test2));
		    System.out.println("test1과 test2의 해시코드값은 같나요? : "
		    +(test1.hashCode()==test2.hashCode()));

		    System.out.println("test1의 해시코드는 ? : " + test1.hashCode());
		    System.out.println("test2의 해시코드는 ? : " + test2.hashCode());

		  }

		}

