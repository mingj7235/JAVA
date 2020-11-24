package day12;
import javax.swing.JOptionPane;
public class ClassProject {
	String name;
	int age;
	double weight;
	String hairColor;
	String habit;
	
	ClassProject(){}

	public ClassProject(String name, int age, double weight, String hairColor, String habit) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.hairColor = hairColor;
		this.habit = habit;
	}
	void walk(){
		System.out.println(name+ "이(가) 걷는다.");
	}
	void workout() {
		System.out.println(name + "이(가) 운동을한다.\n"	+ "그의 몸무게가" + weight + "kg 이기 때문이다.");
	}
	
	public static void main(String[] args) {
		int inputAge = 0;
		double inputWeight = 0.0;
		String msg =  "캐릭터의 정보를 입력해 주세요";
		JOptionPane.showMessageDialog(null, msg);
		
		String inputName = JOptionPane.showInputDialog("이름을 입력하세요");
		
		while(true) {
			inputAge = Integer.parseInt(JOptionPane.showInputDialog("나이를 입력하세요"));
			if (inputAge >0) {
				break;
			}else {
				JOptionPane.showMessageDialog(null, "나이는 0 보다 커야합니다.");
			}
		}
		
		while (true) {
			inputWeight = Double.parseDouble(JOptionPane.showInputDialog("몸무게를 입력하세요 (소수점 두자리까지"));
			if (inputWeight >0) break;
			else {
				JOptionPane.showMessageDialog(null, "몸무게는 0 보다 커야합니다.");
			}
		}
		
		String inputHairColor = JOptionPane.showInputDialog("머리카락 색을 입력하세요");
		String inputHabit = JOptionPane.showInputDialog("취미를 입력하세요");
		
		ClassProject MJ = new ClassProject(inputName, inputAge, inputWeight, inputHairColor, inputHabit);
		MJ.walk();
		MJ.workout();
	}
}
