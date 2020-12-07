package sec02.exam01_arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {
	public static void main(String[] args) {
		List <String> list = new ArrayList<>();
		
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP"); // 2번인덱스에서 3번인덱스로 바뀜
		list.add(2, "Database"); //수정이아닌, 삽입 !
		list.add("iBATIS");
		
		int size = list.size();
		System.out.println("총 객체수 : " + size + "\n");
		
		String skill = list.get(2);
		System.out.println("2 : " + skill + "\n");
		
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ": "+ str);
		}
		System.out.println();
		
		list.remove(2); //2번 인덱스를 삭제해라 //삭제하면 인덱스가 땡겨짐
		list.remove(2);
		list.remove("iBATIS");//객체 자체를 삭제 
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ": "+ str);
		}
		System.out.println();
		
	}
}
