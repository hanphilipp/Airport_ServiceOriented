package aircraft.body;

import misc.AutoIdGenerator;

public class Seat {
    private BookingClass bookingClass;
    private long id;

    public Seat(BookingClass bookingClass) {
        this.bookingClass = bookingClass;
        id = AutoIdGenerator.get();
    }
    //TODO Passagier

    //TODO Functions
}
