package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.plaf.FontUIResource;

public class ContentsPanel extends JPanel implements ActionListener{

	Image background = Toolkit.getDefaultToolkit().getImage("./src/img/목차.jpg");
	JButton inputButton = new JButton("1.강사 입력");
	JButton searchButton = new JButton("2.강사 검색");
	JButton fireButton = new JButton("3.퇴사");
	JButton bonusButton = new JButton("4.보너스");
	JButton listButton = new JButton("5.목록");
	JButton exitButton = new JButton("6.종료");
	JLabel title, buttonExplanation;
	JTextArea explanation;
	JPanel panel = new JPanel(new GridLayout(2,3)); // 2행 3열
	
	String text = " 강사관리 프로그램입니다.\n\n programmer: PPak\n\n since:2020/12/11";
	
	public ContentsPanel() {

		setLayout(null);
		title = new JLabel("강사관리 프로그램");
		title.setFont(new Font("고딕체", Font.BOLD, 70)); // 글자 형태
		title.setForeground(Color.BLUE); // 글자 색깔
		title.setBounds(90, 20, 800, 200);
		add(title);
		
		panel.setBounds(150, 570, 300, 100);
		panel.add(inputButton);
		panel.add(searchButton);
		panel.add(fireButton);
		panel.add(bonusButton);
		panel.add(listButton);
		panel.add(exitButton);
		add(panel);
		
		explanation = new JTextArea(text);
		explanation.setFont(new Font("고딕체",Font.BOLD,20));
		explanation.setBounds(90, 200, 300, 150);
		explanation.setEditable(false);
		add(explanation);
		
		buttonExplanation = new JLabel("<<원하시는 버튼을 누르세요>>");
		buttonExplanation.setFont(new Font("고딕체", Font.BOLD, 15));
		buttonExplanation.setBounds(150, 450, 300, 200);
		add(buttonExplanation);
		
		inputButton.addActionListener(this);
		searchButton.addActionListener(this);
		fireButton.addActionListener(this);
		bonusButton.addActionListener(this);
		listButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		
//		setFocusable(true);
//		addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if(e.getKeyCode()==KeyEvent.VK_6) {
//					exitButton.doClick();
//				}
//			}
//		});
		
		
		InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = this.getActionMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_6, InputEvent.SHIFT_DOWN_MASK),"exitButtonClick");
		actionMap.put("exitButtonClick", exitButtonClick);
		
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.SHIFT_DOWN_MASK), "inputButtonClick");
		actionMap.put("inputButtonClick", inputButtonClick);
		
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.SHIFT_DOWN_MASK), "searchButtonClick");
		actionMap.put("searchButtonClick", searchButtonClick);
		
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.SHIFT_DOWN_MASK), "fireButtonClick");
		actionMap.put("fireButtonClick", fireButtonClick);
		
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.SHIFT_DOWN_MASK), "bonusButtonClick");
		actionMap.put("bonusButtonClick", bonusButtonClick);
		
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.SHIFT_DOWN_MASK), "listButtonClick");
		actionMap.put("listButtonClick", listButtonClick);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == exitButton) {
			JOptionPane.showMessageDialog(this, "행복한 하루 되세요~","행복한 하루되세요",JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
		
	}

	Action exitButtonClick  = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			exitButton.doClick();
		}
	};
	
	Action inputButtonClick = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			inputButton.doClick();
		}
	};
	
	Action searchButtonClick = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {
			searchButton.doClick();
		}
	};

	Action fireButtonClick = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {
			fireButton.doClick();
		}
	};
	
	Action bonusButtonClick = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			bonusButton.doClick();
		}
	};	
	
	Action listButtonClick = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			listButton.doClick();
		}
	};
}
