package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.StringTokenizer;

//화면 gui
public class ManagerGUI {
	//화면에 관련된 컴포넌트들을 전역 변수로 선언
	Frame frame;
	Panel[] panel;
	Label lblTitle, lblName, lblHeight, lblWeight, lblSex, lblAge, lblStatus;
	TextField tfName, tfHeight, tfWeight, tfAge;
	Button btnSave, btnDelete, btnUpdate, btnReset, btnSearch;
	List list;
	Checkbox chMale, chFemale;
	CheckboxGroup chGroup;
	
	public ManagerGUI () {
		frame = new Frame("회원관리");
		panel = new Panel[13];
		for(int i=0; i<panel.length;i++) {
//			패널을 13개 생성하는 것임 -> 반복문으로 
			panel[i] = new Panel();
		}
		
		//컴포넌트 생성
		lblTitle = new Label("회원관리", Label.CENTER);
		Font font = new Font("dialog", Font.BOLD, 20);
		lblTitle.setFont(font);
		lblTitle.setForeground(new Color(123,54,32));
		
		lblName = new Label("이름");
		lblAge = new Label("나이");
		lblHeight = new Label("키");
		lblWeight = new Label("체중");
		lblSex = new Label("성별");
		lblStatus = new Label("체중");
		lblStatus.setBackground(Color.LIGHT_GRAY);
		
		tfName = new TextField("");
		tfHeight = new TextField("");
		tfWeight = new TextField("");
		tfAge = new TextField("");
		
		btnSave = new Button("저장");
		btnSearch = new Button("검색");
		btnDelete = new Button("삭제");
		btnUpdate = new Button("수정");
		btnReset = new Button("지우기");
		
		//체크박스 만들기위해 그루핑 (Checkbox생성자 2번째 매개변수가 그룹명이다.) 
		chGroup = new CheckboxGroup(); 
		chMale = new Checkbox("Male", chGroup, true);
		chFemale = new Checkbox("Female", chGroup, false);
		
		//리스트 -> 7줄을 주고 하나만 눌릴수있게끔
		list = new List(7, false);
		
		//닫기 버튼 활성화
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); //종료하라는 것임
			}
		});
		
		//리스트 부분을 하나씩 가져오기
		//리스트를 클릭하면 이벤트가 발생함 -> 즉, 이벤트가 메모리를 읽어가서 담기는 것임 
		list.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String str = list.getSelectedItem(); //리스트에서 선택된 정보 한줄 모두가 string으로 반환됨
				StringTokenizer st = new StringTokenizer(str); //한줄이므로 그걸 토큰화 시켜줘야한다
				tfName.setText(st.nextToken());
				tfAge.setText(st.nextToken());
				tfWeight.setText(st.nextToken());
				tfHeight.setText(st.nextToken());
				String sex = st.nextToken();
				if(sex.equals("남")) {
					chMale.setState(true);
				}else {
					chFemale.setState(true);
				}
			}
		});
		
	}
	
	private void launchFrame() {
		panel[1].setLayout(new GridLayout(2, 1));
		panel[1].add(lblName);
		panel[1].add(lblHeight);
		panel[2].setLayout(new GridLayout(2, 1));
		panel[2].add(tfName);
		panel[2].add(tfHeight);
		
		panel[3].setLayout(new BorderLayout());
		panel[3].add(panel[1], "West");
		panel[3].add(panel[2], "Center");
		panel[3].add(new Label(""), "East");
		panel[4].setLayout(new GridLayout(2,1));
		panel[4].add(lblAge);
		panel[4].add(lblWeight);
		panel[5].setLayout(new GridLayout(2,1));
		panel[5].add(tfAge);
		panel[5].add(tfWeight);
		panel[6].setLayout(new BorderLayout());
		panel[6].add(panel[4], "West");
		panel[6].add(panel[5], "Center");
		panel[6].add(new Label(""), "East");
		panel[7].setLayout(new GridLayout(1,2));
		panel[7].add(panel[3]);
		panel[7].add(panel[6]);
		panel[8].add(lblSex);
		panel[8].add(chMale);
		panel[8].add(chFemale);
		panel[9].setLayout(new BorderLayout());
		panel[9].add(lblTitle, "North");
		panel[9].add(panel[7], "Center");
		panel[9].add(panel[8], "South");
		panel[10].setLayout(new GridLayout(1,5));
		panel[10].setBackground(Color.black);
		panel[10].setForeground(Color.white);
		panel[10].add(new Label("이 름   "));
		panel[10].add(new Label("나 이   "));
		panel[10].add(new Label("체 중  "));
		panel[10].add(new Label(" 키    "));
		panel[10].add(new Label("성 별   "));
		panel[11].setLayout(new BorderLayout());
		panel[11].add(panel[10], "North");
		panel[11].add(list, "Center");
		panel[0].add(btnSave);
		panel[0].add(new Label(" "));
		panel[0].add(btnSearch);
		panel[0].add(new Label(" "));
		panel[0].add(btnDelete);
		panel[0].add(new Label(" "));
		panel[0].add(btnUpdate);
		panel[0].add(new Label(" "));
		panel[0].add(btnReset);
		panel[12].setLayout(new BorderLayout());
		panel[12].add(panel[9], "North");
		panel[12].add(panel[11], "Center");
		panel[12].add(panel[0], "South");
		
		frame.add(panel[12], "Center");
		frame.add(lblStatus, "South");
		frame.pack();
		frame.setResizable(false);
		//창을 어떤 화면의 크기에 상관ㅇ벗이 가운데 오게 하기
		frame.setLocation( ((frame.getToolkit().getScreenSize()).width -frame.getWidth()) /2, 
				((frame.getToolkit().getScreenSize()).height -frame.getHeight()) /2 );
		
		frame.setVisible(true);
		
		displayAll(); //회원 정보 보기 메소드
		
	}//end launchFrame ()
	
	public void displayAll() {
		list.removeAll(); //리스트(awt) 화면 클리어
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> allData = dao.select();
		for (MemberDTO dto : allData) {
			String name = dto.getName();
			int age = dto.getAge();
			int height = dto.getHeight();
			int weight = dto.getWeight();
			char sex = dto.getSex();
			list.add(name + "             " + age + "                 " + weight + "               "  + height + "                " + sex);
		}
	}

	public static void main(String[] args) {
		ManagerGUI mem = new ManagerGUI();
		mem.launchFrame();
	}

}
