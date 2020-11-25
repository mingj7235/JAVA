package p1;

public class EmployeeMain {
	public static void main(String[] args) {
		Employee emp = new Employee();
		Manager man = new Manager();
		Engineer eng = new Engineer();
		Parttime pt = new Parttime();
		
		
		TaxRate taxRate = new TaxRate();
		taxRate.taxRate(emp);
		taxRate.taxRate(man);
		taxRate.taxRate(eng);
		taxRate.taxRate(pt);
	}
}
