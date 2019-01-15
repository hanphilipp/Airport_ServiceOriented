package airport.control.events;

import aircraft.Aircraft;

public class RunwayClearedForTakeOffEvent extends AirportEvent {
    public RunwayClearedForTakeOffEvent(double frequency, Aircraft aircraft) {
        super(frequency, aircraft);
    }
}
