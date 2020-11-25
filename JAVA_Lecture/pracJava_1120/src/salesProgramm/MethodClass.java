package salesProgramm;

import javax.swing.JOptionPane;

public class MethodClass {
	Seoul seoulBranch = new Seoul();
	KyungIn kyunginBranch = new KyungIn();
	Kangwon kangwonBranch = new Kangwon();
	Jeju jejuBranch = new Jeju();
	String [] mainMenu = {"입력", "출력", "종료"};
	String [] choiceBranch = {"서울지사", "경인지사", "강원지사", "제주지사"};
	String [] productChoice = {"컴퓨터", "프린터"};
	boolean check = false;
	int sales;
	//뷰단
	public void view () {
		while (!check) {
			int choice = JOptionPane.showOptionDialog(null, "메뉴를 선택해주세요", 
					"판매량관리 프로젝트",	JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE, null, mainMenu, null);
			if (choice ==-1) break;
			switch (choice) {
			//입력
			case 0 : 
				insert();
				break;
			//출력
			case 1 :
				output();
				break;
			//종료	
			case 2:
				exit ();
				break;
			}
		}
	}
	//입력
	public void insert () {
		
		while (!check) {
			int choice = JOptionPane.showOptionDialog(null, "지사를 선택해주세요", "판매량관리 프로젝트", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE, null, choiceBranch, null);
			if (choice == -1) break;
			switch (choice) {
			//서울지사
			case 0 : 
				choice = JOptionPane.showOptionDialog(null, "제품을 선택해주세요", "판매량관리 프로젝트", JOptionPane.DEFAULT_OPTION, 
						JOptionPane.PLAIN_MESSAGE, null, productChoice, null);
				switch (choice) {
				//컴퓨터
				case 0 :
					sales = Integer.parseInt(JOptionPane.showInputDialog("컴퓨터 판매량을 적어주세요"));
					salesComCal(seoulBranch, sales);
					break;
				//프린터
				case 1 :
					sales = Integer.parseInt(JOptionPane.showInputDialog("프린터 판매량을 적어주세요"));
					salesPrintCal(seoulBranch, sales);
					break;
				}
				break;
			//경인지사
			case 1 :
				choice = JOptionPane.showOptionDialog(null, "제품을 선택해주세요", "판매량관리 프로젝트", JOptionPane.DEFAULT_OPTION, 
						JOptionPane.PLAIN_MESSAGE, null, productChoice, null);
				switch (choice) {
				//컴퓨터
				case 0 :
					sales = Integer.parseInt(JOptionPane.showInputDialog("컴퓨터 판매량을 적어주세요"));
					salesComCal(kyunginBranch, sales);
					break;
				//프린터
				case 1 :
					sales = Integer.parseInt(JOptionPane.showInputDialog("프린터 판매량을 적어주세요"));
					salesPrintCal(kyunginBranch, sales);
					break;
				}
				break;
			//강원지사
			case 2: 
				choice = JOptionPane.showOptionDialog(null, "제품을 선택해주세요", "판매량관리 프로젝트", JOptionPane.DEFAULT_OPTION, 
						JOptionPane.PLAIN_MESSAGE, null, productChoice, null);
				switch (choice) {
				//컴퓨터
				case 0 :
					sales = Integer.parseInt(JOptionPane.showInputDialog("컴퓨터 판매량을 적어주세요"));
					salesComCal(kangwonBranch, sales);
					break;
				//프린터
				case 1 :
					sales = Integer.parseInt(JOptionPane.showInputDialog("프린터 판매량을 적어주세요"));
					salesPrintCal(kangwonBranch, sales);
					break;
				}
				break;
			//제주지사
			case 3:
				choice = JOptionPane.showOptionDialog(null, "제품을 선택해주세요", "판매량관리 프로젝트", JOptionPane.DEFAULT_OPTION, 
						JOptionPane.PLAIN_MESSAGE, null, productChoice, null);
				switch (choice) {
				//컴퓨터
				case 0 :
					sales = Integer.parseInt(JOptionPane.showInputDialog("컴퓨터 판매량을 적어주세요"));
					salesComCal(jejuBranch, sales);
					break;
				//프린터
				case 1 :
					sales = Integer.parseInt(JOptionPane.showInputDialog("프린터 판매량을 적어주세요"));
					salesPrintCal(jejuBranch, sales);
					break;
				}
				break;
			}
		}
	}
	
	public void salesComCal (Branch branch, int sales) {
		branch.comsales = sales;
		branch.Comtotal = branch.computerPrice * branch.comsales;
	}
	
	public void salesPrintCal (Branch branch, int sales) {
		branch.printsales = sales;
		branch.Printtotal = branch.printerPrice * branch.printsales; 
	}
	
	public void output () {
		String result = "";
		result += "|   지사명    |   제품명    |   제품가격    |   판매량   |   매출현황    |\n";
		if (!(seoulBranch.Comtotal == 0)) {
			result += "서울지사     컴퓨터     " + seoulBranch.computerPrice + "      "
					+ seoulBranch.comsales +"      "+ seoulBranch.Comtotal + "\n";
		}if (!(seoulBranch.Printtotal == 0)) {
			result += "서울지사     프린터     " + seoulBranch.printerPrice + "      "
					+ seoulBranch.printsales +"      "+ seoulBranch.Printtotal + "\n";
		}if (!(kyunginBranch.Comtotal == 0)) {
			result += "경인지사     컴퓨터     " + kyunginBranch.computerPrice + "      "
					+ kyunginBranch.comsales +"      "+ kyunginBranch.Comtotal + "\n";
		}if (!(kyunginBranch.Printtotal ==0)) {
			result += "경인지사     프린터     " + kyunginBranch.printerPrice + "      "
					+ kyunginBranch.printsales +"      "+ kyunginBranch.Printtotal + "\n";
		}if (!(kangwonBranch.Comtotal == 0)) {
			result += "강원지사     컴퓨터     " + kangwonBranch.computerPrice + "      "
					+ kangwonBranch.comsales +"      "+ kangwonBranch.Comtotal + "\n";
		}if (!(kangwonBranch.Printtotal ==0)) {
			result += "강원지사     프린터     " + kangwonBranch.printerPrice + "      "
					+ kangwonBranch.printsales +"      "+ kangwonBranch.Printtotal + "\n";
		}if (!(jejuBranch.Comtotal == 0)) {
			result += "제주지사     컴퓨터     " + jejuBranch.computerPrice + "      "
					+ jejuBranch.comsales +"      "+ jejuBranch.Comtotal + "\n";
		}if (!(jejuBranch.Printtotal ==0)) {
			result += "제주지사     프린터     " + jejuBranch.printerPrice + "      "
					+ jejuBranch.printsales +"      "+ jejuBranch.Printtotal + "\n";
		}
		JOptionPane.showMessageDialog(null, result);
	}
	
	public void exit () {
		JOptionPane.showMessageDialog(null, "프로그램을 종료합니다.");
		check = true;
	}
}
