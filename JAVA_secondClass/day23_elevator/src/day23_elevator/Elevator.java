package day23_elevator;

import java.util.Scanner;

public class Elevator extends Lift{
	
	final int maxFloor = 10;
	final int minFloor = -3;
	
	@Override
	public void up() {
		floor++;
	}

	@Override
	public void down() {
		floor--;
	}

	@Override
	public void start(int choice) {
		if(choice < floor) {
			for (int i = 0; i <= floor-choice+i; i++) {
				//i를 더해주는 이유는 floor도 변하기때문에 i를 더해줘서 상쇄를 시킨다. 
				//floor는 반복문이 돌며 down을 쓸수록 1씩 감소하고, i는 반복을 할수록 1씩 증가하므로 상쇄가된다. 
				if (floor!=0) {
					//0층은 없으니까!
					System.out.println(floor +"층");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				down();
			}
			stop();
		}else if (choice != floor) {
			//if 문에 대한 이해. 어차피 choice가 floor 보다 작으면 위에서 걸리므로 같지 않을 때를 쓰는게 더 효율적이다. 
			//위의 if문에서 하나 걸러져서 들어온거다. 
			for (int i = 0; i < choice - floor + i ; i++) {
				if (floor!=0) {
					System.out.println(floor + "층");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
				up();
			}
			stop();
		}else {
			System.out.println("같은 층 선택 불가");
		}
	}
	@Override
	public void stop() {
		System.out.println("●도착●");
	}

	@Override
	public void go() {
		int choice = 0;
		String msg = "";
		while (true) {
			//층수를 잘 입력할때까지 반복하겠다라는 의미. 즉 오류를 잡는것
			msg = "층수를 입력하세요 (현재층 : " + floor +"층)";
			System.out.println(msg);
			choice = new Scanner(System.in).nextInt();
			if(choice > maxFloor || choice < minFloor) {
				System.out.println("B3층 부터 10층까지만 가능합니다.");
			}else {
				break;
				//choice에 입력이 잘 담겼으면 탈출해서 start(choice)로 간다. 
			}
		}
		start(choice);
		
	}

}
