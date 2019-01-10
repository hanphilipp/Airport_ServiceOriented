package airport;

import misc.WindDirection;

public class Airport {
    private String name;
    private Gate[] gates;
    private WindDirection currentWindDirection;

    public Airport(String name, WindDirection currentWindDirection) {
        this.name = name;
        gates = new Gate[10];
    }

    public String getName() {
        return name;
    }

    //TODO Functions
}
