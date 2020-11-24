package day07_new;

import java.util.Random;
import java.util.Scanner;

public class ArTask_new {
	public static void main(String[] args) {
		//[초급]
		//100~1까지 배열에 담고 출력하기
//		int [] arData = new int [100];
//		
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = 100-i;
//		}
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
		
		
		//1~100까지 중 짝수만 배열에 담고 출력하기
//		int [] arData = new int [50];
//		for (int i = 0; i < arData.length; i++) {
//			arData[i]	= (i+1)*2;
//		}
//		for (int i = 0; i < arData.length; i++) {
//			System.out.print(arData[i] + " ");
//		}
		
		//1~10까지 배열에 담고 총 합 구하기
//		int [] arData = new int [10];
//		int result = 0;
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = i+1;
//			result += arData[i];
//		}
//		System.out.println(result);
		
		//1~n 까지 배열에 담고 총 합 구하기
		
//		Scanner sc = new Scanner (System.in);
//		int [] arData =  null;
//		//몇칸인지 모르니까 주소값을 모르니 null을 초기값으로
//		int total = 0;
//		System.out.println("1~n까지의 합 \nn값 : ");
//		arData = new int [sc.nextInt()];
//		// 이게 통째로 첫번째 시작 주소값이다. 오이거 짱중요. 신기하다. 이게 핵심.
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = i + 1;
//			total += arData[i];
//		}
//		System.out.println(total);
		
		//A~F 까지 배열에 담고 출력하기 (아스키)
		//A : 65
		//B : 66 ...
//		char [] arData = new char[6];
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = (char)(65 + i) ;
//		}
//		for (int i = 0; i < arData.length; i++) {
//			System.out.print(arData[i]);
//		}
		
		//			아스키	i
		//A	:	65	0
		//B	:	66	1
		//C	:	67	2
		//D	:	68	3
		//E	:	69	4
		//temp를 쓰는이유. for문안에서 i를 증가시키면, 오류가된다. 
		//그 자체로 반복문의 변수도 i 를 사용하기에, 같이 사용되며, arData[i]도 빠그러진다.
//		//그래서 임시로 temp라는 변수를 선언해주고, temp를 증가시켜준것이다.
		
		//A~F 까지 중 C제외하고 배열에 담은 후 출력하기
//		char []	arData = new char[5];
//		int temp = 0;
//		for (int i = 0; i < arData.length; i++) {
//			temp = i;
//			if(i > 1) {
//				temp++;
//			}
//			arData [i]	 = (char)(temp+65);
//		}
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
		
		//A~F 까지 중 C제외하고 배열에 담은 후 출력하기 (2번째 방법)
//		for (int i = 0; i < arData.length; i++) {
//			arData[i] = (char)(i > 1? 66+ i : 65 + i);
//		}
//		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
		
		//[중급]
		//aBcDeF....Z 배열에 담고 출력하기
//		char [] arData = new char [26];
//		
//		for (int i = 0; i < arData.length; i++) {
//			arData [i] = (char)(i % 2 == 0 ? 97+i : 65 + i);
//		}
//		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(arData[i]);
//		}
		
		//5개의 정수를 입력받고 최대값과 최소값 출력하기
//		Scanner sc = new Scanner(System.in);
//		int [] arData = new int [5];
//		int max = 0;
//		int min = 0;
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println(i+ 1+ "번째 정수 : ");
//			arData[i] = sc.nextInt()	;
//		}
//		max = arData[0];
//		min = arData[0];
//		for (int i = 1; i < arData.length; i++) {
//			//3 5 1 6 2
//			if (max < arData[i]) {
//				max = arData[i];
//				}
//			if (min > arData[i]) {
//				min = arData[i];
//				}
//			//돌려가면서 0번째에 담게되고, 이것을 계속 비교하게됨
//		}
//		System.out.println("최대값 : " +max + "최소값 : " + min);
		
		//사용자가 입력한 값 만큼 정수를 입력받고 배열에 넣은 후 3의 배수만 출력하기
//		Scanner sc = new Scanner(System.in);
//		int [] arData = null;
//		
//		System.out.println("입력할 정수의 갯수 : ");
//		arData = new int[sc.nextInt()];
//		//사용자가 입력한 숫자만큼 칸수 할당.
//		
//		for (int i = 0; i < arData.length; i++) {
//			System.out.println( i + 1 + "번째 정수 : ");
//			arData[i] = sc.nextInt();
//		}
//		
//		for (int i = 0; i < arData.length; i++) {
//			if (arData[i] % 3 ==0) {
//				System.out.println(arData[i]);
//			}
//		}

			//문자열은 문자 배열이다. 라는 것을 알아야한다. String이라는 타입이 그래서 나온 것이다. 
			//문자열이 문자 배열이지만, 클래스이라는것을 알아야한다. 
			//그렇기때문에 메서드를 사용하는것이다. 메서드로 접근해야한다. 
		//문자열 값을 null로 초기화할때에는 아래에서 대입연산자를 사용한다는 의미이다.
		//문자열 값을 ""로 초기화할때에는 아래에서 누적연결을 사용하겠다는 의미이다. 
		//null 이라는 값도 값이기 때문에 연결을 하면 null이 연결되서 사용되기 때문에
		//사용목적에 맞게 초기화해주어야한다.
		//문자열을 입력받고 소문자만 대문자로 바꾸기
//		Scanner sc = new Scanner(System.in);
//		String str = null;
//		String result = "";
//		System.out.println("문자열 : ");
//		
//		str = sc.next();
//		for (int i = 0; i < str.length(); i++) {
//			char c = str.charAt(i);
//			if(c >= 97 && c <= 122) {
//				result += (char)(c-32);
//			}else {
//				result += c;
//			}
//		}
//		System.out.println(result);
		//소문자
		// 변수에 담기. str.charAt(); 이거 자체가 값이다. 
		//charAt(i) 은 배열에서 각각의 주소에 들어가있는 값에 접근하는 것과 똑같이 문자열에서 나오도록 하는 메서드다.
		
//		str.toUpperCase());
//		str.toLowerCase());
		//요게 문자열에있는 소문자를 대문자로, 대문자를 소문자로 다 바꿔준다. 우리가 이 과정을 만든것. 
		
		//[고급]
		//확률의 단위가 10이라면, 10칸 배열을 선언한다.
		// 모두 0으로 초기화한 후 원하는 확률 / 10 만큼 1을 대입해준다.
		//랜덤한 인덱스 번호로 접근하여 값을 가지고 왓을 때
		//0이 나오면 100	-	원하는 확률, 
		//1이 나오면 원하는 확률로 나오게 된다. 

		
		//new 를 선언해서 heap메모리에 할당 햇을 때, 10칸에는 쓰레기값이 들어가있다. (무슨값인지모르니까)
		//그래서 자동 초기화가 되어있다. 그래서 다 자동적으로 0이 들어가있다. 
		//new int[10]; 하면, 0이 다들어있다. 
		//new double[10]; 하면 10개의 0.0이 들어있다. 오오.
		
		
		//90%확률로 꽝을 출력하고 10%확률로 당첨을 출력하기
//		int [] arData = new int[10];
//		Random r = new Random();
//		int idx = r.nextInt(arData.length);
//		int rating = 1;
//		//rating 은 확률을 조정하는 것임. 
//		
//		for (int i = 0; i < rating; i++) {
//			arData[i] = 1; 
//		}
//		System.out.println(arData[idx] == 1? "당첨" : "꽝");
//				idx를 여기에 사용하여서, 이걸 랜덤값으로 넣는다. 
		
		//정수를 한글로 변경하기 1024 -> 일공이사
//	[1]	
//		String hangle = "공일이삼사오육칠팔구";
//		String result = "";
//		Scanner sc = new Scanner(System.in);
//		
//		int num = 0;
//		
//		System.out.print("정수 : ");
//		num = sc.nextInt();
//		
//		while (num != 0) {
//			result = hangle.charAt(num % 10) + result;
//			// 누적연결이 아니라 뒤로 붙이는 방법. 오....
//			num /= 10;
//		}
//		System.out.println(result);
		
//	[2]	
		//정수를 한글로 변경하기 1024 -> 일공이사
//		String hangle = "공일이삼사오육칠팔구";
//		String data = null;
//		String result = "";
//		Scanner sc = new Scanner (System.in);
//		
//		System.out.println("정수 : ");
//		data = sc.nextInt() + "";
//		for (int i = 0; i < data.length(); i++) {
//			result += hangle.charAt(data.charAt(i) - 48);
//		}
//		System.out.println(result);
		//-48한 이유는 아스키 코드에서  문자1은 정수로 49이기 때문이다. 그렇기에
		//정수1로 바꾸기 위해서 -48로 해주고, 이것을 hangle.charAt() 에 인덱스(정수)에 넣어주는것이다. 
		// 이거 한번 고민해보자. 다시 ... 
		
		//한글을 정수로 변경하기 일공이사 -> 1024
		Scanner sc = new Scanner(System.in);
		String hangle_org = "공일이삼사오육칠팔구";
		String hangle = null;
		String result = "";
		int total = 0;
		
		System.out.println("한글 : ");
		hangle = sc.next();
		for (int i = 0; i < hangle.length(); i++) {
			int index = hangle_org.indexOf(hangle.charAt(i));
			total += index;
//			System.out.println(index);
//			result += hangle_org.indexOf(hangle.charAt(i));
			//indexOf 는 검색해주는 메서드.... 
		}
		System.out.println(total);
		}
	}

