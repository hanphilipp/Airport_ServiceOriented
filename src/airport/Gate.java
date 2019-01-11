package airport;

import aircraft.Aircraft;
import airport.FieldPoints.IAircraftPosition;

public class Gate implements IAircraftPosition {
    private boolean isOpen;

    public boolean isOpen() {
        return isOpen;
    }

    public GateName getName() {
        return name;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    private GateName name;
    private Aircraft aircraft;

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

    //TODO Functions
}
