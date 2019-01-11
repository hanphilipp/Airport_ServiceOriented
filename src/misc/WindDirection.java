package misc;

public enum WindDirection {
    EastWest, WestEast;

    public static WindDirection random() {
        double rNum;
        while (true) {
            for (WindDirection w : WindDirection.values()) {
                rNum = Math.random();
                if (rNum > 0.5) {
                    return w;
                }
            }
        }
    }
}
