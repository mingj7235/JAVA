package p02_chatting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChattingClient extends Thread implements ActionListener{
	
	Frame frame;
	TextArea ta;
	TextField tf;
	TextField tf2;
	Dialog dialog;
	Label label;
	Socket s1;
	DataOutputStream dos;
	DataInputStream dis;
	boolean stop;
	String host;
	
	public ChattingClient() {
		launchFrame();
	}
	
	private void launchFrame() {
		frame = new Frame ("일대일 채팅 클라이언트 부분");
		ta = new TextArea();
		tf = new TextField();
		frame.setBackground(Color.magenta);
		ta.setEditable(false);
		frame.add(ta, BorderLayout.CENTER);
		frame.add(tf, BorderLayout.SOUTH);
		tf.addActionListener(this);
		frame.setSize(500, 300);
		frame.setVisible(true);
		tf.requestFocus();
		
		dialog = new Dialog(frame, "서버IP", true);
		label = new Label("접속할 서버 IP 주소를 입력하세요");
		tf2 = new TextField(15);
		dialog.add(label, BorderLayout.NORTH);
		dialog.add(tf2, BorderLayout.CENTER);
		tf2.addActionListener(this);
		dialog.pack();
		dialog.show();
		
		service(host);
		tf2.requestFocus();
	}
	
	private void service (String host2) {
		try {
			s1 = new Socket(host, 5432);
			dis = new DataInputStream(s1.getInputStream());
			dos = new DataOutputStream(s1.getOutputStream());
			ta.append("접속완료..\n");
			this.start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(tf==e.getSource()) {
				String msg = tf.getText();
				ta.append(msg + "\n");
				if (msg.equals("exit")) {
					ta.append("bye");
					stop = true;
					dos.close();
					s1.close();
					System.exit(0);
				}else {
					dos.writeUTF("서버 : " + msg);
					tf.setText("");
				}
			}else {
				host = tf2.getText().trim();
				if(host.equals("")) host = "localhost";
				dialog.dispose();
			}
		}catch (Exception e1) {
			
		}
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Thread Start...\n");
			while (!stop) {
				ta.append(dis.readUTF() + "\n");
				
			}
			dis.close();s1.close();
		}catch (Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		new ChattingClient();
	}
	
}
