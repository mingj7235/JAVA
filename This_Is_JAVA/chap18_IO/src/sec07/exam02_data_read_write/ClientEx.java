package sec07.exam02_data_read_write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientEx {
	public static void main(String[] args) {
		//Ŭ���̾�Ʈ
		
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("[���� ��û]");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("[���� ����]");
			
			byte [] bytes = null;
			String message = null;
			
			OutputStream os = socket.getOutputStream(); //�ƿ�ǲ ��Ʈ�� ��� ! �������ϴϱ�
			message = "Hello Server! ";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[������ ���� ����]");
			
			InputStream is = socket.getInputStream();
			bytes = new byte [100];
			int readByteCount = is.read(bytes); 
			message = new String (bytes, 0, readByteCount, "UTF-8");
			System.out.println("[������ �ޱ� ����]\n���� ������ : " + message);
			
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