package sec05.stream_mapping;

import java.util.Arrays;
import java.util.List;

public class FlatMapEx {
	public static void main(String[] args) {
		List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");
		
		inputList1.stream()
				.flatMap(data ->Arrays.stream(data.split(" "))) //split으로 쪼갠후에 그것을 Arrays.steram에 넣어서 스트림을 만든다.
				.forEach(s -> System.out.println(s));
		
		System.out.println();
		
		List<String>inputList2 = Arrays.asList("10, 20,   30", "40, 50, 60");
		inputList2.stream()
					.flatMapToInt(data -> {
						String [] strArray = data.split(",");
						int [] intArr = new int[strArray.length];
						for (int i = 0; i < intArr.length; i++) {
							intArr[i] = Integer.parseInt(strArray[i].trim()); //.trim()은 공백이있으면 지워준다. 무시함. 
						}
						return Arrays.stream(intArr);	//인트스트림을 최종적으로 리턴하도록 만들어 줘야한다. 
					})
					.forEach(n -> System.out.println(n));
		
		
		
		
		
		List<String>inputList3 = Arrays.asList("10, 20,   30", "40, 50, 60");
		
		inputList3.stream().flatMapToInt(data -> {
			String [] strArr = data.split(",");
			int [] intArr = new int[strArr.length];
			for (int i = 0; i < intArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim());
			}
			return Arrays.stream(intArr);
		}).forEach(n -> System.out.println(n));
		
		
		
	}
}
