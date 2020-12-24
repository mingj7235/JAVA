package p01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientEx {
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("[연결 요청]");
			socket.connect(new InetSocketAddress("localhost", 5003));
			System.out.println("[연결 성공]");
			
			byte[] bytes = null;
			String message = null;
			
			OutputStream os = socket.getOutputStream();
			message = "Hello Server";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[데이터 보내기 성공]");
			
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByteCnt = is.read(bytes);
			message = new String (bytes, 0, readByteCnt, "UTF-8");
			System.out.println("데이터 받기 성공" + message);
			
			is.close(); os.close();
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!socket.isClosed()) {
			try {
				socket.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
