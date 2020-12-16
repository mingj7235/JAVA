package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
				
				//데이터를 받기
				byte [] bytes = null;
				String message = null;
				
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes); //데이터를 읽는것. 리턴은 데이터의 읽은 바이트 수.
																			//데이터는 bytes에 저장
				
				message = new String(bytes, 0, readByteCount, "UTF-8");
				
				System.out.println("[데이터 받기 성공]\n받은 메세지 : " + message);
				
				OutputStream os = socket.getOutputStream();
				message = "Hello Client";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[데이터 전송 성공]");
				
				is.close();
				os.close();
				socket.close(); //연결을 끊겠다는것임
				
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
