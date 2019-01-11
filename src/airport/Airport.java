package airport;

import aircraft.Aircraft;
import airport.FieldPoints.Checkpoint;
import airport.FieldPoints.IAircraftPosition;
import airport.control.Tower;
import misc.WindDirection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Airport {
    private String name;
    private Gate[] gates;
    private WindDirection currentWindDirection;
    private Apron apron;
    private Tower tower;
    private HashMap<Aircraft, IAircraftPosition> aircraftPositions;

    public Airport(String name, WindDirection currentWindDirection) {
        this.name = name;
        gates = new Gate[10];
        this.currentWindDirection = currentWindDirection;
        apron = new Apron();
        tower = new Tower();
        aircraftPositions = new HashMap<Aircraft, IAircraftPosition>();
    }

    public Gate[] getGates() {
        return gates;
    }

    public ArrayList<Gate> getGatesList() {
        return new ArrayList<>().addAll(gates);
    }

    public String getName() {
        return name;
    }

    //TODO Functions
    public void addAircraft(Aircraft a, IAircraftPosition c) {
        aircraftPositions.put(a, c);
        c.setAircraft(a);
    }

    public void addAircraft(Aircraft a) {
        addAircraft(a, tower.getAir());
    }

    public void addAircrafts(Map<Aircraft, IAircraftPosition> m) {
        for (Map.Entry<Aircraft, IAircraftPosition> e : m) {
            addAircraft(e.getKey(), e.getValue());
        }
    }

    public boolean removeAircraft(Aircraft a) {
        IAircraftPosition c = aircraftPositions.remove(a);
        if (c != null) {
            if (a == c.removeAircraft()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Checkpoint> getAllCheckpoints() {
        ArrayList c = tower.getCheckpoints();
        c.addAll(apron.getCheckpoints());
        c.add(tower.getAir());
        return c;
    }
}

