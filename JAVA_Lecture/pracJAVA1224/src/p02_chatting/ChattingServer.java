package p02_chatting;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattingServer extends Thread implements ActionListener{
	//필드 선언
	Frame frame; //윈도우창 프레임지원 클래스
	TextArea tf; //문자 입력하는 영역 지원 클래스
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
		
	}
	
	private void service() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	} 
	
	public static void main(String[] args) {
		
	}

}
