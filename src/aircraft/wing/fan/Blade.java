package aircraft.wing.fan;

import misc.AutoIdGenerator;

public class Blade {
    private long id;
    private Material material;

    public Blade(Material material) {
        this.material = material;
        id = AutoIdGenerator.get();
    }
}
