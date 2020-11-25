package p8_CellphoneFareCalProgram;

public class AGrade extends WirelessClass {
	private String [] customer;
	private String [] gradeCode;
	private int [] unitPrice;
	private int [] basePrice;
	private int [] useTime;

	public String[] getCustomer() {
		return customer;
	}
	public void setCustomer(String[] customer) {
		this.customer = customer;
	}

	public String[] getGradeCode() {
		return gradeCode;
	}
	public void setGradeCode(String[] gradeCode) {
		this.gradeCode = gradeCode;
	}

	public int[] getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int[] unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int[] getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(int[] basePrice) {
		this.basePrice = basePrice;
	}

	public int[] getUseTime() {
		return useTime;
	}
	public void setUseTime(int[] useTime) {
		this.useTime = useTime;
	}

	void aInput (String customer, String grade, int useTime) {
//		setCustomer(customer);
//		setGradeCode(grade);
//		setUseTime(useTime);
	}
}
