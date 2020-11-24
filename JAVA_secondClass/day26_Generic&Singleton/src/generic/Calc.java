package generic;

public class Calc implements GInterface<Double, Integer>{

	@Override
	public Double add(Double data1, Double data2) {
		return data1 + data2;
	}

	@Override
	public Double sub(Double data1, Integer data2) {
		return data1 - data2;
	}

	@Override
	public Integer mul(Integer data1, Integer data2) {
		return data1 * data2;
	}
	
	
	public static void main(String[] args) {
		Calc c = new Calc();
		System.out.printf("%.2f\n", c.add(5.9, 12.33));
		System.out.printf("%.2f\n", c.sub(5.9, 12));
		System.out.printf("%.d\n", c.mul(5, 12));
		
	}

}
