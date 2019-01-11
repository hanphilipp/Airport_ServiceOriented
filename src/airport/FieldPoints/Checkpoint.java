package airport.FieldPoints;

import aircraft.Aircraft;
import airport.ControlArea;

public class Checkpoint implements IAircraftPosition{
    public Aircraft currentAircraft;
    private int id;
    private CheckpointName name;
    private ControlArea controlArea;
    public Checkpoint(int id, CheckpointName name, ControlArea controlArea) {
        this.id = id;
        this.name = name;
        this.controlArea = controlArea;
    }

    public int getId() {
        return id;
    }

    public CheckpointName getName() {
        return name;
    }

    public ControlArea getControlArea() {
        return controlArea;
    }

    @Override
    public void setAircraft(Aircraft a) {
        currentAircraft=a;
    }

    @Override
    public Aircraft removeAircraft() {
        Aircraft temp=currentAircraft;
        currentAircraft=null;
        return temp;
    }
}
