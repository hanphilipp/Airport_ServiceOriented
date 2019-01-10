package airport.control;

import airport.FieldPoints.Checkpoint;

import java.util.ArrayList;

public class Tower {
    private FrequencyArea frequencyArea;


    private ArrayList<Checkpoint> checkpoints;

    public Tower() {
        frequencyArea = FrequencyArea.Tower;
        checkpoints = new ArrayList<>();
        //TODO add correct checkpoints
    }
    //TODO functions including event calls
}
