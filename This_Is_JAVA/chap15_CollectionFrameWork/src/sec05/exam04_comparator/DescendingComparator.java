package sec05.exam04_comparator;

import java.util.Comparator;

public class DescendingComparator implements Comparator<Fruit> {
	@Override
	public int compare(Fruit o1, Fruit o2) {
		if (o1.price < o2.price) return 1 ; //가격이 높은 것부터 순으로 올라감. 즉 내림차순
		else if (o1.price == o2.price) return 0;
		else return -1;
	}
}
