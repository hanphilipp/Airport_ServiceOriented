package aircraft;

import com.google.common.eventbus.Subscribe;
import misc.AutoIdGenerator;
import org.w3c.dom.events.Event;


public class Aircraft {
    private long id;
    private String manufacturer;
    private int numberOfSeatFirstClass;
    private int numberOfSeatBusinessClass;
    private int numberOfSeatEconomyClass;
    private Seat[] seats;

    public Aircraft(String manufacturer) {
        this.manufacturer = manufacturer;
        seats = new Seat[568];
        id = AutoIdGenerator.get();
    }

    //TODO functions
    @Subscribe
    public void record(Event e) {
        //Dummy
    }
}
