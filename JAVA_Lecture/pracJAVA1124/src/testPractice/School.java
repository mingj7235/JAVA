package testPractice;

import java.util.Scanner;

public class School {
	Scanner sc = new Scanner(System.in);
	Students [][] studentbook = new Students [3][5]; 
	int choice = 0;
	int eleStd = 0, midStd = 0, highStd = 0;
	
	public void view () {
		System.out.println("�л��� grade�� Ȯ�����ּ���"
				+ "\n1. �ʵ��л�"
				+ "\n2. ���л�"
				+ "\n3. �����л�");
		choice = sc.nextInt();
		switch(choice) {
		case 1 : 
			input();
			output();
			break;
		case 2 : 
			input();
			output();
			break;
		case 3 : 
			input();
			output();
			break;
		default :
			break;
		}
	}
	//�Է�
	public void input () {
		Students std = new High();
		System.out.print("������ �Է����ּ��� : ");
		std.subject = sc.next();
		System.out.print("�߰����� ���� : ");
		std.midterm = sc.nextInt();
		System.out.print("�⸻���� ���� : ");
		std.finalterm = sc.nextInt();
		System.out.print("������ ���� :");
		std.exp = sc.nextInt();
		std.total();
		if (choice == 1) { //�ʵ�
			studentbook [choice-1][eleStd++] = std;
		}else { //�ߵ�
			Middle mid = (Middle) std;
			System.out.println("�⼮������ �Է����ּ���");
			mid.attend = sc.nextInt();
			System.out.println("��米�� �̸��� �Է����ּ��� ");
			mid.teacher = sc.next();
			System.out.println("���������� �Է����ּ���");
			mid.volunteer = sc.nextInt();
			if (choice ==2) {
				studentbook [choice-1][midStd++] = mid;
			}else { //����
				High high = (High) mid;
				high.avg();
				studentbook [choice-2][highStd++] = high;
			}
		}
	}
	//���
	public void output () {
		switch (choice) {
		case 1 : 
			System.out.println("�ʵ��л� �����Դϴ�.");
			for (int i = 0; i < eleStd; i++) {
				Elementary ele = (Elementary) studentbook[0][i];
				System.out.println("���� : " + ele.subject + "\n�߰����� : " + ele.midterm + " �⸻���� : " + ele.finalterm
						+ " ������ : " + ele.exp + "���� : "  + ele.total());
			}
			break;
		case 2 : 
			System.out.println("���л� �����Դϴ�.");
			for (int i = 0; i < midStd; i++) {
				Middle mid = (Middle) studentbook[1][i];
				System.out.println("���� : " + mid.subject + "��米�� : " + mid.teacher + "\n�߰����� : " + mid.midterm + " �⸻���� : " + mid.finalterm
						+ " ������ : " + mid.exp + " �⼮���� : " + mid.attend + " �������� : " + mid.volunteer + "\n���� : " + mid.total());
			}
			break;
		case 3 : 
			System.out.println("�����л� �����Դϴ�.");
			for (int i = 0; i < highStd; i++) {
				High high = (High) studentbook[2][i];
				System.out.println("���� : " + high.subject + "��米�� : " + high.teacher + "\n�߰����� : " + high.midterm + " �⸻���� : " + high.finalterm
						+ " ������ : " + high.exp + " �⼮���� : " + high.attend + " �������� : " + high.volunteer + "\n���� : " + high.total() + " ��� " + high.avg());
			}
			break;
		default :
			break;
		}
	}
	
}