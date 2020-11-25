package testPractice_Teacher;

public class WirelessClass implements WirelessInterface{
	
    @Override
    public int discountRateMethod(int basePrice) {
    	return   (int) (basePrice * 0.1);
    	
    }
    @Override
    public int communicationFeeMethod(int unitPrice, int useTime, int basePrice, int discountRate) {
    	 //시간당단가 * 사용시간 + 기본요금 - 할인요금
    	return (int)  (unitPrice * useTime + basePrice -  discountRate);
    }
    public void input(String cN, int uT) {
    	
    }
	public void output() {
		
		
	}
}
