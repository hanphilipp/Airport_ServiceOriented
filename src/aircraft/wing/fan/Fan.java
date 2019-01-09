package aircraft.wing.fan;

import misc.AutoIdGenerator;

public class Fan {
    private long id;
    private int rpm;
    private Blade[] blades;

    public Fan(Material bladeMaterial) {
        id = AutoIdGenerator.get();
        blades = new Blade[96];
        generateBlades(bladeMaterial);
    }

    private void generateBlades(Material m) {
        for (int i = 0; i < blades.length; i++) {
            blades[i] = new Blade(m);
        }
    }
//TODO Functions
}
