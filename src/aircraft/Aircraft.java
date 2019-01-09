package aircraft;

import aircraft.body.Seat;
import aircraft.gear.Gear;
import aircraft.wing.Wing;
import airport.control.events.HoldShortEvent;
import airport.control.events.RunwayClearedForTakeOffEvent;
import airport.control.events.RunwayClearedToLandEvent;
import airport.control.events.TaxiEvent;
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
    //TODO facades
    private double currentFrequency;

    public Aircraft(String manufacturer) {
        this.manufacturer = manufacturer;
        seats = new Seat[568];
        wings = new Wing[2];
        gears = new Gear[5];
        id = AutoIdGenerator.get();
    }

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
