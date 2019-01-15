package airport.control.events;


import aircraft.Aircraft;

public class TaxiEvent extends AirportEvent {
    public TaxiEvent(double frequency, Aircraft aircraft) {
        super(frequency, aircraft);
    }
}
