package airport.control.events;

public abstract class AirportEvent {//TODO possibly add functions for all events
    private double frequency;

    public AirportEvent(double frequency) {
        this.frequency = frequency;
    }

    public double getFrequency() {
        return frequency;
    }
}
