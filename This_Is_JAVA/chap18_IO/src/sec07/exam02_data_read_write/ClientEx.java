package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientEx {
	public static void main(String[] args) {
		//클라이언트
		
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("[연결 요청]");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("[연결 성공]");
			
			byte [] bytes = null;
			String message = null;
			
			OutputStream os = socket.getOutputStream(); //아웃풋 스트림 얻기 ! 보내야하니까
			message = "Hello Server! ";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[데이터 전송 성공]");
			
			InputStream is = socket.getInputStream();
			bytes = new byte [100];
			int readByteCount = is.read(bytes); 
			message = new String (bytes, 0, readByteCount, "UTF-8");
			System.out.println("[데이터 받기 성공]\n받은 데이터 : " + message);
			
			is.close();
			os.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
