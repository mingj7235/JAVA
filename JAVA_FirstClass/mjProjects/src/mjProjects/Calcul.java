package mjProjects;
import javax.swing.JOptionPane;

public class Calcul {
		void add (int num1, int num2) {
			JOptionPane.showMessageDialog(null, num1 + num2);
		}
		void minus (int num1, int num2) {
			JOptionPane.showMessageDialog(null, num1 - num2);
		}
		void mult (int num1, int num2) {
			JOptionPane.showMessageDialog(null, num1 * num2);
		}
		void div (int num1, int num2) {
			if (num2 != 0) {
				JOptionPane.showMessageDialog(null, (String.format("%.2f", (double)num1 / num2)));
			}else {
				JOptionPane.showMessageDialog(null, "0으로 나눌 수 없습니다.");		
			}
		}
		public static void main(String[] args) {
			Calcul c = new Calcul();
			int choice = 0;
			String msg = "정수 계산기 입니다.\n";
			String menu = "다음 계산을 골라주세요\n"
					+ "1. 덧셈\n"
					+ "2. 뺄셈\n"
					+ "3. 곱셈\n"
					+ "4. 나눗셈\n"
					+ "5. 나가기";
				while (true) {
					choice = Integer.parseInt(JOptionPane.showInputDialog(msg + menu));
					if (choice == 5) break;
					if (!(choice >=1 && choice <=4)) continue;
					
					switch (choice) {
					case 1 :
						JOptionPane.showMessageDialog(null, "덧셈 계산기입니다.");
						int inputNum1 = Integer.parseInt(JOptionPane.showInputDialog("첫번째 숫자를 입력해 주세요"));
						int inputNum2 = Integer.parseInt(JOptionPane.showInputDialog("두번째 숫자를 입력해 주세요"));
						c.add(inputNum1, inputNum2);
						break;
						
					case 2 :
						JOptionPane.showMessageDialog(null, "뺄셈 계산기입니다.");
						int inputNum3 = Integer.parseInt(JOptionPane.showInputDialog("첫번째 숫자를 입력해 주세요"));
						int inputNum4 = Integer.parseInt(JOptionPane.showInputDialog("두번째 숫자를 입력해 주세요"));
						c.minus(inputNum3, inputNum4);
						break;
						
					case 3 :
						JOptionPane.showMessageDialog(null, "곱셈 계산기입니다.");
						int inputNum5 = Integer.parseInt(JOptionPane.showInputDialog("첫번째 숫자를 입력해 주세요"));
						int inputNum6 = Integer.parseInt(JOptionPane.showInputDialog("두번째 숫자를 입력해 주세요"));
						c.mult(inputNum5, inputNum6);
						break;
					
					case 4 :
						JOptionPane.showMessageDialog(null, "나눗셈 계산기입니다.");
						int inputNum7 = Integer.parseInt(JOptionPane.showInputDialog("첫번째 숫자를 입력해 주세요"));
						int inputNum8 = Integer.parseInt(JOptionPane.showInputDialog("두번째 숫자를 입력해 주세요"));
						c.div(inputNum7, inputNum8);
						break;
					}
				}
		}
	}


