package aircraft.wing;

import aircraft.wing.fan.Fan;
import aircraft.wing.flap.Flap;

public class Wing {
    private WingPosition wingPosition;
    private Fan[] fans;
    private Flap[] flaps;

    public Wing() {
        fans = new Fan[2];
        flaps = new Flap[2];

    }
}
