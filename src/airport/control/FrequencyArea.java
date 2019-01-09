package airport.control;

public enum FrequencyArea {
    ApronControl, Tower;

    public static double getFrequencyForArea(FrequencyArea area) {
        if (area == FrequencyArea.ApronControl) {
            return 121.5;
        } else if (area == FrequencyArea.Tower) {
            return 128.5;
        }
        throw new RuntimeException("Unknown frequency area");
    }
}
