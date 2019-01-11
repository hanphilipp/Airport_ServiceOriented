package airport.FieldPoints;

import aircraft.Aircraft;

public interface IAircraftPosition {
    public void setAircraft(Aircraft a);

    public Aircraft removeAircraft();
}
