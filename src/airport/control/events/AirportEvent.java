package airport.control.events;

import aircraft.Aircraft;

public abstract class AirportEvent {//TODO possibly add functions for all events
    protected double frequency;
    protected Aircraft aircraft;

    public AirportEvent(double frequency, Aircraft aircraft) {
        this.frequency = frequency;
        this.aircraft = aircraft;
    }

    public double getFrequency() {
        return frequency;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    @Override
    public String toString() {
        return this.getClass() + " (" + frequency + ", " + aircraft + ")";
    }
}
