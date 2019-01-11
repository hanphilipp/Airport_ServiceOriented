package airport.control.events;

public class RunwayClearedForTakeOffEvent extends AirportEvent {
    public RunwayClearedForTakeOffEvent(double frequency) {
        super(frequency);
    }
}
