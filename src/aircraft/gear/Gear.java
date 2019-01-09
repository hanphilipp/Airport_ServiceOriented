package aircraft.gear;

public class Gear implements IGear {
    private GearType type;
    private boolean isDown;
    private boolean isBrakeSet;
    private Wheel[] wheels;

    public Gear(GearType type, int numberOfWheels) {
        this.type = type;
        if (numberOfWheels <= 6 && numberOfWheels >= 2) {
            wheels = new Wheel[numberOfWheels];
        } else {
            throw new RuntimeException("Number of Wheels must be between 2 and 6");
        }
    }

    //TODO Functions
    @Override
    public void up() {

    }

    @Override
    public void down() {

    }

    @Override
    public void setBrake() {

    }

    @Override
    public void releaseBrake() {

    }
}
