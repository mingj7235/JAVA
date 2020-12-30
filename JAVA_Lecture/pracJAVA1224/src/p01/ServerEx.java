package p01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5003));
			while (true) {
				System.out.println("���� ��ٸ�");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("���� ������" + isa.getHostName());
				
				byte[] bytes = null;
				String message = null;
				
				InputStream is =socket.getInputStream();
				bytes = new byte[100];
				int readByteCnt =is.read(bytes);
				
				message = new String (bytes, 0, readByteCnt, "UTF-8");
				
				System.out.println("[������ �ޱ� ����]" + message);
				
				OutputStream os = socket.getOutputStream();
				message = "Hello Client";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[������ ���� ����]");
				
				is.close();
				os.close();
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}