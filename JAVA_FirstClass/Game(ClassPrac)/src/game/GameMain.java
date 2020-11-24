package game;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GameMain {
/*
 * 케릭터 클래스
 *	몬스터 등장은 Random으로 (몬스터에게 고유의 int 타입 넘버링을 부여, 랜덤으로 나타나는 것 조정)
 * 
 * 
 */
	
	void view () {
		Warrior warrior = new Warrior();
		
		ImageIcon mainImg = new ImageIcon("src/img/main.gif");
		ImageIcon warriorImg = new ImageIcon ("src/img/warrior.gif");
		
		String [] arMainChoice = {"모험을 시작한다.", "만든 사람들", "게임을 종료한다."};
		String [] arCharacterOption = {"전사", "마법사", "도적"};
		String [] arBehaviorOption = {"전투를 시작한다", "휴식을 취한다.", "탐색을 시작한다.", "케릭터를 변경한다."};
		String [] arBattleOption = {"공격한다.", "방어한다.", "도망간다"};
		
		String charChoiceMsg = "케릭터를 선택해주세요";
		String creditMsg = "만든 이 : 김민재 \n"
				+ "다음은 더 많은 친구들과 더 좋은 게임을 만듭시다.";
		String exitMsg = "게임을 종료합니다.";
		
		String battleResult = "";
		
		
		int mainIndex = 0;
		int charIndex = 0;
		int behaviorIndex = 0;
		int battleIndex = 0;
		
		while (true) {
			
			mainIndex = JOptionPane.showOptionDialog(null, "", "Game Test", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE, mainImg, arMainChoice, null);
			if (mainIndex == 2 || mainIndex == -1) {
				JOptionPane.showMessageDialog(null, exitMsg);
				break;
			}
			switch (mainIndex) {
			case 0 : 
				//모험을 시작한다.
				JOptionPane.showMessageDialog(null, charChoiceMsg);
				
				
				//케릭터 선택
				while (true) {
					if (charIndex == -1) break;
					charIndex = JOptionPane.showOptionDialog(null, "", "Game Test", JOptionPane.DEFAULT_OPTION, 
							JOptionPane.PLAIN_MESSAGE, mainImg, arCharacterOption, null);
					switch (charIndex) {
					case 0 : 
						//전사
						behaviorIndex = JOptionPane.showOptionDialog(null, "", "Warrior Mode", JOptionPane.DEFAULT_OPTION, 
								JOptionPane.PLAIN_MESSAGE, warriorImg, arBehaviorOption, null);
						
						switch (behaviorIndex) {
						case 0 : 
							//전투를 시작한다.
							Monster monIndex = new Monster();
							
//							if (monIndex.choiceMonster() == )
							
							battleIndex = JOptionPane.showOptionDialog(null, "", "Battle", JOptionPane.DEFAULT_OPTION, 
									JOptionPane.PLAIN_MESSAGE, warriorImg, arBattleOption, null);
							
							switch (battleIndex) {
							
							//공격 실현
							case 0 : 
								
								
								break;
							
							
							}
							
							
							
//							warrior.attack(warrior.damage, mHp);
							
							
							
							
							
						}
						
						
						break;
						
						
					}
				}
				
				
			case 1 :
				JOptionPane.showMessageDialog(null, creditMsg);
				break; 
			}
			
		}
		
		
	}
		
		
	
	
	
	public static void main(String[] args) {
		new GameMain().view();
	
	
	}

}