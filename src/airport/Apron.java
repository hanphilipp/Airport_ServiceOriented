package airport;

import aircraft.Aircraft;
import airport.FieldPoints.*;
import airport.control.ApronControl;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;

public class Apron {
    private ApronControl control;
    private ArrayList<Checkpoint> checkpoints;
    public Apron() {
        control = new ApronControl();
        checkpoints = new ArrayList<>();
        generateCheckpoints();
    }

    public ApronControl getControl() {
        return control;
    }

    private void generateCheckpoints() {
        Checkpoint o1 = new Checkpoint(CheckpointName.O1, ControlArea.Apron);
        checkpoints.add(o1);
        Checkpoint o2 = new Checkpoint(CheckpointName.O2, ControlArea.Apron);
        checkpoints.add(o2);
        Checkpoint o3 = new Checkpoint(CheckpointName.O3, ControlArea.Apron);
        checkpoints.add(o3);
        Checkpoint o4 = new Checkpoint(CheckpointName.O4, ControlArea.Apron);
        checkpoints.add(o4);
        Checkpoint o5 = new Checkpoint(CheckpointName.O5, ControlArea.Apron);
        checkpoints.add(o5);
        Checkpoint o6 = new Checkpoint(CheckpointName.O6, ControlArea.Apron);
        checkpoints.add(o6);

        Checkpoint n1 = new Checkpoint(CheckpointName.N1, ControlArea.Apron);
        checkpoints.add(n1);
        Checkpoint n2 = new Checkpoint(CheckpointName.N2, ControlArea.Apron);
        checkpoints.add(n2);
        Checkpoint n3 = new Checkpoint(CheckpointName.N3, ControlArea.Apron);
        checkpoints.add(n3);
        Checkpoint n4 = new Checkpoint(CheckpointName.N4, ControlArea.Apron);
        checkpoints.add(n4);
        Checkpoint n5 = new Checkpoint(CheckpointName.N5, ControlArea.Apron);
        checkpoints.add(n5);
        Checkpoint n6 = new Checkpoint(CheckpointName.N6, ControlArea.Apron);
        checkpoints.add(n6);

        Checkpoint m1 = new Checkpoint(CheckpointName.M1, ControlArea.Apron);
        checkpoints.add(m1);
        Checkpoint m2 = new Checkpoint(CheckpointName.M2, ControlArea.Apron);
        checkpoints.add(m2);
        Checkpoint m3 = new Checkpoint(CheckpointName.M3, ControlArea.Apron);
        checkpoints.add(m3);
        Checkpoint m4 = new Checkpoint(CheckpointName.M4, ControlArea.Apron);
        checkpoints.add(m4);
        Checkpoint m5 = new Checkpoint(CheckpointName.M5, ControlArea.Apron);
        checkpoints.add(m5);
        Checkpoint m6 = new Checkpoint(CheckpointName.M6, ControlArea.Apron);
        checkpoints.add(m6);

        Checkpoint l1 = new Checkpoint(CheckpointName.L1, ControlArea.Apron);
        checkpoints.add(l1);
        Checkpoint l2 = new Checkpoint(CheckpointName.L2, ControlArea.Apron);
        checkpoints.add(l2);
        Checkpoint l3 = new Checkpoint(CheckpointName.L3, ControlArea.Apron);
        checkpoints.add(l3);
        Checkpoint l4 = new Checkpoint(CheckpointName.L4, ControlArea.Apron);
        checkpoints.add(l4);
        Checkpoint l5 = new Checkpoint(CheckpointName.L5, ControlArea.Apron);
        checkpoints.add(l5);
        Checkpoint l6 = new Checkpoint(CheckpointName.L6, ControlArea.Apron);
        checkpoints.add(l6);

        checkpoints.add(new Crossway(CrosswayName.X1, ControlArea.Apron, o2, m1));
        checkpoints.add(new Crossway(CrosswayName.X2, ControlArea.Apron, n2, m1));
        checkpoints.add(new Crossway(CrosswayName.X3, ControlArea.Apron, o2, l1));
        checkpoints.add(new Crossway(CrosswayName.X4, ControlArea.Apron, n2, l1));
        checkpoints.add(new Crossway(CrosswayName.X5, ControlArea.Apron, l2, n1));
        checkpoints.add(new Crossway(CrosswayName.X6, ControlArea.Apron, l2, o1));
        checkpoints.add(new Crossway(CrosswayName.X7, ControlArea.Apron, m2, o1));
        checkpoints.add(new Crossway(CrosswayName.X8, ControlArea.Apron, m2, n1));
        checkpoints.add(new Crossway(CrosswayName.X9, ControlArea.Apron, o5, m6));
        checkpoints.add(new Crossway(CrosswayName.X10, ControlArea.Apron, n5, m6));
        checkpoints.add(new Crossway(CrosswayName.X11, ControlArea.Apron, o5, l6));
        checkpoints.add(new Crossway(CrosswayName.X12, ControlArea.Apron, n5, l6));
        checkpoints.add(new Crossway(CrosswayName.X13, ControlArea.Apron, l5, o6));
        checkpoints.add(new Crossway(CrosswayName.X14, ControlArea.Apron, l5, n6));
        checkpoints.add(new Crossway(CrosswayName.X15, ControlArea.Apron, m5, o6));
        checkpoints.add(new Crossway(CrosswayName.X16, ControlArea.Apron, m5, n6));
    }

    public ArrayList<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public void moveAircraft(EventBus bus, Aircraft a, ArrayList<IAircraftPosition> positions) {
        //TODO implement
    }
}
