package airport;

public class Airport {
    private String name;
    private Gate[] gates;

    public Airport(String name) {
        this.name = name;
        gates = new Gate[10];
    }

    public String getName() {
        return name;
    }

    //TODO Functions
}
