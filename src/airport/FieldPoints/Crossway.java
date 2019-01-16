package airport.FieldPoints;

import airport.ControlArea;

public class Crossway extends Checkpoint {
    private Checkpoint startCheckpoint;
    private Checkpoint endCheckpoint;
    private CrosswayName name;

    public Crossway(CrosswayName name, ControlArea controlArea, Checkpoint startCheckpoint, Checkpoint endCheckpoint) {
        super(null, controlArea);
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
        throw new RuntimeException("Cannot get CheckpointName for Crossway");
    }

    public CrosswayName getCrosswayName() {
        return name;
    }

    @Override
    public String getNameString() {
        return name.toString();
    }
}
