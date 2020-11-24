package access;

import review.Access;

public class Access3 {
	private void function () {
		Access a = new Access ();
		
		//private은 쉽게접근하지 못하게 하는 것.
		//즉, 접근은 가능하다. 
		//직접접근은 못하고 간접접근은 가능하다.
		//이럴때는 private을 걸어둔 클래스에 들어가서 메서드를 만들어주고, return을 해주어 사용한다. return하여 값으로 보는 것 !
		//private 변수를 get은 접근, set은 수정 하는 것을 의미한다.  
	}
}
