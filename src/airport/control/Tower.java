package airport.control;

import airport.ControlArea;
import airport.FieldPoints.Checkpoint;
import airport.FieldPoints.CheckpointName;

import java.util.ArrayList;

public class Tower {
    private FrequencyArea frequencyArea;


    private ArrayList<Checkpoint> checkpoints;

    public Checkpoint getAir() {
        return air;
    }

    private Checkpoint air;

    public Tower() {
        frequencyArea = FrequencyArea.Tower;
        checkpoints = new ArrayList<>();
        air=new Checkpoint(0,CheckpointName.AIR, ControlArea.Tower);
        //TODO add correct checkpoints
    }

    public FrequencyArea getFrequencyArea() {
        return frequencyArea;
    }

    public ArrayList<Checkpoint> getCheckpoints() {
        return checkpoints;
    }
//TODO functions including event calls
}
