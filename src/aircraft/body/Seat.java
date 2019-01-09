package aircraft.body;

import misc.AutoIdGenerator;
import misc.Passenger;

public class Seat {
    private BookingClass bookingClass;
    private long id;
    private Passenger passenger;

    public Seat(BookingClass bookingClass) {
        this.bookingClass = bookingClass;
        id = AutoIdGenerator.get();
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    //TODO Functions
}
