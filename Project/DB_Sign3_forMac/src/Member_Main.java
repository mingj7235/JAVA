/*
 * 0.2a ver :: Login Frame 구현 - 회원 로그인 후, 현 회원의 신체 기록 입력(BMI) , 저장은 구현중
 * 0.1i ver :: 키, 몸무게(height,weight)
 * 0.1h ver :: Table Data 추가 예정 => Inbody Check ==> 체중 측정까지만
 *
:: 추가 예정
- 사용방법 예시를 팝업으로 띄워줄지 말지, 별로 필요없을 듯
— 인바디 기록 서비스
홈 -> 기록버튼 생성 : 기록에서 패널을 열고 id,pw를 입력받기
키와 몸무게를 입력하여 db 저장 -> 저체중, 정상, 비만 측정 db저장-> 상세 기록은 인바디 실측정하여 프로그램에 저장시켜 관리하는 방식


 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Member_Main extends JFrame implements MouseListener,ActionListener{

	Vector v;
	Vector cols;
	DefaultTableModel model;
	JTable jTable;
	JScrollPane pane;
	JPanel pbtn,pbtn2;
	JButton btnInsert;
	JButton btnInsert2;
	JButton btnInsert3;

	public Member_Main() {
		super("Corner 피트니스 회원 관리 0.2a\tby corner"); // version updated : 2020-12-12
		MemberDAO dao = new MemberDAO();
		v = dao.getMember_Main();
		System.out.println("계정 정보 로딩 ="+v);
		cols = getColumn();

		model = new DefaultTableModel(v,cols);

		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		add(pane);

		pbtn = new JPanel();
		btnInsert = new JButton("회원가입");
		pbtn.add(btnInsert);
		add(pbtn,BorderLayout.WEST);

//		pbtn2 = new JPanel();
		btnInsert2 = new JButton("BMI 측정");
		pbtn.add(btnInsert2);
		add(pbtn,BorderLayout.WEST);
		btnInsert2.addActionListener(this); // BMI 버튼 등록


		jTable.addMouseListener(this);//listener등록
		btnInsert.addActionListener(this);//회원가입 버튼 등록

		setSize(1200,400);//가로, 세로
		setVisible(true);
		setLocationRelativeTo(null); // 중앙에서 시작
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Vector getColumn() { // 테이블 칼럼
		Vector col = new Vector();
		col.add("아이디");
		col.add("비밀번호");
		col.add("이름");
		col.add("전화번호");
		col.add("주소");
		col.add("생일");
		col.add("직업");
		col.add("성별");
		col.add("이메일");
		col.add("등록 날짜");
		col.add("만료 기간");

		return col;
	}
	public Vector getColumn2() { // inbody 테이블 칼럼
		Vector col = new Vector();
		col.add("아이디");
		col.add("비밀번호");
		col.add("회원명");
		col.add("키(height)");
		col.add("몸무게(weight)");

		return col;

	}

	public void jTableRefresh() { // 테이블 내용 갱신
		MemberDAO dao = new MemberDAO();

		DefaultTableModel model = new DefaultTableModel(dao.getMember_Main(),getColumn());
		jTable.setModel(model);

	}
	public void jTableRefresh2() { // 테이블 내용 갱신2, Inbody
		MemberDAO dao = new MemberDAO();
		DefaultTableModel model2 = new DefaultTableModel(dao.getInbodyMain(),getColumn2());
		jTable.setModel(model2);
	}

	public static void main(String[] args) {
		new Member_Main();

	} // main

	@Override
	public void mouseClicked(MouseEvent e) {
		int r = jTable.getSelectedRow();
		String id = (String) jTable.getValueAt(r, 0);
		MemberFrame mem = new MemberFrame(id,this); // 아이디 인자로 수정창 만들기
//		BMI_Test bmi = new BMI_Test(); // 수정창 열때 BMI창 열리므로 주석처리
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 클릭
		if(e.getSource() == btnInsert) new MemberFrame(this);
		else if(e.getSource() == btnInsert2)
			new LoginFrame();
//			new BMI_Test();

	}

}
