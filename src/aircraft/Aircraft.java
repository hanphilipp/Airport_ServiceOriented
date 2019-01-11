package aircraft;

import aircraft.body.Seat;
import aircraft.gear.Gear;
import aircraft.wing.Wing;
import airport.control.events.*;
import com.google.common.eventbus.Subscribe;
import misc.AutoIdGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;


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
    private AircraftName name;

    public Aircraft(String manufacturer, AircraftName name) {
        this.manufacturer = manufacturer;
        this.name = name;
        seats = new Seat[568];
        wings = new Wing[2];
        gears = new Gear[5];
        id = AutoIdGenerator.get();
    }

    public long getId() {
        return id;
    }

    public double getCurrentFrequency() {
        return currentFrequency;
    }

    public AircraftName getName() {
        return name;
    }

    private void writeEventLog(AirportEvent event) {
        File logFile = new File("AircraftLogs/" + name + ".txt");

        ArrayList<String> lines = new ArrayList<String>();
        if (!logFile.exists()) {
            logFile.mkdirs();
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(logFile));
                String l;
                while ((l = br.readLine()) != null) {
                    lines.add(l);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        lines.add("\n" + new Date() + " : " + event);

        Path file = Paths.get(logFile.getAbsolutePath());
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Subscribe
    public void taxi(TaxiEvent taxiEvent) {//TODO function
        if (taxiEvent.getFrequency() == currentFrequency) {
            writeEventLog(taxiEvent);
        }
    }

    @Subscribe
    public void holdShort(HoldShortEvent holdShortEvent) {//TODO function
        if (holdShortEvent.getFrequency() == currentFrequency) {
            writeEventLog(holdShortEvent);
        }
    }

    @Subscribe
    public void takeOff(RunwayClearedForTakeOffEvent runwayClearedForTakeOffEvent) {//TODO function
        if (runwayClearedForTakeOffEvent.getFrequency() == currentFrequency) {
            writeEventLog(runwayClearedForTakeOffEvent);
        }
    }

    @Subscribe
    public void land(RunwayClearedToLandEvent runwayClearedToLandEvent) {//TODO function
        if (runwayClearedToLandEvent.getFrequency() == currentFrequency) {
            writeEventLog(runwayClearedToLandEvent);
        }
    }
}
