
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class BMI_Test extends JFrame implements ActionListener {
	
	double height, weight;
	JTextField tfId;
	JTextField tfName;
	JTextField tfHeight, tfWeight;
	TextField tfGender, tfBMI, reWe;
	JPasswordField pfpwd; // 비번
	TextArea ta;
	Button enter, reset;
	String BMI_Result;

	JButton btnInsert;
	JButton btnCancel, btnUpdate, btnDelete;

	GridBagLayout gb;
	GridBagConstraints gbc;

	Member_Main mMain;
	BufferedImage img = null;
	LoginFrame login;
	// GUI 구성
	public BMI_Test() {
		BMI_UI();
	}
//	class MyPanel extends JPanel{ // 내부 클래스 
//		@Override
//		public void paint(Graphics g) {
//			g.drawImage(img, 0, 0, null);
//		}
//	}
	
	public BMI_Test(Member_Main mMain) {
		BMI_UI();
		this.mMain = mMain;
	}

	public BMI_Test(String id, Member_Main mMain) { // 검색
		BMI_UI();
		btnInsert.setEnabled(false);
		btnInsert.setVisible(false);
		this.mMain = mMain;

		System.out.println("id = " + id);
		MemberDAO dao = new MemberDAO();
		MemberDTO vMem = dao.getInbodyDTO(id); // id매개변수

		viewData(vMem); //

	}

	public void viewData(MemberDTO vMem) { // 회원 일치 인증
		String id = vMem.getId(); // 회원 아이디
		String pwd = vMem.getPwd(); // 회원 비번
		String name = vMem.getName(); // 회원 이름
		String height = vMem.getHeight(); // 키
		String weight = vMem.getWeight(); // 몸무게

		// 화면
		tfId.setText(id);
		tfId.setEnabled(false);
		pfpwd.setText(""); // pwd 가리기
		tfName.setText(name);
		tfHeight.setText(height.substring(0, 4));
		tfWeight.setText(weight.substring(0, 3));

	}

	public void authenUI2() { // 회원 id 입력
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

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
		// 이름
		JLabel bName = new JLabel("이름 : ");
		tfName = new JTextField(16);
		gbAdd(bName, 0, 2, 1, 1);
		gbAdd(tfName, 1, 2, 3, 1);

		// 키
		JLabel bHeight = new JLabel("키(xxx.x)cm : ");
		tfHeight = new JTextField(5);
		gbAdd(bHeight, 0, 3, 1, 1);
		gbAdd(tfHeight, 1, 3, 3, 1);
		// 몸무게
		JLabel bWeight = new JLabel("몸무게(xxx.x)kg : ");
		tfWeight = new JTextField(5);
		gbAdd(bWeight, 0, 4, 1, 1);
		gbAdd(tfWeight, 1, 4, 3, 1);

		setSize(650, 300);
		setVisible(true);
		setLocationRelativeTo(null); // 중앙에서 시작
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //
	}

	public void BMI_UI() { // BMI 측정
		show();
		setSize(600, 400);
		setVisible(true);

		this.setTitle("비만 지수 측정과 당신의 표준체중");

		setLayout(new GridLayout(2, 1, 5, 5));
		setLocationRelativeTo(null); // 중앙스타트
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //
//		// 아이디 입력
//		Panel idP = new Panel();
//		idP.setBackground(Color.white);
//		idP.setLayout(new BorderLayout());
//		
//		idP.add(new Label("기록을 입력할 회원id를 입력하세요."));
//		
//		
		// 입력부분패널
		Panel p1 = new Panel();

		p1.setBackground(Color.WHITE);
		p1.setLayout(new BorderLayout());

		p1.add(new Label("키(cm)와 몸무게(kg)  입력하시고 아래의 '체크'버튼을 누르세요."), "North");

		Panel p11 = new Panel();
		p11.add(new Label("키(cm): "));
		tfHeight = new JTextField(5);
		p11.add(tfHeight);

		Label l = new Label("몸무게(kg): ");
		p11.add(l);
		tfWeight = new JTextField(5);
		p11.add(tfWeight);

		p1.add(p11, "Center");
		Panel p12 = new Panel();

//		JPanel pButton = new JPanel();
//		pButton.add(p12);
		btnInsert = new JButton("저장");
		btnInsert.addActionListener(this);
		
		enter = new Button("체크");
		reset = new Button("다시입력");
		enter.addActionListener(this);
		reset.addActionListener(this);


		p12.add(btnInsert);
		p12.add(enter);
		p12.add(reset);
		p1.add(p12, "South");
		add(p1);

		// 결과부분 패널
		Panel p2 = new Panel();
		p2.setLayout(new BorderLayout());

		p2.add(new Label("----------- 결 과 보 기 ------------"), "North");

		Panel p21 = new Panel();
		p21.add(new Label("비만지수(BMI):"));
		tfBMI = new TextField(5);
		p21.add(tfBMI);

		p21.add(new Label("표준체중(kg):"));
		reWe = new TextField(5);
		p21.add(reWe);

		p21.add(new Label("BMI로 본 당신의 상태는?"));
		ta = new TextArea(1, 20);
		p21.add(ta);
		p2.add(p21, "Center");

		add(p2);
		tfHeight.requestFocus();
	}

	public String BMI_Check(double BMI) {
		if (BMI < 20)
			BMI_Result = "저체중입니다. 더 먹어요!";
		else if (20 <= BMI && BMI < 25)
			BMI_Result = "정상입니다. 굿! 잘 유지해봐요!";
		else if (25 <= BMI && BMI < 30)
			BMI_Result = "과체중입니다. 조금 위험해요..";
		else if (BMI <= 30)
			BMI_Result = "비만입니다. 더 열심히 운동하고, 식단 조절해요.";
		else if (BMI > 30) 
			BMI_Result = "할많하않..";
		return BMI_Result;
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

	// 메인 
	public static void main(String[] args) {
		new BMI_Test();
	}

	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		String sheight = tfHeight.getText();
		String sweight = tfWeight.getText();
		
		
//		mMain.jTableRefresh2(); // 일단 보류
		if (s.equals("체크")) {
			if(sheight.length() == 0) { JOptionPane.showMessageDialog(this, "키(cm) 입력란이 빈칸 입니다."); return;}
			if(sweight.length() == 0) { JOptionPane.showMessageDialog(this, "몸무게(kg) 입력란이 빈칸 입니다."); return;}
			// 문자형인 키값을 int형으로 바꾼다.
			height = Double.valueOf(tfHeight.getText()).doubleValue();
			// 표준체중계산
			double N_weight = (height - 100) * 0.9;

			// 키값을 cm인 키를 m로 바꾼다.
			height = height / 100;
			System.out.println(height);
			weight = Double.valueOf(tfWeight.getText()).doubleValue();

			// BMI지수 계산
			double BMI = Math.round(weight / (height * height));
			// 결과를 추려낸다
			String re = BMI_Check(BMI);
			// 결과 출력
			tfBMI.setText("" + BMI);
			reWe.setText("" + N_weight);
			ta.setText(re);
		} else {
			tfHeight.setText("");
			tfWeight.setText("");
		}
		
		if (ae.getSource() == btnInsert) {
//			insertInbody();
			System.out.println("구현중....");
		} 
	}

	private void deleteInbody() {
		String id = tfId.getText();
		String pwd = pfpwd.getText();
		if (pwd.length() == 0) {
			JOptionPane.showMessageDialog(this, "비밀번호 필수 입력");
			return;
		}
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.deleteInbody(id, pwd);
		if (ok) {
			JOptionPane.showMessageDialog(this, "기록 삭제 완료");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "비밀번호를 다시 확인하세요.");
			JOptionPane.showMessageDialog(this, "기록 삭제 실패");
		}
	}

	private void updateInbody() {
		MemberDTO dto = getViewData();
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.updateInbody(dto);
		if (ok) {
			JOptionPane.showMessageDialog(this, "수정 완료");
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "수정 실패");
		}
	}

	private void insertInbody() {
		// 화면에서 사용자가 입력한 내용 얻기
		MemberDTO dto = getViewData(); // 회원정보 얻기
		MemberDAO dao = new MemberDAO(); // 정보로 DB수정
		boolean ok = dao.insertInbody(dto);
		if (ok) {
			JOptionPane.showMessageDialog(this, "신체 입력이 완료 되었습니다.");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "신체 입력 처리가 되지 않았습니다.");
		}
	}

	public MemberDTO getViewData() {
		MemberDTO dto = new MemberDTO();

		String id = tfId.getText();
		String pwd = pfpwd.getText();
		String name = tfName.getText();
		String height = tfHeight.getText();
		String weight = tfWeight.getText();

		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setHeight(height);
		dto.setWeight(weight);

		return dto;
	}

}