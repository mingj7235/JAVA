package day27_CollectionFrameWork;

import java.util.ArrayList;
import java.util.Collections;

/*
 * ArrayList
 * 컬렉션 클래스 중 가장 많이 사용되는 클래스다. 
 * 배열을 이용해서 값을 저장하는 형식이다.
 * 
 * 인덱스를 이용해서 배열 요소에 빠르게 접근 가능하지만
 * 크기를 늘리기 위해서는 새로운 배열을 생성하고 기존의 값들을 옮겨야 하므로 느리다. 
 * 즉, 새로운 배열을 늘어날 만큼의 공간을 찾아서 새로 생성하는것이다. 
 * 줄일때는 그자리에서 줄임. 늘일때만 새로 생성.
 *  
 *  정적배열 : 크기가 고정되었다. (처음에 배열을 선언할때 크기를 고정해준다. ) 
 *  동적배열 : 크기가 고정되어있지 않다. (이제 배울것임)
 *  			동적배열은 기존 배열 주소값에 칸을 추가하는것이아니라
 *  			새로운 주소값으로 기존 배열의 값들을 복사하고, 배열의 크기를 늘리는것이다. 
 *  			통째로가 이동하는 것이다. 그래서 정적배열보다 느린것임. 
 *  
 *  그동안 배운 배열 : 속도가 빠르지만 고정된 메모리 양으로 인해 나중에 늘릴 수 없다. 
 *  ArrayList : 메모리 양은 맘대로 늘리고 줄일 수 있으나, 배열보다 느리다.
 *  
 */
public class ArList {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> list2 = null;
		
		list.add(10);	//0번째방
		list.add(20);	//1번째방
		list.add(80);	//2
		list.add(90);	//3
		list.add(30);	//4
		list.add(50);	//5
		list.add(40);	//6
		
		
		list2 = new ArrayList<>(list.subList(2, 5));
		//잘라 넣어달라는 것임. list의 2~4번째 방이 들어감
		
		System.out.println(list);
		System.out.println(list.toString());
		System.out.println(list2);
		//ArrayList는 객체명을 치면 주소값이 아니라 배열의 값이 나온다.
		//여기서 toString은 재정의되어서 배열의 값이 나오도록 된것이다. 그래서 객체명을 치면 주소값이 아닌 배열의 값이 나오는것이다.
		
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
		System.out.println(list.size());
		//ArrayList 의 배열 길이
		
		//정렬하기 (오름차순 정렬)
		//이런걸 알고리즘이라고한다. 
		System.out.println("정렬 전 list : " + list);
		Collections.sort(list);
		System.out.println("정렬 후 list : " + list);
		
		//리버스 정렬 (정가운데를 기준으로 왼쪽, 오른쪽을 뒤집어주는것임.그래서 정렬 후에 리버스를 쓰면 내림차순이 되는것임
		//그렇기 때문에 내림차순을 하고 싶다면 오름차순으로 정렬하고 리버스를 써야한다.)
		Collections.reverse(list);
		System.out.println("리버스 : " + list);
		
		ArrayList<String> list3 = null;
		
		list3 = new ArrayList<>();
		list3.add("efg");
		list3.add("abc");
		list3.add("cde");
		list3.add("bcd");
		System.out.println(list3);
		Collections.sort(list3);
		System.out.println(list3);
		
		list3 =new ArrayList<>();
		list3.add("가나");
		list3.add("타하");
		list3.add("바라");
		list3.add("가나");
		System.out.println(list3);
		Collections.sort(list3);
		System.out.println(list3);
		
		list3 =new ArrayList<>();
		list3.add("가나");
		list3.add("ab");
		list3.add("AB");
		list3.add("하하");
		System.out.println(list3);
		Collections.sort(list3);
		System.out.println(list3);
		
		//섞기 : shuffle() 랜덤하게 섞임. 
		Collections.shuffle(list);
		System.out.println(list);
		
		
	}
}
