package airport.FieldPoints;

import airport.ControlArea;

public class Intersection extends Checkpoint {
    private Checkpoint startCheckpoint;
    private Checkpoint endCheckpoint;
    private IntersectionName name;
    public Intersection(int id, IntersectionName name, ControlArea controlArea, Checkpoint startCheckpoint, Checkpoint endCheckpoint) {
        super(id, null, controlArea);
        this.startCheckpoint = startCheckpoint;
        this.endCheckpoint = endCheckpoint;
    }

    public Checkpoint getStartCheckpoint() {
        return startCheckpoint;
    }

    public Checkpoint getEndCheckpoint() {
        return endCheckpoint;
    }

    @Override
    public CheckpointName getName() {
        throw new RuntimeException("Cannot get CheckpointName for Intersection");
    }

    public IntersectionName getIntersectionName() {
        return name;
    }
}
