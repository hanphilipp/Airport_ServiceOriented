package airport.control;

public class ApronControl {
    private FrequencyArea frequencyArea;

    public ApronControl() {
        frequencyArea = FrequencyArea.ApronControl;
    }

    public FrequencyArea getFrequencyArea() {
        return frequencyArea;
    }
}
