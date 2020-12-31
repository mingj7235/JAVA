package view;

import java.awt.*;

import java.awt.event.*;

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
		lblStatus = new Label("");
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
		
		//저장버튼 : 회원 정보 저장하기 버튼에 저장 기능을 연결하는 것임
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String age = tfAge.getText();
				String weight = tfWeight.getText();
				String height = tfHeight.getText();
				String sex = "여";
				if(chMale.getState()) {
					sex="남";
				}
				MemberDAO dao = new MemberDAO ();
				dao.insert(name, age, weight, height, sex);
				displayAll();
				lblStatus.setText(name+ "님의 정보가 저장되었습니다.");
			}
		});
		
		//삭제버튼 : 연결하는 것임
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				MemberDAO dao = new MemberDAO ();
				dao.delete(name);
				displayAll();
				lblStatus.setText(name + "님의 정보가 삭제되었습니다.");
				
			}
		});
		
		//수정 버튼 
		
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String age = tfAge.getText();
				String weight = tfWeight.getText();
				String height = tfHeight.getText();
				String sex = "여";
				if(chMale.getState()) {
					sex="남";
				}
				
				MemberDAO dao = new MemberDAO();
				dao.update(name, age, weight, height, sex);
				displayAll();
				lblStatus.setText(name + "님의 정보가 수정되었습니다. ");
				
			}
		});
		
		//검색버튼
		
		//검색 버튼
	      btnSearch.addActionListener(new ActionListener() {

	         @Override
	         public void actionPerformed(ActionEvent e) {
	            String name = tfName.getText();
	            MemberDAO dao = new MemberDAO();
	            MemberDTO dto = new MemberDTO();

	            try {
	               dto = dao.search(name);
	            } catch (RecordNotFoundException e1) {
	               // TODO Auto-generated catch block
	               lblStatus.setText(e1.getMessage());
	               final Dialog dialog = new Dialog(frame, "경고");
	               dialog.setLayout(new FlowLayout());
	               dialog.setSize(200,80);
	               dialog.setTitle(e1.getMessage());
	               Button btnOk = new Button("확 인");
	               btnOk.addActionListener(new ActionListener() {
	                  
	                  @Override
	                  public void actionPerformed(ActionEvent e) {
	                     dialog.dispose();
	                     
	                  }
	               });
	               dialog.add(btnOk);
	               dialog.setVisible(true);
	               return;
	            }

				
				//dto 안에 있는 필드에 자료에 접근할 수있다. 즉, name으로 검색된 정보가 나온다. 
				//memberDAO의 search에서 해놓은 작업이다.
				
				//dto안에 있는걸 gui로 옮겨오는것이다. 
				tfName.setText(dto.getName());
				tfAge.setText(""+dto.getAge());
				tfHeight.setText(""+dto.getHeight());
				tfWeight.setText(""+dto.getWeight());
				String sex = Character.toString(dto.getSex()); //'남' -> "남" char를 string으로 변환
				if (sex.equals("남" )) {
					chMale.setState(true);
				}else {
					chFemale.setState(true);
				}
				lblStatus.setText(name + "님의 정보가 검색되었습니다.");
			}
		});
		
		
		//지우기 (삭제말고)
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tfName.setText("");
				tfAge.setText("");
				tfWeight.setText("");
				tfHeight.setText("");
				chGroup.setSelectedCheckbox(null);
				lblStatus.setText("항목이 지워졌습니다. 다시 입력해주세요");
			}
		});
		
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
