package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class InputPanel extends JPanel implements ActionListener{

	Image background = Toolkit.getDefaultToolkit().getImage("./src/img/강사입력.png");
	JLabel name, tell, department, fire, notes, gender, career, bonus, studentNumber, tellDash1, tellDash2;
	JTextField nameText, tellText1, tellText2, careerText, studentNumberText;
	JTextArea notesTextArea;
	JRadioButton departmentHighButton,departmentMiddleButton, genderManButton, genderWomanButton;
	JCheckBox bonusNotButton,bonus1000Button,bonus2000Button, fireButton, fireNotButton;
	JComboBox<String> tellCombo;
	JButton inputButton;
	JButton	leaveButton;
	
	
		public InputPanel() {
		
		setLayout(null);
		Box left = Box.createVerticalBox();
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new TitledBorder(new EtchedBorder(),"강사 정보"));
		leftPanel.add(left);
		
		Box right = Box.createVerticalBox();
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(new TitledBorder(new EtchedBorder(),"참고사항"));
		rightPanel.add(right);		
		
		Box center = Box.createHorizontalBox();
		center.add(leftPanel);
		center.add(rightPanel);
		center.setBounds(20, 20, 750, 440);
		center.setOpaque(false);
		leftPanel.setOpaque(false);
		rightPanel.setOpaque(false);
		add(center);
		
		name = new JLabel("이름", JLabel.RIGHT);
		tell = new JLabel("전화번호", JLabel.RIGHT);
		department = new JLabel("부서", JLabel.RIGHT);
		career = new JLabel("경력", JLabel.RIGHT);
		studentNumber = new JLabel("학생수", JLabel.RIGHT);
		gender = new JLabel("성별", JLabel.RIGHT);
		bonus = new JLabel("보너스", JLabel.RIGHT);
		fire = new JLabel("퇴사", JLabel.RIGHT);
		notes = new JLabel("참고사항", JLabel.RIGHT);
		tellDash1 = new JLabel("-");
		tellDash2 = new JLabel("-");
		
		nameText = new JTextField();
		tellText1 = new JTextField();
		tellText2 = new JTextField();
		careerText = new JTextField();
		studentNumberText = new JTextField();
		
		departmentHighButton = new JRadioButton("고등부");
		departmentMiddleButton = new JRadioButton("중등부");
		ButtonGroup departmentButtonGroup = new ButtonGroup(); // 그룹으로 묶으면 한개를 선택하면 다른것은 선택이 안된다
		departmentButtonGroup.add(departmentHighButton);
		departmentButtonGroup.add(departmentMiddleButton);
		tellCombo = new JComboBox<String>();
		tellCombo.addItem("010");
		tellCombo.addItem("011");
		tellCombo.addItem("070");
		genderManButton = new JRadioButton("남자");
		genderWomanButton = new JRadioButton("여자");
		ButtonGroup genderButtonGroup = new ButtonGroup();
		genderButtonGroup.add(genderManButton);
		genderButtonGroup.add(genderWomanButton);
		
		bonusNotButton = new JCheckBox("0");
		bonus1000Button = new JCheckBox("1000");
		bonus2000Button = new JCheckBox("2000");
		ButtonGroup bonusButtonGroup = new ButtonGroup();
		bonusButtonGroup.add(bonusNotButton);
		bonusButtonGroup.add(bonus1000Button);
		bonusButtonGroup.add(bonus2000Button);

		fireButton = new JCheckBox("해고");
		fireNotButton = new JCheckBox("해당없음");
		ButtonGroup fireButtonGroup = new ButtonGroup();
		fireButtonGroup.add(fireButton);
		fireButtonGroup.add(fireNotButton);
		
		inputButton = new JButton("입력");
		leaveButton = new JButton("나가기");
		
		notesTextArea = new JTextArea();
		
		name.setBounds(30, 50, 70, 70);
		add(name);
		nameText.setBounds(120, 70, 70, 30);
		add(nameText);
		
		tell.setBounds(30, 110, 70, 70);
		add(tell);
		tellCombo.setBounds(120, 130, 60,30);
		add(tellCombo);
		tellDash1.setBounds(190, 130, 30, 30);
		add(tellDash1);
		tellText1.setBounds(200, 130, 60, 30);
		add(tellText1);
		tellDash2.setBounds(270, 130, 30, 30);
		add(tellDash2);
		tellText2.setBounds(280, 130, 60, 30);
		add(tellText2);
		
		department.setBounds(30, 170, 70, 70);
		add(department);
		departmentHighButton.setBounds(120,190,80,30);
		departmentHighButton.setOpaque(false);
		add(departmentHighButton);
		departmentMiddleButton.setBounds(210,190,80,30);
		departmentMiddleButton.setOpaque(false);
		add(departmentMiddleButton);
		
		career.setBounds(30, 230, 70, 70);
		add(career);
		careerText.setBounds(120, 250, 50, 30);
		add(careerText);
		
		studentNumber.setBounds(30, 290, 70, 70);
		add(studentNumber);
		studentNumberText.setBounds(120, 310, 50, 30);
		add(studentNumberText);
		
		gender.setBounds(30, 350, 70, 70);
		add(gender);
		genderManButton.setBounds(120, 370, 70, 30);
		genderManButton.setOpaque(false);
		add(genderManButton);
		genderWomanButton.setBounds(200, 370, 70, 30);
		genderWomanButton.setOpaque(false);
		add(genderWomanButton);
		
		bonus.setBounds(400, 50, 70, 70);
		add(bonus);
		bonusNotButton.setBounds(490, 70, 80, 30);
		bonusNotButton.setOpaque(false);
		add(bonusNotButton);
		bonus1000Button.setBounds(550, 70, 80, 30);
		bonus1000Button.setOpaque(false);
		add(bonus1000Button);
		bonus2000Button.setBounds(630, 70, 80, 30);
		bonus2000Button.setOpaque(false);
		add(bonus2000Button);
		
		fire.setBounds(400, 110, 70, 70);
		add(fire);
		fireNotButton.setBounds(490, 130, 90, 30);
		fireNotButton.setOpaque(false);
		add(fireNotButton);
		fireButton.setBounds(590, 130, 70, 30);
		fireButton.setOpaque(false);
		add(fireButton);
		
		notes.setBounds(400, 170, 70, 70);
		add(notes);
		notesTextArea.setBounds(485, 195, 250, 220);
		add(notesTextArea);
		
		inputButton.setBounds(610, 710, 70, 50);
		add(inputButton);
		leaveButton.setBounds(690, 710, 90, 50);
		add(leaveButton);
		
		inputButton.addActionListener(this);
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inputButton) {
			
			JOptionPane.showMessageDialog(this, nameText.getText()+"강사가 입력되었습니다",
														"강사입력",JOptionPane.INFORMATION_MESSAGE	);
			try {
				inputFile();
				nameText.setText(null);
				tellText1.setText(null);
				tellText2.setText(null);
				careerText.setText(null);
				studentNumberText.setText(null);
				notesTextArea.setText(null);
			} catch (IOException e1) {}
		}
	}
	
	private void inputFile() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("TMP.txt", true));
		
			bw.write(nameText.getText()+",");
			bw.write(tellCombo.getSelectedItem().toString()+"-");
			bw.write(tellText1.getText()+"-");
			bw.write(tellText2.getText()+",");
			if(departmentMiddleButton.isSelected()) {
				bw.write(departmentMiddleButton.getText()+",");
			}else if(departmentHighButton.isSelected()) {
				bw.write(departmentHighButton.getText()+",");
			}
			bw.write(careerText.getText()+",");
			bw.write(studentNumberText.getText()+",");
			
			if(genderManButton.isSelected()) {
				bw.write(genderManButton.getText()+",");
			}else if(genderWomanButton.isSelected()) {
				bw.write(genderWomanButton.getText()+",");
			}

			if(bonusNotButton.isSelected()) {
				bw.write(bonusNotButton.getText()+",");
			}else if(bonus1000Button.isSelected()) {
				bw.write(bonus1000Button.getText()+",");
			}else if(bonus2000Button.isSelected()) {
				bw.write(bonus2000Button.getText()+",");
			}

			if(fireNotButton.isSelected()) {
				bw.write(fireNotButton.getText()+",");
			}else if(fireButton.isSelected()) {
				bw.write(fireButton.getText()+",");
			}
			String[] arNotes = new String[10];
			arNotes = notesTextArea.getText().split("\n");
			String notes = "";
			for (int i = 0; i < arNotes.length; i++) {
				if(i == arNotes.length -1) {
					notes += arNotes[i];
				}else {
					notes += arNotes[i]+"/";
				}
			}
			bw.write(notes+",");
			int score = Integer.parseInt(careerText.getText())*3 
			+ Integer.parseInt(studentNumberText.getText())*7;
			bw.write(score +"\n");
			bw.close();
	}
	
}// class
