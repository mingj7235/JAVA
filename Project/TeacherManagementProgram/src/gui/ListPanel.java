package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import teacher.Teacher;

public class ListPanel extends JPanel {
	
	private Image background = Toolkit.getDefaultToolkit().getImage("./src/img/목록.jpg");
	private ArrayList<Teacher> arListHigh = new ArrayList<>();
	private ArrayList<Teacher> arListMiddle = new ArrayList<>();
	private ArrayList<Integer> arlistRankHigh = new ArrayList<>();
	private ArrayList<Integer> arlistRankMiddle = new ArrayList<>();
	JButton leaveButton = new JButton("나가기");
	
	public ListPanel() {
		//setSize(800,800);
		setLayout(null);
		
		try {
			file();
		} catch (IOException e) {}
		
		JTabbedPane tab = new JTabbedPane();
		JPanel highClass = new JPanel();
		//highClass.setSize(500,500);
		JPanel middleClass = new JPanel();
		JLabel list = new JLabel("<<학원강사 목록>>",JLabel.LEFT);
		list.setFont(new Font("고딕체",Font.BOLD,20));
		
		String[] field = {"순위","이름","경력","학생수","강사 점수","보너스","순위보너스","월급","퇴사여부"}; 
		DefaultTableModel tableModelHigh = new DefaultTableModel(field,0);
		DefaultTableModel tableModelMiddle = new DefaultTableModel(field,0);
		JTable tableHigh = new JTable(tableModelHigh);
		//tableHigh.setSize(500,500);
		JTable tableMiddle = new JTable(tableModelMiddle);
		JScrollPane scrollHigh = new JScrollPane(tableHigh); // scroll 처럼 모든 내용을 보여줄수있는 컨테이너에 담겨야 헤더가 나온다..
		scrollHigh.setPreferredSize(new Dimension(700,300));
		scrollHigh.setOpaque(false);
		JScrollPane scrollMiddle = new JScrollPane(tableMiddle); 
		scrollMiddle.setPreferredSize(new Dimension(700,300));
		scrollMiddle.setOpaque(false);
		
		for (int i = 0; i < arListHigh.size(); i++) {
			String name = arListHigh.get(i).getName();
			int career = arListHigh.get(i).getCareer();
			int studentNumber = arListHigh.get(i).getStudentNumber();
			int score = arListHigh.get(i).getScore();
			int bonus = arListHigh.get(i).getBonus();
			String fire = arListHigh.get(i).getFire();
			
			int rankbonus = 0;
			if(i == 0) {
				rankbonus = 500;
			}else if(i == 1) {
				rankbonus = 300;
			}else if(i == 2) {
				rankbonus = 100;
			}else {
				rankbonus = 0;
			}
			int salary = score + bonus + rankbonus;
			
			Object[] data = {arlistRankHigh.get(i),name,career+"개월",studentNumber+"명",
														score+"점",bonus+"만원",rankbonus+"만원",salary+"만원",fire};
			
			tableModelHigh.addRow(data);
		}
		for (int i = 0; i < arListMiddle.size(); i++) {
			String name = arListMiddle.get(i).getName();
			int career = arListMiddle.get(i).getCareer();
			int studentNumber = arListMiddle.get(i).getStudentNumber();
			int score = arListMiddle.get(i).getScore();
			int bonus = arListMiddle.get(i).getBonus();
			String fire = arListMiddle.get(i).getFire();
			
			int rankbonus = 0;
			if(i == 0) {
				rankbonus = 500;
			}else if(i == 1) {
				rankbonus = 300;
			}else if(i == 2) {
				rankbonus = 100;
			}else {
				rankbonus = 0;
			}
			
			int salary = score + bonus + rankbonus;
			
			Object[] data = {arlistRankMiddle.get(i),name,career+"개월",studentNumber+"명",
					score+"점",bonus+"만원",rankbonus+"만원",salary+"만원",fire};
			
			tableModelMiddle.addRow(data);
		}
		
		highClass.add(scrollHigh);
		middleClass.add(scrollMiddle);
		tab.addTab("고등부", highClass);
		tab.addTab("중등부", middleClass);
		tab.setBounds(20, 80, 750, 400);
		tab.setOpaque(false);
		add(tab);
		list.setBounds(20, 30, 200, 30);
		add(list);
		leaveButton.setBounds(670, 710, 100, 50);
		add(leaveButton);
	}
	
	private void file() throws IOException{

			String contents = new String(Files.readAllBytes(Paths.get("TMP.txt")));
			String[] arContents = new String[100];
			arContents = contents.split("\n");
			String highContents = "";
			String middleContents = "";
			
				for (int i = 0; i < arContents.length; i++) {
					if(arContents[i].contains("고등부")) {
						highContents += arContents[i]+"\n";
					}else if(arContents[i].contains("중등부")) {
						middleContents += arContents[i]+"\n";
					}
				}

				String[] arHigh = new String[100];
				String[] arMiddle = new String[100];
				arHigh = highContents.split("\n");
				arMiddle = middleContents.split("\n");
				
				try {
					for (int i = 0; i < arHigh.length; i++) {
						String[] arHighContens = arHigh[i].split(",");
						arListHigh.add(new Teacher(arHighContens[0], 
								Integer.parseInt(arHighContens[3]),
								Integer.parseInt(arHighContens[4]), 
								Integer.parseInt(arHighContens[9]),
								Integer.parseInt(arHighContens[6]),
								arHighContens[7]));
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (ArrayIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
				
				try {
					for (int i = 0; i < arMiddle.length; i++) {
						String[] arMiddleContents = arMiddle[i].split(",");
						arListMiddle.add(new Teacher(arMiddleContents[0], 
								Integer.parseInt(arMiddleContents[3]), 
								Integer.parseInt(arMiddleContents[4]), 
								Integer.parseInt(arMiddleContents[9]),
								Integer.parseInt(arMiddleContents[6]),
								arMiddleContents[7]));
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (ArrayIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
				
				int cntHigh = 1;
				for (int i = 0; i < arListHigh.size(); i++) {
					cntHigh = 1;
					for (int j = 0; j < arListHigh.size(); j++) {
						if(arListHigh.get(i).compareTo(arListHigh.get(j)) == -1) {
							cntHigh++;
						}
					}
					arlistRankHigh.add(cntHigh);
				}
				int cntMiddle = 1;
				for (int i = 0; i < arListMiddle.size(); i++) {
					cntMiddle = 1;
					for (int j = 0; j < arListMiddle.size(); j++) {
						if(arListMiddle.get(i).compareTo(arListMiddle.get(j)) == -1){
							cntMiddle++;
						}
					}
					arlistRankMiddle.add(cntMiddle);
				}
				
				
				for (int i = 0; i < arListHigh.size(); i++) {
					for (int j = 0; j < arListHigh.size(); j++) {
						if(arListHigh.get(i).compareTo(arListHigh.get(j)) == 1) {
							Teacher teacher = arListHigh.get(i);
							arListHigh.set(i, arListHigh.get(j));
							arListHigh.set(j, teacher);
						}
					}
				}
				for (int i = 0; i < arListMiddle.size(); i++) {
					for (int j = 0; j < arListMiddle.size(); j++) {
						if(arListMiddle.get(i).compareTo(arListMiddle.get(j)) == 1) {
							Teacher teacher = arListMiddle.get(i);
							arListMiddle.set(i, arListMiddle.get(j));
							arListMiddle.set(j, teacher);
						}
					}
				}
				
				
				for (int i = 0; i < arlistRankHigh.size(); i++) {
					for (int j = 0; j < arlistRankHigh.size(); j++) {
						if(arlistRankHigh.get(i) < arlistRankHigh.get(j)) {
							int rank = arlistRankHigh.get(i);
							arlistRankHigh.set(i, arlistRankHigh.get(j));
							arlistRankHigh.set(j, rank);
						}
					}
				}
				for (int i = 0; i < arlistRankMiddle.size(); i++) {
					for (int j = 0; j < arlistRankMiddle.size(); j++) {
						if(arlistRankMiddle.get(i) < arlistRankMiddle.get(j)) {
							int rank = arlistRankMiddle.get(i);
							arlistRankMiddle.set(i, arlistRankMiddle.get(j));
							arlistRankMiddle.set(j, rank);
						}
					}
				}
			
		
		
	}// file
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	}
}
