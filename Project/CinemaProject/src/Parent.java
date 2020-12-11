public class Parent implements Interface{
    protected String custName;
    protected String seat;
    protected int price;


    Parent(String custName, String seat){
        this.custName = custName;
        this.seat = seat;
    }//end parent


    @Override
    public int ticketPrice(String seat) {
        if(seat.contains("A") || seat.contains("a")){
            price = 7000;
        }
        else if(seat.contains("B") || seat.contains("b")){
            price = 10000;
        }
        return price;
    }
}//end class