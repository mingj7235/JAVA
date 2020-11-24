package cgv;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Random;

public class CGV {
	public static void main(String[] args) {
		//상수
		final String title = "▒▒▒ CGV ▒▒▒";
		String msg = "1.예매하기\n2.구매하기\n3.포인트 조회\n4.쿠폰등록\n5.거래내역\n6.나가기";
		String film_msg = "1.겨울왕국(09:00)\n2.겨울왕국2(12:00)\n3.[청소년 관람 불가]타짜(23:00)\n4.돌아가기";
		String food_msg = "1.팝콘(￦7000)\n2.콜라(￦4000)\n3.[청소년 관람 불가]맥주카스(￦5000)\n4.돌아가기";
		String pay_msg = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String payList = "";
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		//100000~999999
		//0 ~ 899999 + 100000 
		int coupon = r.nextInt(900000) + 100000;
		int p_price = 7000;
		int c_price = 4000;
		int b_price = 5000;
		String err_msg = "다시 시도해주세요";
		int point = 0;
		int choice = 0;
		int money = 1_000_000;
		int t_price = 10000;
		String time = null;
		String name = null;
		int age = 0;
		int price = 0;
		int myCoupon = 0;
		
		//Flag
		//해당 영역에서 모든 로직이 구현되기 힘들 때에는 표시만 하고 나와서 로직을 완성시키도록 도와준다.
		//해당 영역에 들어왔는지 안들어왔는지를 Flag에 담겨있는 값으로 판단할 수 있다.
		boolean isPoint = false;
		boolean isPopcorn = false;
		boolean couponCheck = false;
		
		while(true) {
			//개발자가 확인하기 위해서 발급된 쿠폰번호를 출력하고, 출시 전 출력을 막아준다.
			System.out.println("쿠폰번호 : " + coupon);
			//포인트 전액 결제인지를 판단하기 위해 매번 false로 초기화 해준다.
			isPoint = false;
			//팝콘을 선택했는지를 판단하기 위해서는 매번 false로 초기화 해야한다.
			isPopcorn = false;
			System.out.println(title);
			System.out.println(msg);
			choice = sc.nextInt();
			//나가기
			if(choice == 6) { break;}
			switch(choice) {
			//예매
			case 1:
				System.out.println(film_msg);
				//변수의 재사용
				//1. 메모리 효율 증가
				//2. 가독성이 좋지 않다.
				choice = sc.nextInt();
				switch(choice) {
				//겨울왕국(9시)
				case 1:
					//하단에서 일괄처리를 하기 때문에 사용자가 선택한 영화가 어떤 영화인지를
					//name에 담고 내려가서 출력해준다.
					name = "겨울왕국(9시) 예매";
					break;
				//겨울왕국2(12시)
				case 2:
					name = "겨울왕국2(12시) 예매";
					break;
				//타짜(23시)
				case 3:
					System.out.print("나이 : ");
					age = sc.nextInt();
					//미성년자인지 아닌지 검사
					if(age <= 19) {
						//미성년자일 경우
						//미성년자로 거래 실패했을 때의 시간
						time = sdf.format(System.currentTimeMillis());
						//거래 내역에 표시하기 위해 payList에 누적연결을 해준다.
						payList += "타짜(23시) 예매 실패 / 미성년자 관람 불가 /"+ time + "\n";
						System.out.println("미성년자 관람 불가 영화입니다.");
						//밑으로 내려가지 않고 다음 반복(홈화면)
						continue;
					}
					name = "타짜(23:00) 예매";
					break;
				//돌아가기
				case 4:
					continue;
				//그 외
				default:
					System.out.println(err_msg);
					continue;
				}
				//정상적으로 영화를 선택했을 때 오는 영역
				//price에 영화표 가격을 담아준다.
				price = t_price;
				break;
			//구매
			case 2:
				System.out.println(food_msg);
				choice = sc.nextInt();
				switch(choice) {
				//팝콘
				case 1:
					name = "팝콘 구매";
					//상품마다 가격이 다르기 때문에
					//사용자가 선택한 상품의 가격을 각각 price에 담아준다.
					price = p_price;
					isPopcorn = true;
					break;
				//콜라
				case 2:
					name = "콜라 구매";
					price = c_price;
					break;
				//맥주
				case 3:
					System.out.print("나이 : ");
					age = sc.nextInt();
					if(age <= 19) {
						time = sdf.format(System.currentTimeMillis());
						payList += "맥주 구매 실패 / 미성년자 구매 불가 /"+ time + "\n";;
						System.out.println("미성년자 구매 불가 상품입니다.");
						continue;
					}
					name = "맥주 구매";
					price = b_price;
					break;
				//돌아가기
				case 4:
					continue;
				//그 외
				default:
					System.out.println(err_msg);
					continue;
				}
				break;
			//포인트
			case 3:
				System.out.println("잔여 포인트 : " + point + "점");
				continue;
			//쿠폰
			case 4:
				//이미 쿠폰을 소지한 사용자라면 couponCheck에 true가 담겨있다.
				if(!couponCheck) {
					//쿠폰을 소지하지 않았을 때 들어옴
					System.out.print("쿠폰번호 6자리 : ");
					myCoupon = sc.nextInt();
					if(coupon == myCoupon) {
						//사용자가 입력한 쿠폰번호와 회사의 쿠폰번호를 비교하여
						//일치했을 때 couponCheck를 true로 변경해준다.
						couponCheck = true;
					}else {
						//잘못된 쿠폰번호를 입력했을 때
						System.out.println("잘못된 쿠폰번호입니다.");
					}
				}else {
					//쿠폰을 이미 소지한 사용자일 때
					System.out.println("이미 등록한 사용자입니다.");
				}
				continue;
			//거래내역
			case 5:
				//만약 거래내역이 없다면 삼항연산자로 판단하여 적절한 메세지를 출력해준다.
				System.out.println(payList.equals("") ? "거래 내역이 없습니다." : payList);
				continue;
			//그 외
			default:
				System.out.println(err_msg);
				continue;
			}
			//&&연산자는 앞의 조건식이 false이면 뒤의 조건식을 검사하지 않는다.
			//쿠폰을 소지하고 있으며, 팝콘을 선택했다면 들어간다.
			if(couponCheck && isPopcorn) {
				//팝콘 무료 쿠폰이므로 팝콘 가격을 0으로 만들어준다.
				price = 0;
				System.out.println("팝콘 무료쿠폰이 사용되었습니다.");
				//쿠폰을 사용했기 때문에 더 이상 쿠폰 소지자가 아니다.
				//따라서 couponCheck를 false로 되돌려준다.
				couponCheck = false;
				
				//이전 쿠폰번호를 temp에 담아준다.
				int temp = coupon;
				//중복이 없을 때까지 무한 반복
				while(true) {
					//새로운 쿠폰번호 발급
					coupon = r.nextInt(900000) + 100000;
					//이전 쿠폰번호와 비교 후 중복이 아니면 탈출
					//중복이면 무한반복
					if(temp != coupon) {break;}
				}
				continue;
			}
			
			//일괄처리
			//포인트와 현금을 모두 합해서 상품을 구매할 수 있는 지 검사
			if(money + point - price < 0) {
				//잔액부족
				time = sdf.format(System.currentTimeMillis());
				payList += name + "  실패 / 잔액부족 /"+ time + "\n";
				System.out.println(name + "  실패 / 잔액부족");
			}else {
				//정상결제
				//포인트가 1점이라도 있다면 자동 사용
				if(point > 0) {
					if(point - price < 0) {
						//포인트로 상품을 구매할 수 없을 때
						//포인트 + 현금 결제
						money -= price - point;
						point = 0;
						pay_msg = "포인트 + 현금";
					}else {
						//포인트 전액 결제
						point -= price;
						pay_msg = "포인트";
						isPoint = true;
					}
				}else {
					//현금 전액 결제
					money -= price;
					point += price * 0.5;
					pay_msg = "현금";
				}
				time = sdf.format(System.currentTimeMillis());
				payList += name + "  완료 / " + pay_msg + " 결제/"+ time + "\n";
				System.out.println(name + "  완료 / " + pay_msg + " 결제");
				
				if(!isPoint) {
					//isPoint가 true라면 전액 포인트 결제이기 때문에
					//현재 잔액을 출력할 필요가 없다.
					//따라서 isPoint가 false일 때에만 현재 잔액을 출력한다.
					System.out.println("현재 잔액 : " + money + "원");
				}
			}
			
		}
	}
}







