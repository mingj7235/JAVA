package com.a2;

import com.a1.A;

public class D extends A{
	void dMethod () {
		memberVar = 30; // 상속 받았으므로 다른 패키지에 있어도 protected 제한자 변수를 사용 가능하다. 
	}
}
