package gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class MainFrame extends JFrame implements ActionListener{

	LoginPanel login = new LoginPanel();
	ContentsPanel contents = new ContentsPanel();
	InputPanel input = new InputPanel();
	SearchPanel search = new SearchPanel();
	CardLayout card = new CardLayout();
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("메뉴");
	JMenuItem loginMenu = new JMenuItem("로그인창");
	JMenu contentsMenu = new JMenu("목차");
	JMenuItem inputItem = new JMenuItem("강사 입력");
	JMenuItem searchItem = new JMenuItem("강사 검색");
	JMenuItem fireItem = new JMenuItem("퇴사");
	JMenuItem bonusItem = new JMenuItem("보너스");
	JMenuItem listItem = new JMenuItem("목록");
	JMenuItem exitItem = new JMenuItem("종료");
	public MainFrame() {
		
		menu.add(loginMenu);
		loginMenu.addActionListener(this);
		inputItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,Event.CTRL_MASK));
		inputItem.addActionListener(this);
		searchItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,Event.CTRL_MASK));
		searchItem.addActionListener(this);
		fireItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,Event.CTRL_MASK));
		fireItem.addActionListener(this);
		bonusItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,Event.CTRL_MASK));
		bonusItem.addActionListener(this);
		listItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,Event.CTRL_MASK));
		listItem.addActionListener(this);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,Event.CTRL_MASK));
		exitItem.addActionListener(this);
		
		contentsMenu.add(inputItem);
		contentsMenu.add(searchItem);
		contentsMenu.add(fireItem);
		contentsMenu.add(bonusItem);
		contentsMenu.add(listItem);
		contentsMenu.add(exitItem);
		menu.add(contentsMenu);
		menubar.add(menu);
		JMenu inputMenu = new JMenu("강사 입력");
		JMenuItem inputItem2 = new JMenuItem("강사 입력");
		inputMenu.add(inputItem2);
		menubar.add(inputMenu);
		JMenu searchMenu = new JMenu("강사 검색");
		JMenuItem searchItem2 = new JMenuItem("강사 검색");
		searchMenu.add(searchItem2);
		menubar.add(searchMenu);
		JMenu fireMenu = new JMenu("퇴사");
		JMenuItem fireItem2 = new JMenuItem("퇴사");
		fireMenu.add(fireItem2);
		menubar.add(fireMenu);
		JMenu bonusMenu = new JMenu("보너스");
		JMenuItem bonusItem2 = new JMenuItem("보너스");
		bonusMenu.add(bonusItem2);
		menubar.add(bonusMenu);
		JMenu listMenu = new JMenu("목록");
		JMenuItem listItem2 = new JMenuItem("목록");
		listMenu.add(listItem2);
		menubar.add(listMenu);
		JMenu exitMenu = new JMenu("종료");
		JMenuItem exitItem2 = new JMenuItem("종료");
		exitMenu.add(exitItem2);
		menubar.add(exitMenu);
		
		setJMenuBar(menubar);
		
		
		setTitle("강사관리 프로그램"); // setTitle()는 JFrame에서만 쓸 수 있다. JPanel에서는 쓸 수 없다.
		setLayout(card);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); 
		
		setSize(800, 800);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		
		int x = (screenSize.width - frameSize.width)/2;
		int y = (screenSize.height - frameSize.height)/2;
		setLocation(x, y);
		
		login.loginButton.addActionListener(this);
		contents.inputButton.addActionListener(this);
		contents.listButton.addActionListener(this);
		contents.fireButton.addActionListener(this);
		contents.searchButton.addActionListener(this);
		contents.bonusButton.addActionListener(this);
		search.leaveButton.addActionListener(this);
		
		add("Login", login);
		add("Contents", contents);
		add("Search", search);
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new MainFrame();
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == login.loginButton) {
			
			login.inputpw = "";
			for (int i = 0; i < login.pwText.getPassword().length; i++) {
				login.inputpw += login.pwText.getPassword()[i];
			}
			
			if(login.id.equals(login.idText.getText()) && 
					login.pw.equals(login.inputpw)) {
				JOptionPane.showMessageDialog(login, "로그인성공","로그인성공",JOptionPane.INFORMATION_MESSAGE);
				card.show(getContentPane(), "Contents");
			}else {
				JOptionPane.showMessageDialog(login, "로그인실패","경고메세지",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getSource() == contents.inputButton) {
			new InputFrame();
		}
		if(e.getSource() == contents.listButton) {
			new ListFrame();
		}
		if(e.getSource() == contents.fireButton) {
			new FireFrame();
		}
		if(e.getSource() == search.leaveButton) {
			card.show(getContentPane(), "Contents");
		}
		if(e.getSource() == contents.searchButton) {
			card.show(getContentPane(), "Search");
		}
		if(e.getSource() == contents.bonusButton) {
			String[] name = {"박종혁","한재구","진세종","박종우","이현제","정진홍","신은주","이승미","박혜진"};
			Random random = new Random();
			JOptionPane.showMessageDialog(this, "축하합니다!!\n당첨자: "+ name[random.nextInt(name.length)]);
		}
		if(e.getSource() == inputItem) {
			new InputFrame();
		}else if(e.getSource() == searchItem) {
			card.show(getContentPane(), "Search");
		}else if(e.getSource() == fireItem) {
			new FireFrame();
		}else if(e.getSource() == bonusItem) {
			String[] name = {"박종혁","한재구","진세종","박종우","이현제","정진홍","신은주","이승미","박혜진"};
			Random random = new Random();
			JOptionPane.showMessageDialog(this, "축하합니다!!\n당첨자: "+ name[random.nextInt(name.length)]);
		}else if(e.getSource() == listItem) {
			new ListFrame();
		}else if(e.getSource() == exitItem) {
			JOptionPane.showMessageDialog(this, "행복한 하루 되세요~","행복한 하루되세요",
															JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
		if(e.getSource() == loginMenu) {
			card.show(getContentPane(), "Login");
		}
		
	}

}