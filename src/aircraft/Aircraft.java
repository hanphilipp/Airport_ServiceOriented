package aircraft;

import aircraft.body.Seat;
import aircraft.gear.Gear;
import aircraft.wing.Wing;
import com.google.common.eventbus.Subscribe;
import misc.AutoIdGenerator;


public class Aircraft {
    private long id;
    private String manufacturer;
    private int numberOfSeatFirstClass;
    private int numberOfSeatBusinessClass;
    private int numberOfSeatEconomyClass;
    private Seat[] seats;
    private Wing[] wings;
    private Gear[] gears;

    public Aircraft(String manufacturer) {
        this.manufacturer = manufacturer;
        seats = new Seat[568];
        wings = new Wing[2];
        gears = new Gear[5];
        id = AutoIdGenerator.get();
    }

    //TODO facades
    @Subscribe
    public void taxi() {//TODO Event
    }

    @Subscribe
    public void holdShort() {//TODO Event
    }

    @Subscribe
    public void takeOff() {//TODO Event
    }

    @Subscribe
    public void land() {//TODO Event
    }
}
