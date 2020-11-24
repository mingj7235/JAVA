package testPractice;

public class Middle extends Elementary{
	String teacher;
	int present;
	int volunteer;
	
	@Override
	public int total() {
		return super.total() + present + volunteer;
	}
	
}
