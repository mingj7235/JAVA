package sec05.exam01_treeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetEx01 {
	public static void main(String[] args) {
		TreeSet <Integer> scores = new TreeSet <>();
		
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		//저장이될때는 무작위로 저장되지만, 저장을 할 때 이진트리를 구성하면서 저장됨
		Integer score = null;
		
		score = scores.first(); //이진트리에서 가장 왼쪽에 있는 객체를 얻는다. 즉, 가장 작은 값임
		System.out.println("가장 낮은 점수 : " + score);
		
		score = scores.last(); //이진트리에서 가장 오른쪽에 있는 객체를 얻는다. 즉, 가장 큰값
		System.out.println("가장 높은 점수 : " + score + "\n");
		
		score = scores.lower(95); //lower()메소드는 매개변수의 바로 왼편에 있는 낮은 값을 리턴한다. 하나 낮은 값
		System.out.println("95점 아래의 값 : " + score);
		
		score = scores.higher(95); //higher() 메소드는 매개변수 바로 오른편에 있는 높은 값을 리턴한다. 하나높은 값
		System.out.println("95점 위의 값 :" +score);
		
		score = scores.floor(95); //95가 있다면 95를 리턴함. 95가 없다면, 95보다 아래의 값을 리턴. 즉, floor는 이하! lower는 미만!
		System.out.println("95점 이거나 바로 아래점수 : " + score);
		
		score = scores.ceiling(85); //85가있다면 85리턴, 85가 없다면, 85보다 위의값을 리턴, 즉 ceiling은 이상! higher()는 초과!
		System.out.println("85점 이거나 바로 위의 점수 : " + score);
		
//		while (!scores.isEmpty()) {
//			score = scores.pollFirst(); //이진트리에서 제일 왼쪽 부터 객체를 빼는 것임. 즉 treeset에서 빠지게 됨. 제일 왼쪽 자식 객체 노드부터 빼냄
//														//빼내면 treeset에서 제거가 됨. !! iterator와 차이! iterator는 제거하지않고 가져오기만함 
//			System.out.println(score + "(남은 객체수 : " + scores.size() + ")" + "남은 객체 : " +scores);
//			
//		} 
		
		while (!scores.isEmpty()) {
		score = scores.pollLast(); //이진트리에서 제일 오른쪽 부터 객체를 빼는 것임. 즉 treeset에서 빠지게 됨. 제일 오른쪽 자식 객체 노드부터 빼냄
													//빼내면 treeset에서 제거가 됨. !! iterator와 차이! iterator는 제거하지않고 가져오기만함 
		System.out.println(score + "(남은 객체수 : " + scores.size() + ")" + "남은 객체 : " +scores);
		
	} 
		
		
//		Iterator <Integer> iterator = scores.iterator();
//		while (iterator.hasNext()) {
//			int s = iterator.next();
//			iterator.remove(); //iterator는 제거하기위해서는 remove를 써줘야한다.
//			System.out.println(s + "(남은 객체수 : " + scores.size() + ")" + "남은 객체 : " +scores);
//		}
	}
}
