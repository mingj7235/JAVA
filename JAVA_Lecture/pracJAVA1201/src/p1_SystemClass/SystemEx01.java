package p1_SystemClass;

import java.io.InputStream;
import java.io.PrintStream;

public class SystemEx01 {
	public static void main(String[] args) {
		//필드 기본적인 항목들임
		InputStream is =System.in; //콘솔 입력 키보드 입력
		PrintStream ps = System.err; // 콘솔 에러 모니터 에러
		PrintStream os = System.out; // 콘솔 출력 모니터 출력
		
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		System.out.println(osName);
		System.out.println(userName);
		long ct = System.currentTimeMillis();
		long nt = System.nanoTime();
		System.gc();
		System.exit(0);
		
	}
}
