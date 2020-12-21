package p03;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalEx {
	public static void main(String[] args) {
		List <Integer> list =new ArrayList<> ();
		
//		double avg = list.stream().mapToInt(Integer::intValue).average().getAsDouble();

		OptionalDouble avg =list.stream().mapToInt(Integer::intValue).average();
		
		if(avg.isPresent()) {
			System.out.println("ЦђБе : " +avg.getAsDouble());
		}else {
			System.out.println(0.0);
		}
		
		double Tavg = avg.orElse(0.0);
		System.out.println("ЦђБе : " + Tavg);
		
		avg.ifPresent(a -> System.out.println("ЦђБе АЊ" + a));
		
	}
}
