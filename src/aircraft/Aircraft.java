import com.google.common.eventbus.Subscribe;
import org.w3c.dom.events.Event;


public class Aircraft {
    private int id;
    private String manufacturer;
    private int numberOfSeatFirstClass;
    private int numberOfSeatBusinessClass;
    private int numberOfSeatEconomyClass;

    //TODO functions
    @Subscribe
    public void record(Event e) {
        //Dummy
    }
}
