package sec05.exam01_treeSet;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetEx03 {
	//범위검색
	public static void main(String[] args) {
		TreeSet <String> treeSet= new TreeSet<>();
		treeSet.add("apple");
		treeSet.add("forever");
		treeSet.add("description");
		treeSet.add("ever");
		treeSet.add("zoo");
		treeSet.add("base");
		treeSet.add("guess");
		treeSet.add("cherry");
		
		System.out.println("[c~f 사이의 단어 검색]");
		NavigableSet<String> rangeSet = treeSet.subSet("c", true, "f", false);
//		NavigableSet<String> rangeSet = treeSet.subSet("c", false, "f", true); // c는 포함 안하고 f 는 포함 한다는 말임
		for(String word : rangeSet) {
			System.out.println(word);
		}
		
		
	}
}
