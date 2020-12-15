import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener {
	BufferedImage img = null;
	JTextField tfId;
	JPasswordField pfpwd; // 비번
	
	JButton btnInsert;
	JButton btnCancel, btnUpdate, btnDelete;
	
	GridBagLayout gb;
	GridBagConstraints gbc;

	Member_Main mMain;
	BMI_Test btest;
	class MyPanel extends JPanel { // 내부 클래스
		@Override
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}

	public LoginFrame() {
		setTitle("회원 로그인");
		authenUI2();
//		btest = new BMI_Test();
	}
	public void authenUI2() { // 회원 id 입력
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		try {
			img = ImageIO.read(new File("src/images/login1.png"));
		} catch (Exception e) {
			System.out.println("이미지 불러오기 실패 오류 : " + e.getMessage());
		}	
		
		// id
		JLabel bId = new JLabel("아이디 : ");
		tfId = new JTextField(12);
		gbAdd(bId, 0, 0, 1, 1);
		gbAdd(tfId, 1, 0, 3, 1);
		// pwd
		JLabel bpwd = new JLabel("비밀번호 : ");
		pfpwd = new JPasswordField(12);
		gbAdd(bpwd, 0, 1, 1, 1);
		gbAdd(pfpwd, 1, 1, 3, 1);
		
		//버튼
		JPanel pButton = new JPanel();
		btnInsert = new JButton("로그인");
		btnCancel = new JButton("로그인 취소");
		pButton.add(btnInsert);
		pButton.add(btnCancel);
		gbAdd(pButton, 0, 11, 4, 1);
		//버튼 감지기
		btnInsert.addActionListener(this);
		btnCancel.addActionListener(this);
		
		setSize(300, 150);
		setVisible(true);
		setLocationRelativeTo(null); // 중앙에서 시작
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //
	}
	public void authenUI() {
		boolean idCh = true, pwCh = true;
		MemberDAO dao = new MemberDAO();

		// 이미지 받아오기
		String id = JOptionPane.showInputDialog("아이디 입력", tfId);
		try {
			img = ImageIO.read(new File("src/images/login1.png"));
		} catch (Exception e) {
			System.out.println("이미지 불러오기 실패 오류 : " + e.getMessage());
		}

		// 레이아웃 설정
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 600, 400);
		layeredPane.setLayout(null);

		// 패널만들기
		MyPanel panel = new MyPanel();
		panel.setBounds(0, 0, 600, 400);

		// 로그인
		
		// 비밀번호

		// 패스워드

		// 마지막 추가들
		layeredPane.add(panel);
		add(layeredPane);
	}
	
	public void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2, 2, 2, 2);
		add(c, gbc);
	}
	
	public static void main(String[] args) {
		new LoginFrame();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnInsert) {
//			insertInbody();
			System.out.println("로그인 성공");
			this.dispose();
			btest = new BMI_Test();
		} else if (ae.getSource() == btnCancel) {
			System.out.println("로그인 취소");
			this.dispose();
		}		
	
	}
}