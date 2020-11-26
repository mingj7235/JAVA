package examJAVA1126;

public class Locations implements PayInterface{
	
	String area;
	String deliever;
	int time;
	int weight;

	
	public Locations(String area, String deliever, int time, int weight) {
		this.area = area;
		this.deliever = deliever;
		this.time = time;
		this.weight = weight;
	}

	@Override
	public int timePerPay() {
		if (this.time < 1) {
			return 1000;
		}else if (this.time <2) {
			return 2000;
		}else if (this.time <3) {
			return 3000;
		}else {
			return 4000;
		}
	}

	@Override
	public int weightPerPay() {
		if (this.weight <101) {
			return 1000;
		}else if (this.weight <201) {
			return 2000;
		}else if (this.weight <301) {
			return 3000;
		}else {
			return 4000;
		}
	}
	
	@Override
	public int totalPayCal() {
		return timePerPay() + weightPerPay();
	}
	
}
