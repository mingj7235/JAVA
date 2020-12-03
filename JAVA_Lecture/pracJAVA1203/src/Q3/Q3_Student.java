package Q3;

public class Q3_Student {
	private String studentNum;

	
	public Q3_Student(String studentNum) {
		this.studentNum = studentNum;
	}

	
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}	
	
	@Override
	public int hashCode() {
		return studentNum.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Q3_Student) {
			Q3_Student temp = (Q3_Student) obj;
			if (studentNum.equals(temp.getStudentNum())) {
				return true;
			}
		}
		return false;
	}
}
