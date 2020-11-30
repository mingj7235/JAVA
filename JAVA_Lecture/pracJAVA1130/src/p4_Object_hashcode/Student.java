package p4_Object_hashcode;

import java.util.Objects;

public class Student {
	int num;
	String name;
	
	public Student() {

	}
	
	public Student(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(num, name);
	}
	
}
