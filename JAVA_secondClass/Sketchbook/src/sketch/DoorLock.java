package sketch;

import javax.swing.JOptionPane;

public class DoorLock {
	public static void main(String[] args) {
		//도어락
		Room1 r = Room1.getRoom1();
		
		final String pw = "7235*";
		String [] arMsgs= { "문 비밀번호 입력하세요", "문열림", "비밀번호 다시 입력하셈"};
		String [] roomChoice = {"1. 안방", "2. 내방", "3. 화장실"};
		String result = null;	
		int choice = 0;
		while(true) {
			result = JOptionPane.showInputDialog(arMsgs[0]);
			if (result.equals("7235*")) {
				JOptionPane.showMessageDialog(null, arMsgs[1]);
				//방 선택
				choice = JOptionPane.showOptionDialog(null, "행복한 우리집", null, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, 
						null, roomChoice, null);
				if (choice == -1) break;
				switch (choice)	{
				case 0 : 
					System.out.println("안방 들어옴");
					r.sleep(123);
					
					break;
				}
				break;
			} else {
				JOptionPane.showMessageDialog(null, arMsgs[2]);
				continue;
			}
		}
			
	}
}
