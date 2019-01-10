package airport;

import airport.FieldPoints.Checkpoint;
import airport.control.ApronControl;

import java.util.ArrayList;

public class Apron {
    private ApronControl control;
    private ArrayList<Checkpoint> checkpoints;
    public Apron() {
        control = new ApronControl();
        checkpoints = new ArrayList<>();
        //TODO add correct checkpoints
    }
}
