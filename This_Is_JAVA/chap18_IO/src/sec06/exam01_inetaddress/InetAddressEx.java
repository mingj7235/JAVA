package sec06.exam01_inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx {
	public static void main(String[] args)  {
		try {
			InetAddress local = InetAddress.getLocalHost(); 
			System.out.println(local);
			System.out.println("내 컴퓨터 IP주소 : " + local.getHostAddress());//로컬 ip얻기
			
			//도메인으로 ip얻기
			InetAddress [] iaArr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote : iaArr) {
				System.out.println("www.naver.com IP주소 : " + remote.getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
