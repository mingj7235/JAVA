package mjProjects;

import javax.swing.JOptionPane;

public class ClassCharMaking {
		String name;
		int age;
		double power;
		String weapon;
		String shield;
		String monster;
	
		ClassCharMaking(){}

		public ClassCharMaking(String name, int age, double power, String weapon, String shield, String monster) {
			this.name = name;
			this.age = age;
			this.power = power;
			this.weapon = weapon;
			this.shield = shield;
			this.monster = monster;
		}
		void hit () {
			JOptionPane.showMessageDialog(null, name + " 이(가) " + monster + " (을)를 " + weapon + " 을(를) 사용하여 " 
														+ power +" 의 공격력으로 공격했다.");
			JOptionPane.showMessageDialog(null, "효과는 굉장했다!");
		}
		void def () {
			JOptionPane.showMessageDialog(null, name + " 이(가) " + monster + " 의 공격을 " + shield +" 를 사용하여 막아냈다.");
		}
		void run () {
			JOptionPane.showMessageDialog(null, name + " 이(가) " + monster + " 로 부터 도망갔다.");
		}
		void info () {
			JOptionPane.showMessageDialog(null, "1. 이름 : " + name + "\n"
					+ "2. 나이 : " + age + "\n"
					+ "3. 무기 : " + weapon + "\n"
					+ "4. 공격력 : " + power + "\n"
					+ "5. 방어구 : " + shield + "\n");
		}

		//main method
		public static void main(String[] args) {
			int inputAge = 0;
			int choice = 0;
			String msg =  "코로나를 이기자! \n"
					+ "코로나를 물리칠 캐릭터의 정보를 입력해 주세요";
			String inputName ="";
			String battleMsg = "적을 만났다.\n 행동을 골라주세요\n"
					+ "1. 공격하기\n"
					+ "2. 방어하기\n"
					+ "3. 도망가기\n"
					+ "4. 현 상태 보기\n"
					+ "5. 게임을 나간다. \n";
			// 캐릭터 설정
			JOptionPane.showMessageDialog(null, msg);
			inputName = JOptionPane.showInputDialog("이름을 입력하세요");
			
			while(true) {
				inputAge = Integer.parseInt(JOptionPane.showInputDialog("나이를 입력하세요"));
				if (inputAge >0) {
					break;
				}else {
					JOptionPane.showMessageDialog(null, "나이는 0 보다 커야합니다.");
				}
			}
			String inputWeapon = JOptionPane.showInputDialog("무기를 입력해주세요");
			String inputShield = JOptionPane.showInputDialog("방어구를 입력해주세요");
			
			ClassCharMaking c = new ClassCharMaking(inputName, inputAge, 1, inputWeapon, inputShield, " 코로나바이러스");
			
			// 게임 진행 파트
			String gameMsg =("이제 " + inputName + "의 여행이 시작됩니다.");
			JOptionPane.showMessageDialog(null, gameMsg);
			while (true) {
				choice = Integer.parseInt(JOptionPane.showInputDialog(battleMsg));			
				if (choice == 5) {
					JOptionPane.showMessageDialog(null, "게임을 종료합니다.");
					break;
				}
				if (!(choice > 0 && choice < 5)) {
					JOptionPane.showMessageDialog(null, "1에서 4까지의 수만 입력해주세요.");
					continue;
				}
				switch (choice) {
				case 1 :
					c.hit();
					break;
				case 2 :
					c.def();
					break;
				case 3 :
					c.run();
					break;
				case 4 :
					c.info();
				}
			}
		}
}

