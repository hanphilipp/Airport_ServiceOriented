public class Airport {
    public Airport(String name) {
        this.name = name;
        gates=new Gate[10];
    }

    public String getName() {
        return name;
    }

    private String name;
    private Gate[] gates;

    //TODO Functions
}
