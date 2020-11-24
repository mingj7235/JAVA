package set;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class WhySet {
	//왜 Set을 쓰는지 실험하는 용도임
	//List와 Set의 비교
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
