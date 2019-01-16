package airport;

import aircraft.Aircraft;
import aircraft.AircraftName;
import airport.FieldPoints.Checkpoint;
import airport.FieldPoints.IAircraftPosition;
import airport.control.FrequencyArea;
import airport.control.Tower;
import com.google.common.eventbus.EventBus;
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
    private EventBus eventBus;

    public Airport(String name, WindDirection currentWindDirection) {
        this.name = name;
        gates = new Gate[10];
        generateGates();
        this.currentWindDirection = currentWindDirection;
        apron = new Apron();
        tower = new Tower();
        aircraftPositions = new HashMap<Aircraft, IAircraftPosition>();
        eventBus = new EventBus();
    }

    private void generateGates() {
        gates[0] = new Gate(GateName.A01);
        gates[1] = new Gate(GateName.A02);
        gates[2] = new Gate(GateName.A03);
        gates[3] = new Gate(GateName.A04);
        gates[4] = new Gate(GateName.A05);
        gates[5] = new Gate(GateName.B01);
        gates[6] = new Gate(GateName.B02);
        gates[7] = new Gate(GateName.B03);
        gates[8] = new Gate(GateName.B04);
        gates[9] = new Gate(GateName.B05);
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
        eventBus.register(a);
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
                eventBus.unregister(a);
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
        ArrayList<IAircraftPosition> pos = new ArrayList<>();
        pos.add(aircraftPositions.get(a));
        pos.add(findLandingStrip());
        pos.add(findGate());
        moveAircraft(a, pos);
    }

    private Checkpoint findLandingStrip() {
        for (Checkpoint c : tower.getCheckpoints()) {
            if (!aircraftPositions.containsValue(c)) {
                return c;
            }
        }
        return null;
    }

    private Gate findGate() {
        for (Gate g : gates) {
            if (!aircraftPositions.containsValue(g)) {
                return g;
            }
        }
        return null;
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
        ArrayList<IAircraftPosition> pos = new ArrayList<>();
        pos.add(aircraftPositions.get(a));
        pos.add(tower.getAir());
        moveAircraft(a, pos);
    }

    public void takeOff(AircraftName name) {
        takeOff(getAircraftForName(name));
    }

    public void moveAircraft(Aircraft a, ArrayList<IAircraftPosition> positions) {
        ArrayList<IAircraftPosition> towerPositions = new ArrayList<>();
        ArrayList<IAircraftPosition> apronPositions = new ArrayList<>();
        for (IAircraftPosition p : positions) {
            if (tower.getCheckpoints().contains(p)) {
                towerPositions.add(p);
            }
            if (apron.getCheckpoints().contains(p)) {
                apronPositions.add(p);
            }
        }
        if (towerPositions.size() > 0 && positions.get(0) == towerPositions.get(0)) {
            tower.moveAircraft(eventBus, a, towerPositions);
            a.setCurrentFrequency(FrequencyArea.getFrequencyForArea(FrequencyArea.ApronControl));
            apron.moveAircraft(eventBus, a, apronPositions);
        }
        if (apronPositions.size() > 0 && positions.get(0) == apronPositions.get(0)) {
            tower.moveAircraft(eventBus, a, towerPositions);
            a.setCurrentFrequency(FrequencyArea.getFrequencyForArea(FrequencyArea.Tower));
            apron.moveAircraft(eventBus, a, apronPositions);
        }
        aircraftPositions.replace(a, positions.get(positions.size() - 1));
    }

    public double[] getFrequencies() {
        double[] f = new double[2];
        f[0] = FrequencyArea.getFrequencyForArea(tower.getFrequencyArea());
        f[1] = FrequencyArea.getFrequencyForArea(apron.getControl().getFrequencyArea());
        return f;
    }

    public void printAircraftPositions() {
        Aircraft a;
        IAircraftPosition p;
        System.out.println("---------------------------------------------------------------");
        for (Map.Entry e : aircraftPositions.entrySet()) {
            a = (Aircraft) e.getKey();
            p = (IAircraftPosition) e.getValue();
            System.out.println(a.getName() + " : " + p.getNameString());
        }
        System.out.println("---------------------------------------------------------------");

    }
}

