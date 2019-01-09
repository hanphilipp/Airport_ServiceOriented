package aircraft;

import aircraft.body.Seat;
import aircraft.gear.Gear;
import aircraft.wing.Wing;
import com.google.common.eventbus.Subscribe;
import misc.AutoIdGenerator;
import misc.events.HoldShortEvent;
import misc.events.RunwayClearedForTakeOffEvent;
import misc.events.RunwayClearedToLandEvent;
import misc.events.TaxiEvent;


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
    private double currentFrequency;

    @Subscribe
    public void taxi(TaxiEvent taxiEvent) {//TODO function
        if (taxiEvent.getFrequency() == currentFrequency) {

        }
    }

    @Subscribe
    public void holdShort(HoldShortEvent holdShortEvent) {//TODO function
        if (holdShortEvent.getFrequency() == currentFrequency) {

        }
    }

    @Subscribe
    public void takeOff(RunwayClearedForTakeOffEvent runwayClearedForTakeOffEvent) {//TODO function
        if (runwayClearedForTakeOffEvent.getFrequency() == currentFrequency) {

        }
    }

    @Subscribe
    public void land(RunwayClearedToLandEvent runwayClearedToLandEvent) {//TODO function
        if (runwayClearedToLandEvent.getFrequency() == currentFrequency) {

        }
    }
}
