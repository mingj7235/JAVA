package p02_chatting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattingServer extends Thread implements ActionListener{
	//필드 선언
	Frame frame; //윈도우창 프레임지원 클래스
	TextArea ta; //문자 입력하는 영역 지원 클래스
	TextField tf;
	ServerSocket s;
	Socket s1;
	DataOutputStream dos;
	DataInputStream dis;
	boolean stop;
	
	
	public ChattingServer() {
		launchFrame(); //화면구현
		service();//서버 연결 화면
	}
	
	private void launchFrame () {
		frame = new Frame("일대일 채팅");
		ta = new TextArea();
		tf = new TextField();
		frame.setBackground(Color.LIGHT_GRAY);
		ta.setEditable(false); //채팅된 화면에서 수정하는 것을 막음 (false)
		frame.add(ta, BorderLayout.CENTER);
		frame.add(tf, BorderLayout.SOUTH);
		tf.addActionListener(this);
		frame.setSize(500, 300);
		frame.setVisible(true);
		tf.requestFocus();
		
	}
	
	private void service() {
		try {
			ta.append("서비스 하기 위해서 준비중...\n");
			s = new ServerSocket(5432);
			ta.append("클라이언트 접속 대기중...\n");
			s1=s.accept();
			
			ta.append("클라이언트가 접속하였습니다.." + s1.getInetAddress()+"\n");
			dos = new DataOutputStream(s1.getOutputStream());
			dis = new DataInputStream(s1.getInputStream());
			this.start(); //스레드 호출
			dos.writeUTF("채팅 서버에 접속하신 것을 환영합니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		try {
			while (!stop) {
				ta.append(dis.readUTF() + "\n");
			}
			dis.close(); s1.close();
		}catch (EOFException e) {
			System.out.println("클라이언트로 부터 연결이 끊김");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		String msg= tf.getText();
		ta.append(msg+"\n");
		if(msg.equals("exit")) {
			ta.append("bye");
			stop =true;
				dos.close();
			s1.close();
			System.exit(0);
		}else {
			dos.writeUTF("서버 : " + msg);
			tf.setText("");
		}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	} 
	
	public static void main(String[] args) {
		new ChattingServer();
	}

}
