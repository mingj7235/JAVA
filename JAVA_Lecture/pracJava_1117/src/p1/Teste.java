package p1;

import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans = "";
		System.out.println("문자입력 : ");
		String str = sc.next();
		char [] word = str.toCharArray();
		int cnt = 1;
		for (int i = 0; i < str.length()-1; i++) {
			if(word[i]!=word[i+1]) {
				ans+=word[i]+(cnt+"");
				cnt = 1;
			} else if (i == str.length()-1){
				ans+=word[i]+(cnt+"");
			}else {
				
				cnt++;
			}
		}
		System.out.println(ans);
	
	}
}
