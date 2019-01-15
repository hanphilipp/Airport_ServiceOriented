package airport.control.events;

import aircraft.Aircraft;

public class HoldShortEvent extends AirportEvent {
    public HoldShortEvent(double frequency, Aircraft aircraft) {
        super(frequency, aircraft);
    }
}
