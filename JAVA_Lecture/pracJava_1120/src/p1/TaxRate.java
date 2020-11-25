package p1;
//비지니스 로직
public class TaxRate {
	public void taxRate(Employee e) {
		if (e instanceof Manager) {// 자손을 먼저 걸어준다. 부모를 걸어주면 첫번째 if 문에 다 걸리기 때문이다. 
			Manager m = (Manager) e; 
			System.out.println("Manager 세금 계산하기 : "  + m.money * m.taxRate + "원");
		}else if (e instanceof Engineer) {
			Engineer e1 = (Engineer) e;
			System.out.println("Engineer 세금 계산하기 : " + e1.money * e1.taxRate + "원");
		}else if (e instanceof Parttime) {	
			Parttime p = (Parttime) e;
			System.out.println("Parttime 세금 계산하기 : "  + p.money * p.taxRate + "원");
		}else if (e instanceof Employee) {
			Employee e2 = (Employee) e;
			System.out.println("Employee 세금 계산하기 : " + e2.money * e2.taxRate + "원");
		}
	}
}
