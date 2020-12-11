public class BackSeats extends Parent{
    public BackSeats(String custName, String seat) {
        super(custName, seat);
    }

    @Override
    public int ticketPrice(String seat) {
        if(seat.contains("1") || seat.contains("4")){
            return super.ticketPrice(seat) + 1000;
        }else if(seat.contains("2") || seat.contains("3"))
            return super.ticketPrice(seat) + 500;
        return super.ticketPrice(seat);
    }
}