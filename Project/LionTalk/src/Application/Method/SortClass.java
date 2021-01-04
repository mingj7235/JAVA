package Application.Method;

import java.util.HashSet;
import java.util.Iterator;

public class SortClass {
	
	public String SortChatId(String str){ //str의 값을 정렬 시켜 저장된 값에 맞게 변경한다.
		String id[] = str.split("/");
		HashSet<String> hs = new HashSet<>();

		for (int i = 0; i < id.length; i++) {
			hs.add(id[i]);
		}
		String res="";

		Iterator<String> iter = hs.iterator();
		while(iter.hasNext()){
			res += iter.next()+"/";
		}
		res = res.substring(0, res.length()-1);

		return res;
	}
}
