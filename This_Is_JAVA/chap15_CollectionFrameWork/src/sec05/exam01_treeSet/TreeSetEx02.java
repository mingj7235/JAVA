package sec05.exam01_treeSet;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetEx02 {
	public static void main(String[] args) {
		TreeSet <Integer> scores = new TreeSet <>();
		
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		
		NavigableSet<Integer> descendingSet = scores.descendingSet();
		//내림차순으로 정렬됨 //실제로 객체들이 저장될때는 이진트리로 저장되지만, descendingSet()에 따라 내림차순으로 정렬됨
		
		System.out.println("내림 차순 정렬 (descendingset() 사용)");
		for(Integer score : descendingSet) {
			System.out.print(score + " ");
		}
		System.out.println();
		
		NavigableSet<Integer> ascendingSet = descendingSet.descendingSet(); 
		//descendingSet() 메소드는 내림차순의 의미가 아니라, 순서를 뒤바꾼다는 의미임!!!
		//descending()한것을 다시한번 descending() 하면 내림차순이 유지되는 것이 아니라 오름차순이 된다. 즉, 뒤집는 것임 
		System.out.println("오름 차순 정렬 (descendingset() 사용) "); 
		for(Integer score : ascendingSet) {
			System.out.print(score + " ");
		}
		System.out.println();
		
		
	}
}
