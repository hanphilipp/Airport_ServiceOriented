package airport.control.events;


import aircraft.Aircraft;
import airport.FieldPoints.IAircraftPosition;

import java.util.ArrayList;

public class TaxiEvent extends AirportEvent {
    private ArrayList<IAircraftPosition> positions;

    public TaxiEvent(double frequency, Aircraft aircraft, ArrayList<IAircraftPosition> positions) {
        super(frequency, aircraft);
        this.positions = positions;
    }

    public ArrayList<IAircraftPosition> getPositions() {
        return positions;
    }

    public String toString() {
        String s = this.getClass() + " (" + frequency + ", " + aircraft + ")\n";
        for (IAircraftPosition p : positions) {
            s += p.getNameString();
            if (positions.get(positions.size() - 1) != p) {
                s += "->";
            }
        }
        return s;
    }
}
