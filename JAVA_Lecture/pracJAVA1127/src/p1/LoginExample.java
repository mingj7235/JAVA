package p1;

import java.util.Scanner;

public class LoginExample {
	static String id = null;
	static String password = null;
	public static void main(String[] args) {
		input();
		try {
			login ();
		} catch (NotExistIDException e) {
			System.out.println(e.getMessage());
		} catch (WrongPassWordException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("5초후에 자동 로그아웃 합니다. ");
		}
	}
	private static void input () {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		id = sc.next();
		System.out.print("비밀번호 : ");
		password = sc.next();
	}
	
	private static void login () throws NotExistIDException, WrongPassWordException{
		if (!id.equals("admin")) {
			//예외발생
			throw new NotExistIDException("예외발생. 아이디가 틀렸습니다.");
		}
		if (!password.equals("admin1234")) {
			throw new WrongPassWordException("비밀번호가 틀렸습니다. 혹시 해커인가요?");
		}
	}
}
