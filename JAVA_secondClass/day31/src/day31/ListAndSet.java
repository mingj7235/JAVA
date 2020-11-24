package day31;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.time.Duration;
import java.time.Instant;
/*
 * Set은 검색의 목적이 있기 때문에 순서정보를 관리할 필요가 없다. (인덱스가 없다.)
 * 데이터 크기에 상관없이 검색에 걸리는 시간이 매우 짧다.
 * 
 *List는 index를 관리해야하기 때문에 상대적으로 시간이 오래걸린다.
 *
 *그러므로 기능적 차이가 없다면 HashSet을 써야한다. 
 * 
 */


public class ListAndSet {
	public static void main(String[] args) {
		final int SIZE = 10_000_000;
		final List<Integer> arrayList = new ArrayList<>(SIZE);
		final Set<Integer> hashSet = new HashSet<>(SIZE);
		//생성자에 숫자를 주면 사이즈가된다.
		final int data = 9_000_000;
		
		//순차 병렬 집계연산
		IntStream.range(0, SIZE).forEach(value -> {
			arrayList.add(value);
			hashSet.add(value);
		});
		
		//끝 시간 - 시작 시간 = 걸린시간
		//List 시간구하기
		Instant start = Instant.now();
		arrayList.contains(data);
		Instant end = Instant.now();
		long eTime = Duration.between(start, end).toMillis();
		System.out.println("array list search time" + (eTime/1000.0) + "초");
		//Set 시간 구하기
		start = Instant.now();
		hashSet.contains(data);
		end = Instant.now();
		eTime = Duration.between(start, end).toMillis();
		System.out.println("hash set search time" + (eTime/1000.0) + "초");
		
		
		
	}
	
	
}
