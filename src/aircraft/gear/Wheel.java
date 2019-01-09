package aircraft.gear;

import misc.AutoIdGenerator;

public class Wheel {
    private long id;
    private int diameter;

    public Wheel(int diameter) {
        this.diameter = diameter;
        id = AutoIdGenerator.get();
    }
}
