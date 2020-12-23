package p06_net;

import java.net.InetAddress;

public class InetAddressEx {
	public static void main(String[] args) throws Exception{
		InetAddress local = InetAddress.getLocalHost();
		String ip = local.getHostAddress();
		System.out.println("≥ª IP¡÷º“ : " + ip);
		
		InetAddress [] iaArr = InetAddress.getAllByName("www.google.com");
		for( InetAddress iaA: iaArr) {
			System.out.println("google IP " + iaA.getHostAddress());
		}
		
		
		
	}
}
