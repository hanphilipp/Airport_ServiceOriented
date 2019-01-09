package misc;

public class AutoIdGenerator {
    private static long currentID;

    public static long get() {
        return currentID++;
    }
}
