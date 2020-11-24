package day27_CollectionFrameWork;

import java.util.ArrayList;

public class ArrList2 {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		//10~80 까지 값들을 10 20 30 ... 넣기
		
		for (int i = 1; i < 9; i++) {
			list.add(i*10);
		}
		System.out.println(list);
		list.add(90);
		//add하는 순간 배열은 공간을 찾아 이동한다.
		System.out.println(list);
		
		//indexOf() : 값이 있으면 그 값이 들어있는 방번호를 리턴 
						// 값이 없으면 -1을 준다. 
						// 즉, 값이 있는지 없는지도 확인이 가능하다. 
		int idx = list.indexOf(10);
		//이거 전체를 방의 넘버로 보면된다. 즉 0이다.
		
		if (idx != -1) {
		//idx가 -1 이 아니라는건 값이 있다는것임
			list.add(idx+1, 15);
			//10 옆에 15를 넣는 방법
		} else {
			list.add(0,15);
		}
		System.out.println(list);
		
		//실습 60을 600으로 바꾸기
		list.set(list.indexOf(60), 600);
		System.out.println(list);
		//15지우기
		list.remove(list.indexOf(15));
		System.out.println(list);
		System.out.println(list.size());
		list.remove(new Integer(600));
		System.out.println(list);
		System.out.println(list.size());
		
		
	}
}
