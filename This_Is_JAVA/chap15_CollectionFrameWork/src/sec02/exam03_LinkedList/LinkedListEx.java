package sec02.exam03_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {
	public static void main(String[] args) {
		//ArrayList와 LinkedList의 속도차이 비교할 것임
		
//		List <String> list1 = new ArrayList<>();
//		List <String> list2 = new LinkedList<>();
//		
//		long startTime;
//		long endTime;
//		
//		startTime = System.nanoTime();
//		for (int i = 0; i < 10000; i++) {
//			list1.add(0, String.valueOf(i));
//		}
//		endTime = System.nanoTime();
//		
//		System.out.println("ArrayList 걸린 시간 : " + (endTime-startTime)+ "나노 초(ns)");
//		
//		startTime = System.nanoTime();
//		for (int i = 0; i < 10000; i++) {
//			list2.add(0, String.valueOf(i));
//		}
//		endTime = System.nanoTime();
//		
//		System.out.println("LinkedList 걸린 시간 : " + (endTime-startTime)+ "나노 초(ns)");
		
		List <String> list = new LinkedList<>();
		
		list.add("김민재");
		list.add("박희찬");
		list.add("누구");
		list.add("이루");
		list.add("람사");
		
		System.out.println(list.get(2));
		for (String name : list) {
			System.out.println(name);
		}
		
		System.out.println();
		list.remove(2);
		System.out.println(list.get(2));
		for (String name : list) {
			System.out.println(name);
		}
		
		
	}
}
