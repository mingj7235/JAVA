package sec07.exam01_serversocket_socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {
	public static void main(String[] args) {
		//서버
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			while (true) {
				//서버는 항상 클라이언트 요청을 기다려야하므로 무한루프
				System.out.println("[연결 기다림]");
				Socket socket =serverSocket.accept(); //클라이언트의 서버 연결요청을 수락하는 accept() 메소드.
											//연결요청이 들어오기 전에는 블로킹되어있음
											//Socket 타입을 리턴
				
				InetSocketAddress  isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[연결 수락함]" + isa.getHostName()); //클라이언트 ip주소를 얻을 수 있음
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
