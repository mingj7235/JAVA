package sec08.exam01_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiveEx {
	public static void main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket (5001); //리시버는 포트번호를 줘서 바인딩 시켜줘야한다.
		
		Thread thread = new Thread () {
			public void run() {
				System.out.println("[수신 시작]");
				try {
					while (true) {
						DatagramPacket packet = new DatagramPacket(
								new byte [100], 100);
						ds.receive(packet);
						
						String data = new String (packet.getData(), 0, packet.getLength(), "UTF-8");
						System.out.println("[받은 내용 : " + packet.getSocketAddress() + "]" + data);
					}
				}catch (Exception e) {
					System.out.println("[수신 종료]");
				}
			}
		};
		
		thread.start();
		
		Thread.sleep(10000); //10초 이후에 클로즈시키는 것임
		ds.close();
	}
}
