package pb;

import javax.swing.JOptionPane;

public class Bakery {
	public static void main(String[] args) {
		BreadPlate bread = new BreadPlate();
		BreadMaker maker = new BreadMaker(bread);
		
		String main_options[] = {"빵먹기", "빵이 다 덜어졌으면 누르세요"};
		int choice = 0;
		maker.start();

		do {
			choice= JOptionPane.showOptionDialog(null, "bakery", "bakery", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, main_options, null);
			
			if (choice == 0) {
				//만드는 곳에 있는 빵을 먹어줘야 하므로 getBread를 불러서 eatBread를 해야한다. 
				maker.getBread().eatBread();
			}else {
				break;
			}
		}while (true);
	}
}
