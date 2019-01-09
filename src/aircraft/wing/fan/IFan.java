package aircraft.wing.fan;

public interface IFan {
    void start();

    void increaseRPM(int value);

    void decreaseRPM(int value);

    void shutdown();

}
