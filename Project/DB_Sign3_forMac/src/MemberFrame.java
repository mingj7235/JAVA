

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MemberFrame extends JFrame implements ActionListener {
	JPanel p;
	JTextField tfId, tfName, tfAddr, tfEmail;
	JTextField tfTel1, tfTel2, tfTel3;
	JComboBox cbJob; // 잡
	JPasswordField pfpwd; // 비번
	JTextField tfYear, tfMonth, tfDate; // 생년월일
	JRadioButton rbMan, rbWoman; // 성별
	JTextField taDateY,taDateM,taDateD; // 등록날짜
	JTextField taDateCheck; // 만료기간 
	JButton btnInsert, btnCancel, btnUpdate, btnDelete, btnAccept;
	// 가입,취소,수정,탈퇴

	GridBagLayout gb;
	GridBagConstraints gbc;
	Member_Main mMain;

	public MemberFrame() { // 가입용생성자
		createUI(); // UI 작성해주는 메소드
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
	}

	public MemberFrame(Member_Main mMain) { // 가입용 생성자
		createUI(); // UI 작성해주는 메소드
		btnUpdate.setEnabled(false);
		btnUpdate.setVisible(false);
		btnDelete.setEnabled(false);
		btnDelete.setVisible(false);
		this.mMain = mMain;
	}

	public MemberFrame(String id, Member_Main mMain) { // 수정,삭제용 생성자
		createUI();
		btnInsert.setEnabled(false);
		btnInsert.setVisible(false);
		this.mMain = mMain;

		System.out.println("id = "+id);
		MemberDAO dao = new MemberDAO();
		MemberDTO vMem = dao.getMemberDTO(id);
		viewData(vMem); // 
	} 
	public void viewData(MemberDTO vMem) { //dto의 회원정보를 가지고 화면에 셋팅해줌
		String id = vMem.getId();
		String pwd = vMem.getPwd();
		String name = vMem.getName();
		String tel = vMem.getTel();
		String addr = vMem.getAddr();
		String birth = vMem.getBirth();
		String job = vMem.getJob();
		String gender = vMem.getGender();
		String email = vMem.getEmail();
		String date = vMem.getDate();
		String dateCheck = vMem.getDateCheck();

		// 화면 
		tfId.setText(id);
		tfId.setEnabled(false); // 편집 불가
		pfpwd.setText(""); // pwd 가리기
		tfName.setText(name);
		String[] tels = tel.split("-");
		tfTel1.setText(tels[0]); tfTel2.setText(tels[1]); tfTel3.setText(tels[2]);
		tfAddr.setText(addr);

		tfYear.setText(birth.substring(0,4)); 
		tfMonth.setText(birth.substring(5,7));
		tfDate.setText(birth.substring(8,10));

		cbJob.setSelectedItem(job);
		if(gender.equals("남")) rbMan.setSelected(true);
		else if (gender.equals("여")) rbWoman.setSelected(true);
		tfEmail.setText(email);
		taDateY.setText(date.substring(0,4));
		taDateM.setText(date.substring(5,7));
		taDateD.setText(date.substring(8,10));
		taDateCheck.setText(dateCheck.substring(0,3));
	}
	

	public void createUI() {
		this.setTitle("회원정보");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;

		// id
		JLabel bId = new JLabel("아이디 : ");
		tfId = new JTextField(20);
		gbAdd(bId, 0, 0, 1, 1);
		gbAdd(tfId, 1, 0, 3, 1);
		// pwd
		JLabel bpwd = new JLabel("비밀번호 : ");
		pfpwd = new JPasswordField(20);
		gbAdd(bpwd, 0, 1, 1, 1);
		gbAdd(pfpwd, 1, 1, 3, 1);
		// 이름
		JLabel bName = new JLabel("이름 : ");
		tfName = new JTextField(20);
		gbAdd(bName, 0, 2, 1, 1);
		gbAdd(tfName, 1, 2, 3, 1);
		//전화번호
		JLabel bTel = new JLabel("전화 : ");
		JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tfTel1 = new JTextField(6);
		tfTel2 = new JTextField(6);
		tfTel3 = new JTextField(6);
		pTel.add(tfTel1);
		pTel.add(new JLabel(" - "));
		pTel.add(tfTel2);
		pTel.add(new JLabel(" - "));
		pTel.add(tfTel3);
		gbAdd(bTel, 0, 3, 1, 1);
		gbAdd(pTel, 1, 3, 3, 1);
		//주소 
		JLabel bAddr = new JLabel("주소 : ");
		tfAddr = new JTextField(20);
		gbAdd(bAddr, 0, 4, 1, 1);
		gbAdd(tfAddr, 1, 4, 3, 1);
		//생일
		JLabel bBirth = new JLabel("생일 : ");
		tfYear = new JTextField(6);
		tfMonth = new JTextField(6);
		tfDate = new JTextField(6);
		JPanel pBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pBirth.add(tfYear);
		pBirth.add(new JLabel("/"));
		pBirth.add(tfMonth);
		pBirth.add(new JLabel("/"));
		pBirth.add(tfDate);
		gbAdd(bBirth, 0, 5, 1, 1);
		gbAdd(pBirth, 1, 5, 3, 1);
		//직업
		JLabel bJob = new JLabel("직업 : ");
		String[] arrJob = {"---","학생","직장인","주부","개발자","백수"};
		cbJob = new JComboBox(arrJob);
		JPanel pJob = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pJob.add(cbJob);
		gbAdd(bJob,0,6,1,1);
		gbAdd(pJob, 1, 6, 3, 1);
		// 성별
		JLabel bGender = new JLabel("성별 : ");
		JPanel pGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rbMan = new JRadioButton("남", true);
		rbWoman = new JRadioButton("여", true);
		ButtonGroup group = new ButtonGroup();
		group.add(rbMan);
		group.add(rbWoman);
		pGender.add(rbMan);
		pGender.add(rbWoman);
		gbAdd(bGender, 0, 7, 1, 1);
		gbAdd(pGender, 1, 7, 3, 1);
		//이메일
		JLabel bEmail = new JLabel("이메일 : ");
		tfEmail = new JTextField(20);
		gbAdd(bEmail, 0, 8, 1, 1);
		gbAdd(tfEmail, 1, 8, 3, 1);
		// date, datecheck
		JLabel bDate = new JLabel("등록 날짜 : ");
		taDateY = new JTextField(6); //행,열
		taDateM = new JTextField(6); //
		taDateD = new JTextField(6); //행,열
		JPanel pane = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		JScrollPane pane = new JScrollPane(taDated);
		pane.add(taDateY);
		pane.add(new JLabel("/"));
		pane.add(taDateM);
		pane.add(new JLabel("/"));
		pane.add(taDateD);
		gbAdd(bDate, 0, 9, 1, 1);
		gbAdd(pane, 1, 9, 3, 1);
		JLabel bDateCheck = new JLabel("만료 기간 : ");
		taDateCheck = new JTextField(2); //행,열
		JScrollPane pane2 = new JScrollPane(taDateCheck);
		gbAdd(bDateCheck, 0, 10, 1, 1);
		gbAdd(pane2, 1, 10, 1, 1);
		//버튼
		JPanel pButton = new JPanel();
		btnInsert = new JButton("가입");
		btnUpdate = new JButton("수정");
		btnDelete = new JButton("탈퇴");
		btnCancel = new JButton("취소");
		pButton.add(btnInsert);
		pButton.add(btnUpdate);
		pButton.add(btnDelete);
		pButton.add(btnCancel);
		gbAdd(pButton, 0, 11, 4, 1);
		//버튼 감지기
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnCancel.addActionListener(this);

		setSize(650,750);
		setVisible(true);
		setLocationRelativeTo(null); // 중앙에서 시작
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); //
	}

	public void gbAdd(JComponent c, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gb.setConstraints(c, gbc);
		gbc.insets = new Insets(2, 2, 2, 2);
		add(c,gbc);
	}	

	public static void main(String[] args) {
		new MemberFrame();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnInsert ) {
			insertMember();
			System.out.println("호출 종료");
		} else if (ae.getSource() == btnCancel) {
			this.dispose(); // 현재 창 닫기
			// system.exit(0)모든창 닫기
		} else if (ae.getSource() == btnUpdate ) {
			UpdateMember();
		} else if (ae.getSource() == btnDelete ) {
			int x = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);
			if ( x == JOptionPane.OK_OPTION) deleteMember();
			else JOptionPane.showMessageDialog(this, "삭제 취소");
		}
		mMain.jTableRefresh();
	}

	private void deleteMember() {
		String id = tfId.getText();
		if(id.length() == 0 ) {
			JOptionPane.showMessageDialog(this, "id 필수 입력");
			return;
		}
		String pwd = pfpwd.getText();
		if(pwd.length() == 0 ) {
			JOptionPane.showMessageDialog(this, "비밀번호 필수 입력");
			return;
		}
		
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.deleteMember(id, pwd);
		if(ok) {
			JOptionPane.showMessageDialog(this, "삭제 완료");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "비밀번호를 다시 확인하세요.");
			JOptionPane.showMessageDialog(this, "삭제 실패");
		}
	}

	private void UpdateMember() {
		// 
		MemberDTO dto = getViewData();
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.updateMember(dto);
		if(ok) {
			JOptionPane.showMessageDialog(this, "수정 완료");
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "수정 실패");
		}
	}

	private void insertMember() {
		// 화면에서  사용자가 입력한 내용 얻기
		MemberDTO dto = getViewData(); // 회원정보 얻기
		MemberDAO dao = new MemberDAO(); // 정보로 DB수정
		String id = tfId.getText();
		if(id.length() == 0 ) {
			JOptionPane.showMessageDialog(this, "id 필수 입력");
			return;
		}
		String pwd = pfpwd.getText();
		if(pwd.length() == 0 ) {
			JOptionPane.showMessageDialog(this, "비밀번호 필수 입력");
			return;
		}
		String name = tfName.getText();
		if(name.length() <= 1 ) { // 한글자 이하 일 경우 
			JOptionPane.showMessageDialog(this, "이름 2자 이상 필수 입력");
			return;
		}
		boolean ok = dao.insertMember(dto);
		if(ok) {
			JOptionPane.showMessageDialog(this, "가입이 완료 되었습니다.");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "가입이 정상 처리가 되지 않았습니다.");
		}
	}
	public MemberDTO getViewData() {

		MemberDTO dto = new MemberDTO();
		// 화면에서 사용자가 입력한 내용을 얻음
		String id = tfId.getText();
		String pwd = pfpwd.getText();
		String name = tfName.getText();
		String tel1 = tfTel1.getText();
		String tel2 = tfTel2.getText();
		String tel3 = tfTel3.getText();
		String tel = tel1+"-"+tel2+"-"+tel3;//전화번호
		String addr = tfAddr.getText();
		String birth1 = tfYear.getText();
		String birth2 = tfMonth.getText();
		String birth3 = tfDate.getText();
		String birth = birth1+"-"+birth2+"-"+birth3; // 합치기
		String job = (String)cbJob.getSelectedItem();
		String gender = "";
		if(rbMan.isSelected()) gender = "남";
		else if(rbWoman.isSelected()) gender = "여";
		String email = tfEmail.getText();
		String date1 = taDateY.getText();
		String date2 = taDateM.getText();
		String date3 = taDateD.getText();
		String date = date1+"-"+date2+"-"+date3;
		String dateCheck = taDateCheck.getText()+"일";
		
		dto.setId(id); dto.setPwd(pwd); dto.setName(name); dto.setTel(tel); dto.setAddr(addr);
		dto.setBirth(birth); dto.setJob(job); dto.setGender(gender); dto.setEmail(email);
		dto.setDate(date); dto.setDateCheck(dateCheck); // dto에 담기
		return dto;
	}
}
