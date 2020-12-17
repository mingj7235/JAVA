package sec08.exam01_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSendEx {
	public static void main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket();
		
		System.out.println("[발신시작]");
		
		for (int i = 0; i < 3; i++) {
			String data = "메세지" + (i+1);
			byte [] byteArr = data.getBytes("UTF-8");
			DatagramPacket packet = new DatagramPacket(
					byteArr, byteArr.length, new InetSocketAddress("localhost", 5001)
					);
			
			ds.send(packet);
			System.out.println("보낸 바이트 수:" +byteArr.length + " bytes");
		}
		System.out.println("[발신 종료]");
		ds.close();
		
	}
}
