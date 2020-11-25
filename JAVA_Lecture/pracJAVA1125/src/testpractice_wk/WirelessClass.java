package testpractice_wk;

public class WirelessClass implements WirelessInterface{
    String custName;
    String gradeCode;
    int basePrice;//기본요금
    int timeFee;//시간당 단가
    int useTime;//사용시간
    int discountPrice;//할인요금
    int totalFee;




    @Override
    public int discountRate() {
        return discountPrice = (int)(basePrice * 0.1);
    }

    @Override
    public int communicationFee() {
        return totalFee = ((timeFee * useTime) + basePrice) - discountRate();
    }

    WirelessClass(String gradeCode,String custName, int timeFee, int basePrice, int useTime){
        this.gradeCode = gradeCode;
        this.custName = custName;
        this.timeFee = timeFee;
        this.basePrice = basePrice;
        this.useTime = useTime;
    }//end wireClass

}
