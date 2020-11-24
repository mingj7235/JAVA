package grade_Manage;

public class View {
	public static void main(String[] args) {
		Business business = new Business();
		boolean flag = true;
		while(flag) {
			switch (business.main()) {
			case 1:
				business.input(business.choiceSc());
				break;
			case 2:
				business.output(business.choiceSc());
				break;

			default:
				break;
			}
		}
	}
}
