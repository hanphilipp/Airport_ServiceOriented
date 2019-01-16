package airport;

import aircraft.Aircraft;
import airport.FieldPoints.IAircraftPosition;

public class Gate implements IAircraftPosition {
    private boolean isOpen;
    private GateName name;
    private Aircraft aircraft;

    public Gate(GateName name) {
        this.name = name;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public GateName getName() {
        return name;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    @Override
    public void setAircraft(Aircraft a) {
        aircraft = a;
    }

    @Override
    public Aircraft removeAircraft() {
        Aircraft temp = aircraft;
        aircraft = null;
        return temp;
    }

    @Override
    public String getNameString() {
        return name.toString();
    }

    //TODO Functions
}
