package airport.control.events;

import aircraft.Aircraft;

public class RunwayClearedToLandEvent extends AirportEvent {
    public RunwayClearedToLandEvent(double frequency, Aircraft aircraft) {
        super(frequency, aircraft);
    }
}
