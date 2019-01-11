package airport.control;

import airport.ControlArea;
import airport.FieldPoints.Checkpoint;
import airport.FieldPoints.CheckpointName;

import java.util.ArrayList;

public class Tower {
    private FrequencyArea frequencyArea;


    private ArrayList<Checkpoint> checkpoints;
    private Checkpoint air;

    public Tower() {
        frequencyArea = FrequencyArea.Tower;
        checkpoints = new ArrayList<>();
        air = new Checkpoint(CheckpointName.AIR, ControlArea.Tower);
        generateCheckpoints();
    }

    public Checkpoint getAir() {
        return air;
    }

    private void generateCheckpoints() {
        checkpoints.add(new Checkpoint(CheckpointName.L08, ControlArea.Tower));
        checkpoints.add(new Checkpoint(CheckpointName.L26, ControlArea.Tower));
        checkpoints.add(new Checkpoint(CheckpointName.R08, ControlArea.Tower));
        checkpoints.add(new Checkpoint(CheckpointName.R26, ControlArea.Tower));

    }

    public FrequencyArea getFrequencyArea() {
        return frequencyArea;
    }

    public ArrayList<Checkpoint> getCheckpoints() {
        return checkpoints;
    }
//TODO functions including event calls
}
