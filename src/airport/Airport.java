package airport;

import aircraft.Aircraft;
import aircraft.AircraftName;
import airport.FieldPoints.Checkpoint;
import airport.FieldPoints.IAircraftPosition;
import airport.control.Tower;
import misc.WindDirection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
        ArrayList<Gate> list = new ArrayList<Gate>();
        for (Gate g : gates) {
            list.add(g);
        }

        return list;
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

    public void addAircrafts(HashMap<Aircraft, IAircraftPosition> m) {
        Iterator it = m.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            addAircraft((Aircraft) pair.getKey(), (IAircraftPosition) pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
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

    public void land(Aircraft a) {
        //TODO implement
    }

    public void land(AircraftName name) {
        land(getAircraftForName(name));
    }

    private Aircraft getAircraftForName(AircraftName name) {
        for (Aircraft a : aircraftPositions.keySet()) {
            if (a.getName() == name) {
                return a;
            }
        }
        throw new RuntimeException("No Aircraft found for Name: " + name);
    }

    public void takeOff(Aircraft a) {
        //TODO implement
    }

    public void takeOff(AircraftName name) {
        takeOff(getAircraftForName(name));
    }
}

